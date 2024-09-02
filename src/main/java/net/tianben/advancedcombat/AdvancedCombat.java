package net.tianben.advancedcombat;

import net.fabricmc.api.ModInitializer;

import net.tianben.advancedcombat.block.ModBlocks;
import net.tianben.advancedcombat.item.group.ModItemGroups;
import net.tianben.advancedcombat.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedCombat implements ModInitializer {
	public static final String MOD_ID = "advancedcombat";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}