package net.zutki.fim;

import net.fabricmc.api.ModInitializer;
import net.zutki.fim.block.ModBlocks;
import net.zutki.fim.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fim implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "fim";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
