package net.tianben.advancedcombat.enchated;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SingleEnchantUpgrade extends EnchantUpgrade {
    public SingleEnchantUpgrade(Settings settings, Enchantment enchantment, int min, int max, String enchname, boolean foil) {
        super(settings, enchantment, min, max, enchname, foil);
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.advancedcombat.enchantment", Text.translatable(this.enchName)).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
    }
}
