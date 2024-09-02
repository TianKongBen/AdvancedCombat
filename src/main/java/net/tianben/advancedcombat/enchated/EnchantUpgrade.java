package net.tianben.advancedcombat.enchated;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnchantUpgrade extends Item {
    Enchantment applyEnchantment;
    int minLvl;
    int maxlvl;
    String enchName;
    Boolean foil;

    public EnchantUpgrade(Settings settings, Enchantment enchantment, int min, int max, String enchname, boolean foil) {
        super(settings);
        this.applyEnchantment = enchantment;
        this.minLvl = min;
        this.maxlvl = max;
        this.enchName = enchname;
        this.foil = foil;
    }

    public boolean hasGlint(ItemStack stack) {
        return this.foil;
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("tooltip.advancedcombat.enchantment", Text.translatable(this.enchName)).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
        tooltip.add(Text.translatable("tooltip.advancedcombat.tiers", this.minLvl, this.maxlvl).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
    }

    public Enchantment getEnchantment() {
        return this.applyEnchantment;
    }

    public int getMin() {
        return this.minLvl;
    }

    public int getMax() {
        return this.maxlvl;
    }
}
