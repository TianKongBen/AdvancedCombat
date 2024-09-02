package net.tianben.advancedcombat.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.tianben.advancedcombat.item.shield.AdvancedShieldItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(PlayerEntity.class)
public abstract class AdvancedShieldPlayerEntityMixin extends LivingEntity {

    protected AdvancedShieldPlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow
    @Final
    private PlayerInventory inventory;

    @Shadow
    public abstract ItemCooldownManager getItemCooldownManager();

    @Inject(at = @At("HEAD"), method = "disableShield", cancellable = true)
    private void disableAdvancedShield(boolean sprinting, CallbackInfo ci) {
        ItemStack activeStack = this.activeItemStack;

        if (!(activeStack.getItem() instanceof AdvancedShieldItem)) {
            return;
        }

        float chance = 0.25F + (float)EnchantmentHelper.getEfficiency(this) * 0.05F;
        if (sprinting) {
            chance += 0.75F;
        }

        if (this.random.nextFloat() < chance) {
            Item activeItem = activeStack.getItem();

            this.getItemCooldownManager().set(activeItem, 100);

            for (int i = 0; i < this.inventory.size(); i++) {
                ItemStack stack = this.inventory.getStack(i);
                if (!stack.isEmpty()) {
                    Item item = stack.getItem();
                    if (item instanceof AdvancedShieldItem && item != activeItem) {
                        this.getItemCooldownManager().set(item, 100);
                    }
                }
            }
            this.clearActiveItem();
            this.getWorld().sendEntityStatus(this, (byte)30);
            ci.cancel();
        }
    }

    @Shadow
    public abstract void incrementStat(Stat<?> stat);

    @Inject(at = @At("HEAD"), method = "damageShield")
    private void damageIt(float amount, CallbackInfo info) {
        if (this.activeItemStack.getItem() instanceof AdvancedShieldItem) {
            if (!this.getWorld().isClient) {
                this.incrementStat(Stats.USED.getOrCreateStat(this.activeItemStack.getItem()));
            }

            if (amount >= 3.0F) {
                int i = 1 + MathHelper.floor(amount);
                Hand hand = this.getActiveHand();
                this.activeItemStack.damage(i, this, (Consumer<LivingEntity>) ((playerEntity) ->
                        playerEntity.sendToolBreakStatus(hand)));
                if (this.activeItemStack.isEmpty()) {
                    if (hand == Hand.MAIN_HAND) {
                        this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    } else {
                        this.equipStack(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                    }

                    this.activeItemStack = ItemStack.EMPTY;
                    this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + this.getWorld().random.nextFloat() * 0.4F);
                }
            }

        }
    }
}