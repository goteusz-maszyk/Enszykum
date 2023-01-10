package me.gotitim.enszyk.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface PlayerMoveCallback {
    Event<PlayerMoveCallback> EVENT = EventFactory.createArrayBacked(PlayerMoveCallback.class, listeners -> (player) -> {
                for (PlayerMoveCallback listener : listeners) {
                    ActionResult result = listener.onMove(player);

                    if(result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    ActionResult onMove(PlayerEntity player);
}
