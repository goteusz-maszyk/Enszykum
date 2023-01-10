package me.gotitim.enszyk.registeries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static me.gotitim.enszyk.Enszyk.ITEM_GROUP;

public class ModItem {
    public final String id;
    public final Item item;
    public static final Map<String, Item> items = new HashMap<>();

    public ModItem(String id) {
        this.id = id;
        this.item = new Item(new FabricItemSettings().group(ITEM_GROUP));
        items.put(id, item);
        Registry.register(Registry.ITEM, new Identifier("enszyk", id), item);
    }

    public ModItem(String id, Item item) {
        this.id = id;
        this.item = item;
        items.put(id, item);
        Registry.register(Registry.ITEM, new Identifier("enszyk", id), item);
    }
}
