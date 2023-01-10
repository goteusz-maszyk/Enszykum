package me.gotitim.enszyk.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

/**
 * @see net.minecraft.item.ElytraItem
 */
public class EnszykArmor implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4};
    private static final int DURABILITY_MULT = 42;

    public int getDurability(EquipmentSlot slot) { return BASE_DURABILITY[slot.getEntitySlotId()] * DURABILITY_MULT; }

    public int getProtectionAmount(EquipmentSlot slot) { return PROTECTION_VALUES[slot.getEntitySlotId()]; }

    public int getEnchantability() { return 20; }

    public SoundEvent getEquipSound() { return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE; }

    public Ingredient getRepairIngredient() { return Ingredient.ofItems(); }

    public String getName() { return "enszyk"; }

    public float getToughness() { return 5; }

    public float getKnockbackResistance() { return 0.1F; }
}
