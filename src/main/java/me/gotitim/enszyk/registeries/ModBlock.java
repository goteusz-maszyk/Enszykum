package me.gotitim.enszyk.registeries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static me.gotitim.enszyk.Enszyk.ITEM_GROUP;

public class ModBlock {
    public final String id;
    public final Block block;
    public final BlockItem item;
    public static final Map<String, ModBlock> blocks = new HashMap<>();

//  new Block(new FabricBlockSettings().of(Material.STONE, MapColor.PALE_YELLOW).requiresTool())

    public ModBlock(String id, Block block) {
        this.id = id;
        this.block = block;
        this.item = new BlockItem(block, new FabricItemSettings().group(ITEM_GROUP));
        blocks.put(id, this);
    }

    public static void register() {
        blocks.forEach((id, modBlock) -> {
            Registry.register(Registry.BLOCK, new Identifier("enszyk", id), modBlock.block);
            Registry.register(Registry.ITEM, new Identifier("enszyk", id), modBlock.item);
        });
    }

    public Identifier getId() {
        return new Identifier("enszyk", id);
    }
}
