package net.zutki.fim.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.HayBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zutki.fim.Fim;

public class ModBlocks {
    public static final Block COMPRESSED_HAY = registerBlock("compressed_hay",
            new HayBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(0.5f).sounds(BlockSoundGroup.GRASS)),
            ItemGroup.BUILDING_BLOCKS);

    // CARROTS

    public static final Block BARREL_OF_CARROTS = registerBlock("barrel_of_carrots",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).sounds(BlockSoundGroup.WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block COMPRESSED_BARREL_OF_CARROTS = registerBlock("compressed_barrel_of_carrots",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).sounds(BlockSoundGroup.WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    // POTATOES

    public static final Block BARREL_OF_POTATOES = registerBlock("barrel_of_potatoes",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).sounds(BlockSoundGroup.WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block COMPRESSED_BARREL_OF_POTATOES = registerBlock("compressed_barrel_of_potatoes",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).sounds(BlockSoundGroup.WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    // BEETROOTS

    public static final Block BARREL_OF_BEETROOTS = registerBlock("barrel_of_beetroots",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).sounds(BlockSoundGroup.WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block COMPRESSED_BARREL_OF_BEETROOTS = registerBlock("compressed_barrel_of_beetroots",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).sounds(BlockSoundGroup.WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Fim.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Fim.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        Fim.LOGGER.info("Registering ModBlocks for " + Fim.MOD_ID);
    }
}
