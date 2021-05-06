package net.mcreator.explodation.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.explodation.block.GrapePlantFullBlock;
import net.mcreator.explodation.ExplodationModElements;
import net.mcreator.explodation.ExplodationMod;

import java.util.Map;

@ExplodationModElements.ModElement.Tag
public class GrapePlantEmptyUpdateTickProcedure extends ExplodationModElements.ModElement {
	public GrapePlantEmptyUpdateTickProcedure(ExplodationModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExplodationMod.LOGGER.warn("Failed to load dependency x for procedure GrapePlantEmptyUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExplodationMod.LOGGER.warn("Failed to load dependency y for procedure GrapePlantEmptyUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExplodationMod.LOGGER.warn("Failed to load dependency z for procedure GrapePlantEmptyUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExplodationMod.LOGGER.warn("Failed to load dependency world for procedure GrapePlantEmptyUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
				GrapePlantFullBlock.block.getDefaultState(), 3);
	}
}
