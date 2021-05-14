package net.mcreator.explodation.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.mcreator.explodation.gui.PincodeGuiSuccessGui;
import net.mcreator.explodation.gui.PincodeGuiFailGui;
import net.mcreator.explodation.ExplodationModVariables;
import net.mcreator.explodation.ExplodationModElements;
import net.mcreator.explodation.ExplodationMod;

import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

@ExplodationModElements.ModElement.Tag
public class ChangePincodeCommandProcedure extends ExplodationModElements.ModElement {
	public ChangePincodeCommandProcedure(ExplodationModElements instance) {
		super(instance, 31);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExplodationMod.LOGGER.warn("Failed to load dependency entity for procedure ChangePincodeCommand!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				ExplodationMod.LOGGER.warn("Failed to load dependency guistate for procedure ChangePincodeCommand!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExplodationMod.LOGGER.warn("Failed to load dependency x for procedure ChangePincodeCommand!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExplodationMod.LOGGER.warn("Failed to load dependency y for procedure ChangePincodeCommand!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExplodationMod.LOGGER.warn("Failed to load dependency z for procedure ChangePincodeCommand!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExplodationMod.LOGGER.warn("Failed to load dependency world for procedure ChangePincodeCommand!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:CommandPincode");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals(""))) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("PincodeGuiFail");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new PincodeGuiFailGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else {
			{
				String _setval = (String) (new Object() {
					public String getText() {
						TextFieldWidget textField = (TextFieldWidget) guistate.get("text:CommandPincode");
						if (textField != null) {
							return textField.getText();
						}
						return "";
					}
				}.getText());
				entity.getCapability(ExplodationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Pincode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("PincodeGuiSuccess");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new PincodeGuiSuccessGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
