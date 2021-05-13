package net.mcreator.explodation.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.mcreator.explodation.ExplodationModVariables;
import net.mcreator.explodation.ExplodationModElements;
import net.mcreator.explodation.ExplodationMod;

import java.util.Map;
import java.util.HashMap;

@ExplodationModElements.ModElement.Tag
public class AttemptBankSignupProcedure extends ExplodationModElements.ModElement {
	public AttemptBankSignupProcedure(ExplodationModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExplodationMod.LOGGER.warn("Failed to load dependency entity for procedure AttemptBankSignup!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				ExplodationMod.LOGGER.warn("Failed to load dependency guistate for procedure AttemptBankSignup!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		{
			String _setval = (String) (new Object() {
				public String getText() {
					TextFieldWidget textField = (TextFieldWidget) guistate.get("text:SignupPincode");
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
	}
}
