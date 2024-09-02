package net.tianben.advancedcombat

import net.fabricmc.api.ClientModInitializer
import net.tianben.advancedcombat.util.ModModelPredicateProvider

class AdvancedCombatClient : ClientModInitializer {

    override fun onInitializeClient() {
        ModModelPredicateProvider.registerModModels()
        ModModelPredicateProvider.registerModItemModelPredicates()
    }
}