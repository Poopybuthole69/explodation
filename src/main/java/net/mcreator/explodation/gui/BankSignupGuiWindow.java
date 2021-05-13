
package net.mcreator.explodation.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.explodation.ExplodationMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BankSignupGuiWindow extends ContainerScreen<BankSignupGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	TextFieldWidget Pincode;
	public BankSignupGuiWindow(BankSignupGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("explodation:textures/bank_signup.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		Pincode.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (Pincode.isFocused())
			return Pincode.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		Pincode.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Bank - Signup", 6, 7, -12829636);
		this.font.drawString(ms, "Think of a secure pincode", 6, 43, -12829636);
		this.font.drawString(ms, "By signing up for our bank you", 6, 115, -12829636);
		this.font.drawString(ms, "argree to the following T.O.S.", 6, 124, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		Pincode = new TextFieldWidget(this.font, this.guiLeft + 6, this.guiTop + 61, 120, 20, new StringTextComponent("pincode")) {
			{
				setSuggestion("pincode");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("pincode");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("pincode");
				else
					setSuggestion(null);
			}
		};
		BankSignupGui.guistate.put("text:Pincode", Pincode);
		Pincode.setMaxStringLength(32767);
		this.children.add(this.Pincode);
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 88, 60, 20, new StringTextComponent("Signup!"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new BankSignupGui.ButtonPressedMessage(0, x, y, z));
				BankSignupGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 33, this.guiTop + 133, 105, 20, new StringTextComponent("Terms of service"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new BankSignupGui.ButtonPressedMessage(1, x, y, z));
				BankSignupGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
