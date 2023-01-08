package me.gotitim.enszyk.mixin;

import me.gotitim.enszyk.events.PlayerMoveCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerMoveMixin {

    @Inject(at = @At(value = "TAIL"), method = "tickMovement", cancellable = true)
    private void onMove(CallbackInfo ci) {
        PlayerEntity pe = (PlayerEntity) (Object) this;
        if(pe.world.isClient) return;
        ActionResult result = PlayerMoveCallback.EVENT.invoker().onMove(pe);

        if(result == ActionResult.FAIL) {
            ci.cancel();
        }
    }
}
