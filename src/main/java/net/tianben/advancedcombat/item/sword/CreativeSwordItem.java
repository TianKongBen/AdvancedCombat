package net.tianben.advancedcombat.item.sword;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CreativeSwordItem extends SwordItem {
    public CreativeSwordItem() {
        super(CreativeMaterial.CREATIVE, 3, -2.4f, new FabricItemSettings());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            if (checkGamemode(player)) {
                if (!target.getWorld().isClient) {
                    target.discard();
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }

    private boolean checkGamemode(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            return serverPlayer.interactionManager.getGameMode() == GameMode.CREATIVE;
        } else if (player.getWorld().isClient && player instanceof PlayerEntity) {
            MinecraftClient client = MinecraftClient.getInstance();
            return client.getNetworkHandler().getPlayerListEntry(player.getUuid()) != null &&
                    client.getNetworkHandler().getPlayerListEntry(player.getUuid()).getGameMode() == GameMode.CREATIVE;
        }
        return false;
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.of("§aActive"));
    }
}
