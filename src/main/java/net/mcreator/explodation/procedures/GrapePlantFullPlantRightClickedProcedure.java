package net.mcreator.explodation.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.explodation.item.GrapesItem;
import net.mcreator.explodation.block.GrapePlantEmptyBlock;
import net.mcreator.explodation.ExplodationModElements;
import net.mcreator.explodation.ExplodationMod;

import java.util.Map;

@ExplodationModElements.ModElement.Tag
public class GrapePlantFullPlantRightClickedProcedure extends ExplodationModElements.ModElement {
	public GrapePlantFullPlantRightClickedProcedure(ExplodationModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExplodationMod.LOGGER.warn("Failed to load dependency x for procedure GrapePlantFullPlantRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExplodationMod.LOGGER.warn("Failed to load dependency y for procedure GrapePlantFullPlantRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExplodationMod.LOGGER.warn("Failed to load dependency z for procedure GrapePlantFullPlantRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExplodationMod.LOGGER.warn("Failed to load dependency world for procedure GrapePlantFullPlantRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, (Math.floor(x)), (Math.floor(y)), (Math.floor(z)),
					new ItemStack(GrapesItem.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 10);
			world.addEntity(entityToSpawn);
		}
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, (Math.floor(x)), (Math.floor(y)), (Math.floor(z)),
					new ItemStack(GrapesItem.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 10);
			world.addEntity(entityToSpawn);
		}
		world.setBlockState(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
				GrapePlantEmptyBlock.block.getDefaultState(), 3);
	}
}
