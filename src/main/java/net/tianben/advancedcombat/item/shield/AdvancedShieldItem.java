package net.tianben.advancedcombat.item.shield;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;

public class AdvancedShieldItem extends ShieldItem {
    public AdvancedShieldItem() {
        super(new Settings().maxDamage(1536));
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.IRON_BLOCK) || super.canRepair(stack, ingredient);
    }
}
