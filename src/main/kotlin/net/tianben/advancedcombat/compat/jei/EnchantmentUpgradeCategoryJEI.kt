package net.tianben.advancedcombat.compat.jei

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder
import mezz.jei.api.gui.drawable.IDrawable
import mezz.jei.api.helpers.IGuiHelper
import mezz.jei.api.recipe.IFocusGroup
import mezz.jei.api.recipe.RecipeIngredientRole
import mezz.jei.api.recipe.RecipeType
import mezz.jei.api.recipe.category.IRecipeCategory
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.AdvancedCombat
import net.tianben.advancedcombat.item.ModItems

class EnchantmentUpgradeCategoryJEI(guiHelper: IGuiHelper) : IRecipeCategory<RecipeEnchantmentUpgradeJEI> {
    companion object {
        val TYPE: RecipeType<RecipeEnchantmentUpgradeJEI> =
            RecipeType(Identifier(AdvancedCombat.MOD_ID, "advancedcombat"), RecipeEnchantmentUpgradeJEI::class.java)
    }

    private val background: IDrawable = guiHelper.createDrawable(
        Identifier("minecraft", "textures/gui/container/crafting_table.png"),
        29, 16, 116, 54
    )
    private val icon: IDrawable = guiHelper.createDrawableItemStack(ItemStack(ModItems.SHARPNESS_UPGRADE))

    override fun getRecipeType(): RecipeType<RecipeEnchantmentUpgradeJEI> {
        return TYPE
    }

    override fun getTitle(): Text {
        return Text.translatable("category.advancedcombat.enchantment_upgrade")
    }

    @SuppressWarnings("removal")
    override fun getBackground(): IDrawable {
        return background
    }

    override fun getIcon(): IDrawable {
        return icon
    }

    override fun setRecipe(builder: IRecipeLayoutBuilder, recipe: RecipeEnchantmentUpgradeJEI, focuses: IFocusGroup) {
        builder.addSlot(RecipeIngredientRole.OUTPUT, 95, 19)
            .addItemStack(recipe.output)

        val inputs = recipe.inputs
        val startX = 1
        val startY = 1
        val gridWidth = 3

        for (y in 0 until gridWidth) {
            for (x in 0 until gridWidth) {
                val index = y * gridWidth + x
                if (index < inputs.size) {
                    val slotX = startX + x * 18
                    val slotY = startY + y * 18
                    builder.addSlot(RecipeIngredientRole.INPUT, slotX, slotY)
                        .addItemStack(inputs[index])
                }
            }
        }
    }
}