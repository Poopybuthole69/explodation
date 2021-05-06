
package net.mcreator.explodation.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.explodation.ExplodationModElements;

@ExplodationModElements.ModElement.Tag
public class GrapesItem extends ExplodationModElements.ModElement {
	@ObjectHolder("explodation:grapes")
	public static final Item block = null;
	public GrapesItem(ExplodationModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(16).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("grapes");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 25;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
