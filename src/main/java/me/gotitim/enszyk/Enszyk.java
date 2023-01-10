package me.gotitim.enszyk;

import me.gotitim.enszyk.blocks.EnszykOre;
import me.gotitim.enszyk.events.PlayerMoveCallback;
import me.gotitim.enszyk.items.EnszykArmor;
import me.gotitim.enszyk.items.EnszykTools;
import me.gotitim.enszyk.registeries.ModBlock;
import me.gotitim.enszyk.registeries.ModItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class Enszyk implements ModInitializer {
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier("enszyk", "enszyk")
    ).icon(() -> new ItemStack(ModItem.items.get("enszyk_ingot"))).build();

    @Override
    public void onInitialize() {
        new ModItem("enszyk_ingot");
        new ModItem("enszyk_scrap");
        new ModBlock("enszyk_block", new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(35.0F, 1200.0F)));
        EnszykOre.register();

        final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new EnszykArmor();

        new ModItem("enszyk_helmet", new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_chestplate", new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_leggings", new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_boots", new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ITEM_GROUP)));

        final ToolMaterial TOOL_MATERIAL = new EnszykTools();

        new ModItem("enszyk_sword", new SwordItem(TOOL_MATERIAL, 3 ,-2.4F, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_shovel", new ShovelItem(TOOL_MATERIAL, 1.5F, 3.0F, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_pickaxe", new PickaxeItem(TOOL_MATERIAL, 1, -2.8F, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_axe", new AxeItem(TOOL_MATERIAL, 5, -3, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_hoe", new EnszykTools.EnszykHoe(TOOL_MATERIAL, -4, 0.0F, new Item.Settings().group(ITEM_GROUP)));

        ModBlock.register();

        PlayerMoveCallback.EVENT.register((player) -> {
            int activeArmorItems = 0;
            if (player.getY() > 10) return ActionResult.PASS;
            if (player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).getItem().equals(ModItem.items.get("enszyk_helmet"))) activeArmorItems++;
            if (player.getInventory().getArmorStack(EquipmentSlot.CHEST.getEntitySlotId()).getItem().equals(ModItem.items.get("enszyk_chestplate"))) activeArmorItems++;
            if (player.getInventory().getArmorStack(EquipmentSlot.LEGS.getEntitySlotId()).getItem().equals(ModItem.items.get("enszyk_leggings"))) activeArmorItems++;
            if (player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId()).getItem().equals(ModItem.items.get("enszyk_boots"))) activeArmorItems++;
            if (activeArmorItems >= 2) player.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 40, 4));

            return ActionResult.PASS;
        });
    }
}
