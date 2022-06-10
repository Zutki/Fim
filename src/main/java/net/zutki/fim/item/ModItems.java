package net.zutki.fim.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.zutki.fim.Fim;

import net.minecraft.util.registry.Registry;
import net.zutki.fim.item.custom.ModBucketItem;
import net.zutki.fim.item.custom.ModHoeItem;

public class ModItems {
    // TODO:
    // Do this with a for loop, this is stupid

    // WHEAT

    public static final Item WHEAT_HOE = registerItem("wheat_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
            new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON), 1, "Wheat Crops"));

    public static final Item SUPER_WHEAT_HOE = registerItem("super_wheat_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.RARE), 3, "Wheat Crops"));

    public static final Item SUPREME_WHEAT_HOE = registerItem("supreme_wheat_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC), 5, "Wheat Crops"));

    // CARROTS

    public static final Item CARROT_HOE = registerItem("carrot_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON), 1, "Carrots"));

    public static final Item SUPER_CARROT_HOE = registerItem("super_carrot_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.RARE), 3, "Carrots"));

    public static final Item SUPREME_CARROT_HOE = registerItem("supreme_carrot_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC), 5, "Carrots"));

    // POTATOES

    public static final Item POTATO_HOE = registerItem("potato_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON), 1, "Potatoes"));

    public static final Item SUPER_POTATO_HOE = registerItem("super_potato_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.RARE), 3, "Potatoes"));

    public static final Item SUPREME_POTATO_HOE = registerItem("supreme_potato_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC), 5, "Potatoes"));

    // BEETROOT

    public static final Item BEETROOT_HOE = registerItem("beetroot_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON), 1, "Beetroots"));

    public static final Item SUPER_BEETROOT_HOE = registerItem("super_beetroot_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.RARE), 3, "Beetroots"));

    public static final Item SUPREME_BEETROOT_HOE = registerItem("supreme_beetroot_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC), 5, "Beetroots"));

    // OMNIHOE
    /*public static final Item OMNIHOE = registerItem("omni_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 1, 4,
                    new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC), 5, "Beetroots"));*/

    // OTHER

    public static final Item INFINITE_WATER_BUCKET = registerItem("infinite_water_bucket",
            new ModBucketItem(new FabricItemSettings().group(ItemGroup.MISC)));

    // METHODS

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Fim.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Fim.LOGGER.info("Registering Mod Items for " + Fim.MOD_ID);
    }
}
