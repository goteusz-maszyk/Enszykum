package me.gotitim.enszyk.mixin;

import me.gotitim.enszyk.registeries.ModItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class PlayerAddEffectMixin {

    @Inject(at = @At(value = "HEAD"), method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z")
    private void onAddStatusEffect(StatusEffectInstance effect, @Nullable Entity entity, CallbackInfoReturnable<Boolean> ci) {
        int activeArmorItems = 0;
        PlayerEntity player;
        try {
            player = (PlayerEntity) ((Object) this);
        } catch (Exception ignored) { return; }
        if (player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).getItem().equals(ModItem.items.get("enszyk_helmet"))) activeArmorItems++;
        if (player.getInventory().getArmorStack(EquipmentSlot.CHEST.getEntitySlotId()).getItem().equals(ModItem.items.get("enszyk_chestplate"))) activeArmorItems++;
        if (player.getInventory().getArmorStack(EquipmentSlot.LEGS.getEntitySlotId()).getItem().equals(ModItem.items.get("enszyk_leggings"))) activeArmorItems++;
        if (player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId()).getItem().equals(ModItem.items.get("enszyk_boots"))) activeArmorItems++;
        int newDuration = (int) (effect.getDuration() * (1 + activeArmorItems*0.25));
        ((StatusEffectMixin) effect).setDuration(newDuration);

    }
}
