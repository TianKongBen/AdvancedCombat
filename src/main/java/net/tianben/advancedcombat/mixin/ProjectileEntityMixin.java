package net.tianben.advancedcombat.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.math.BlockPos;
import net.tianben.advancedcombat.block.TrackingDispenserBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProjectileEntity.class)
public class ProjectileEntityMixin {
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ProjectileEntity projectile = (ProjectileEntity)(Object)this;

        if (projectile.age < 3) {
            BlockPos pos = projectile.getBlockPos();
            BlockState state = projectile.getWorld().getBlockState(pos);

            if (state.getBlock() instanceof TrackingDispenserBlock) {
                projectile.noClip = true;
            }
        } else if (projectile.age == 5) {
            projectile.noClip = false;
        }
    }
}