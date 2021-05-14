
package net.mcreator.explodation.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.explodation.procedures.GumballsFoodEatenProcedure;
import net.mcreator.explodation.ExplodationModElements;

import java.util.Map;
import java.util.HashMap;

@ExplodationModElements.ModElement.Tag
public class GumballsItem extends ExplodationModElements.ModElement {
	@ObjectHolder("explodation:gumballs")
	public static final Item block = null;
	public GumballsItem(ExplodationModElements instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(16).rarity(Rarity.RARE)
					.food((new Food.Builder()).hunger(2).saturation(5f).setAlwaysEdible().build()));
			setRegistryName("gumballs");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 20;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				GumballsFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
