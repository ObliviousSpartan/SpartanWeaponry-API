package com.oblivioussp.spartanweaponry.api.weaponproperty;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Callback class for Weapon Properties; Implement this in your weapon property class to implement custom behaviour for your weapon
 * @author ObliviousSpartan
 *
 */
public interface IPropertyCallback 
{
	/**
	 * Change this to customise damage from a weapon with this Weapon Property when it deals damage
	 * @param material The weapon's material
	 * @param baseDamage The base damage that the weapon would deal if unmodified
	 * @param source The source of the damage
	 * @param attacker The attacking Entity
	 * @param victim The Entity being attacked
	 * @return The damage that will be dealt after any necessary modifications.
	 */
	public float modifyDamageDealt(ToolMaterialEx material, float baseDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim);
	
	/**
	 * Change this to customise damage taken with this weapon equipped with this Weapon Property when damage is taken
	 * @param material The weapon's material
	 * @param baseDamage The base damage that should be taken if unmodified
	 * @param source The source of the damage
	 * @param attacker The attacking Entity
	 * @param victim The Entity being attacked
	 * @return The damage that will be taken after any necessary modifications.
	 */
	public float modifyDamageTaken(ToolMaterialEx material, float baseDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim);
	
	/**
	 * Called once every item tick. Use if item behavior needs to be changed on the fly
	 * @param material The item's material
	 * @param stack The item
	 * @param world The world
	 * @param entity The Entity equipped with this item
	 * @param itemSlot The slot the item is in
	 * @param isSelected
	 */
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected);
	
	/**
	 * Called when an entity is hit with a weapon containing this Weapon Property
	 * @param material The item's material
	 * @param stack The item
	 * @param target The Entity being attacked
	 * @param attacker The attacking Entity
	 * @param projectile The Entity that is directly hitting the target Entity. Will be null if hit by a melee hit, so please null check!
	 */
	public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile);
	
	
	/**
	 * Allows the item to have Enchantments or other NBT data added to the item. This should be reflected in Creative mode too
	 * @param stack The item to edit
	 */
	public void onCreateItem(ToolMaterialEx material, ItemStack stack);
}