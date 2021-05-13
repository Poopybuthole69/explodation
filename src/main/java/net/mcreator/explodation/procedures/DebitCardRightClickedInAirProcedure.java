package net.mcreator.explodation.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.explodation.ExplodationModVariables;
import net.mcreator.explodation.ExplodationModElements;
import net.mcreator.explodation.ExplodationMod;

import java.util.Map;
import java.util.HashMap;

@ExplodationModElements.ModElement.Tag
public class DebitCardRightClickedInAirProcedure extends ExplodationModElements.ModElement {
	public DebitCardRightClickedInAirProcedure(ExplodationModElements instance) {
		super(instance, 21);
		MinecraftForge.EVENT_BUS.register(this);
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

	@SubscribeEvent
	public void onBonemeal(BonemealEvent event) {
		PlayerEntity entity = event.getPlayer();
		double i = event.getPos().getX();
		double j = event.getPos().getY();
		double k = event.getPos().getZ();
		World world = event.getWorld();
		ItemStack itemstack = event.getStack();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("itemstack", itemstack);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
