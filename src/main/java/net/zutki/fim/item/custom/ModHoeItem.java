package net.zutki.fim.item.custom;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ModHoeItem extends HoeItem {
    private int harvestRange; // the area around the block which will be harvested

    public ModHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings, int harvestRange) {
        super(material, attackDamage, attackSpeed, settings);
        this.harvestRange = harvestRange;
    }

    public int getHarvestRange() { return harvestRange; }
    public void setHarvestRange(int newRange) { this.harvestRange = newRange; }

    // this is run after the block is broken, currently used to update the tools damage value
    // also I have no clue what the fuck it does
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        //System.out.println(pos);
        // HOW THIS WORKS
        // first we make sure that we are not the client, we are doing this as the server
        // (getHardness) then, we make sure that whatever we are breaking is not an insta-break block (ex, wheat, grass)
        if (!world.isClient && state.getHardness(world, pos) != 0.0f) {
            stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos;
        World world = context.getWorld();
        Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = TILLING_ACTIONS.get(world.getBlockState(blockPos = context.getBlockPos()).getBlock());

        // breaks wheat in an area around the clicked block
        BlockPos harvestBlockPos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()); // instance it because java be funky at times
        if (!world.isClient) { // make sure we are not running as client
            for (int i = -harvestRange; i < harvestRange + 1; i++) {
                for (int j = -harvestRange; j < harvestRange + 1; j++) {
                    BlockState block = world.getBlockState(harvestBlockPos.add(j, 0, i)); // create an instance
                    if (block.getBlock() instanceof CropBlock cBlock && // make sure it's a CropBlock
                            cBlock.getName().getString().equals("Wheat Crops") && // make sure it's wheat
                            cBlock.isMature(block)) { // make sure it's fully grown

                        world.breakBlock(harvestBlockPos.add(j, 0, i), true, context.getPlayer()); // break it
                        world.setBlockState(harvestBlockPos.add(j, 0, i), cBlock.getDefaultState()); // place a wheat block
                    }
                }
            }
        }

        if (pair == null) {
            return ActionResult.PASS;
        }
        Predicate<ItemUsageContext> predicate = pair.getFirst();
        Consumer<ItemUsageContext> consumer = pair.getSecond();
        if (predicate.test(context)) {
            PlayerEntity playerEntity = context.getPlayer();
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0f, 1.0f);

            if (!world.isClient) {
                consumer.accept(context);
                if (playerEntity != null) {
                    context.getStack().damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
                }
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }
}
