package net.tianben.advancedcombat.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.tianben.advancedcombat.item.armor.NetherArmorItem;
import net.tianben.advancedcombat.item.armor.ObsidianArmorItem;
import net.tianben.advancedcombat.item.sword.CreativeSwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "disablesShield", at = @At("HEAD"), cancellable = true)
    private void onDisablesShield(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        ItemStack mainHandStack = entity.getMainHandStack();

        if (mainHandStack.getItem() instanceof CreativeSwordItem && entity instanceof PlayerEntity && ((PlayerEntity) entity).isCreative()) {
            cir.setReturnValue(true);
        }
    }

    @ModifyVariable(
            method = "damage",
            at = @At("HEAD"),
            argsOnly = true
    )
    private float modifyDamage(float amount, DamageSource source) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity.getWorld().isClient()) {
            return amount;
        }

        if (isExplosionDamage(source)) {
            int ObsidianArmorCount = getObsidianArmorCount(entity);
            if (ObsidianArmorCount > 0) {
                float newAmount = amount * (1 - ObsidianArmorCount / 4f);
                return Math.max(newAmount, 0);
            }
            int NetherArmorCount = getNetherArmorCount(entity);
            if (NetherArmorCount > 0) {
                float newAmount = amount * (1 - NetherArmorCount / 8f);
                return Math.max(newAmount, 0);
            }
        }

        return amount;
    }

    @Unique
    private boolean isExplosionDamage(DamageSource source) {
        return source.isOf(DamageTypes.EXPLOSION) ||
                source.isOf(DamageTypes.PLAYER_EXPLOSION) ||
                source.isOf(DamageTypes.FIREBALL) ||
                source.isOf(DamageTypes.FIREWORKS);
    }

    @Unique
    private int getObsidianArmorCount(LivingEntity entity) {
        int count = 0;
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                ItemStack stack = entity.getEquippedStack(slot);
                if (!stack.isEmpty() && stack.getItem() instanceof ObsidianArmorItem) {
                    count++;
                }
            }
        }

        return count;
    }

    @Unique
    private int getNetherArmorCount(LivingEntity entity) {
        int count = 0;

        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                ItemStack stack = entity.getEquippedStack(slot);
                if (!stack.isEmpty() && stack.getItem() instanceof NetherArmorItem) {
                    count++;
                }
            }
        }

        return count;
    }
}