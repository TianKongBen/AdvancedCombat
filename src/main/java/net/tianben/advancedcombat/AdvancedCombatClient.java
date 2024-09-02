package net.tianben.advancedcombat;

import net.fabricmc.api.ClientModInitializer;
import net.tianben.advancedcombat.util.ModModelPredicateProvider;

public class AdvancedCombatClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModModelPredicateProvider.registerModModels();
		ModModelPredicateProvider.registerModItemModelPredicates();
	}
}