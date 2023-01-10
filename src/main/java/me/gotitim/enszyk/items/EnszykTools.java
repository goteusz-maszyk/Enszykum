package me.gotitim.enszyk.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;

/**
 * @see ToolMaterials
 */
public class EnszykTools implements ToolMaterial {
    public int getDurability() { return 2300; }

    public float getMiningSpeedMultiplier() { return 11.0F; }

    public float getAttackDamage() { return 5.0F; }

    public int getMiningLevel() { return 4; }

    public int getEnchantability() { return 20; }

    public Ingredient getRepairIngredient() { return Ingredient.ofItems(); }

    public static class EnszykHoe extends HoeItem {
        public EnszykHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
}
