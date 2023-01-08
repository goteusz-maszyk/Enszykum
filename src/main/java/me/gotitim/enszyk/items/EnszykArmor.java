package me.gotitim.enszyk.items;

import me.gotitim.enszyk.registeries.ModItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static me.gotitim.enszyk.Enszyk.ITEM_GROUP;

public class EnszykArmor implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4};
    private static final int X = 40;

    public static void addItems() {
        final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new EnszykArmor();

        new ModItem("enszyk_helmet", new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_chestplate", new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_leggings", new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ITEM_GROUP)));
        new ModItem("enszyk_boots", new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ITEM_GROUP)));
    }

    @Override
    public int getDurability(EquipmentSlot slot) { return BASE_DURABILITY[slot.getEntitySlotId()] * X; }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) { return PROTECTION_VALUES[slot.getEntitySlotId()]; }

    @Override
    public int getEnchantability() { return 20; }

    @Override
    public SoundEvent getEquipSound() { return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE; }

    @Override
    public Ingredient getRepairIngredient() { return null; }

    @Override
    public String getName() { return "enszyk"; }

    @Override
    public float getToughness() { return 5; }

    @Override
    public float getKnockbackResistance() { return 0.1F; }
}
