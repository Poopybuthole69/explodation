
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
public class BankLoginFailGuiWindow extends ContainerScreen<BankLoginFailGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	TextFieldWidget Pincode;
	public BankLoginFailGuiWindow(BankLoginFailGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("explodation:textures/bank_login_fail.png");
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
		this.font.drawString(ms, "Bank - ERROR", 6, 7, -12829636);
		this.font.drawString(ms, "Sorry, you were unable to login", 6, 106, -12829636);
		this.font.drawString(ms, "ERROR", 6, 88, -12829636);
		this.font.drawString(ms, "Becasue of an login error", 6, 115, -12829636);
		this.font.drawString(ms, "try checking your pincode", 6, 124, -12829636);
		this.font.drawString(ms, "and make sure that you", 6, 133, -12829636);
		this.font.drawString(ms, "use the right pincode", 6, 142, -12829636);
		this.font.drawString(ms, "Go back and try again.", 60, 61, -12829636);
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
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 61, 50, 20, new StringTextComponent("wrong"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new BankLoginFailGui.ButtonPressedMessage(0, x, y, z));
				BankLoginFailGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		Pincode = new TextFieldWidget(this.font, this.guiLeft + 6, this.guiTop + 34, 120, 20, new StringTextComponent("pincode")) {
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
		BankLoginFailGui.guistate.put("text:Pincode", Pincode);
		Pincode.setMaxStringLength(32767);
		this.children.add(this.Pincode);
		this.addButton(new Button(this.guiLeft + 123, this.guiTop + 7, 45, 20, new StringTextComponent("Back"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new BankLoginFailGui.ButtonPressedMessage(1, x, y, z));
				BankLoginFailGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
