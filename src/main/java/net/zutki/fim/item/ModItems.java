package net.zutki.fim.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.zutki.fim.Fim;

import net.minecraft.util.registry.Registry;
import net.zutki.fim.item.custom.ModHoeItem;

public class ModItems {
    public static final Item WHEAT_HOE = registerItem("wheat_hoe",
            new ModHoeItem(ToolMaterials.DIAMOND, 4, 1,
            new FabricItemSettings().group(ItemGroup.TOOLS), 1));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Fim.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Fim.LOGGER.info("Registering Mod Items for " + Fim.MOD_ID);
    }
}
