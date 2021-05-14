package net.mcreator.explodation.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.explodation.ExplodationModVariables;
import net.mcreator.explodation.ExplodationModElements;
import net.mcreator.explodation.ExplodationMod;

import java.util.Map;

@ExplodationModElements.ModElement.Tag
public class DebitCardRightClickedInAirProcedure extends ExplodationModElements.ModElement {
	public DebitCardRightClickedInAirProcedure(ExplodationModElements instance) {
		super(instance, 21);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExplodationMod.LOGGER.warn("Failed to load dependency entity for procedure DebitCardRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity)
					.sendStatusMessage(new StringTextComponent(((entity.getCapability(ExplodationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ExplodationModVariables.PlayerVariables())).Pincode)), (true));
		}
	}
}
