
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
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.explodation.ExplodationModVariables;
import net.mcreator.explodation.ExplodationMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class EbayFoodGuiWindow extends ContainerScreen<EbayFoodGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public EbayFoodGuiWindow(EbayFoodGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 250;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("explodation:textures/ebay_food.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("explodation:textures/workingcarrot.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 64, 0, 0, 32, 32, 32, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("explodation:textures/godapple.png"));
		this.blit(ms, this.guiLeft + 186, this.guiTop + 66, 0, 0, 32, 32, 32, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("explodation:textures/gumballs.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 67, 0, 0, 32, 32, 32, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("explodation:textures/cookie.png"));
		this.blit(ms, this.guiLeft + 79, this.guiTop + 64, 0, 0, 32, 32, 32, 32);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Ebay - Food", 7, 7, -12829636);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(ExplodationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ExplodationModVariables.PlayerVariables())).BankMoney) + "$", 70, 34, -12829636);
		this.font.drawString(ms, "______________________________________", 7, 43, -12829636);
		this.font.drawString(ms, "Carrot", 25, 54, -12829636);
		this.font.drawString(ms, "-10$", 25, 97, -12829636);
		this.font.drawString(ms, "God Apple", 179, 54, -12829636);
		this.font.drawString(ms, "Gumballs", 128, 54, -12829636);
		this.font.drawString(ms, "Cookie", 79, 54, -12829636);
		this.font.drawString(ms, "-30$", 87, 97, -12829636);
		this.font.drawString(ms, "-60$", 133, 98, -12829636);
		this.font.drawString(ms, "-200$", 192, 97, -12829636);
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
		this.addButton(new Button(this.guiLeft + 196, this.guiTop + 7, 45, 20, new StringTextComponent("Back"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new EbayFoodGui.ButtonPressedMessage(0, x, y, z));
				EbayFoodGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 25, 45, 20, new StringTextComponent("Home"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new EbayFoodGui.ButtonPressedMessage(1, x, y, z));
				EbayFoodGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 187, this.guiTop + 115, 30, 20, new StringTextComponent("Buy"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new EbayFoodGui.ButtonPressedMessage(2, x, y, z));
				EbayFoodGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 133, this.guiTop + 115, 30, 20, new StringTextComponent("buy"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new EbayFoodGui.ButtonPressedMessage(3, x, y, z));
				EbayFoodGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 25, this.guiTop + 115, 30, 20, new StringTextComponent("Buy"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new EbayFoodGui.ButtonPressedMessage(4, x, y, z));
				EbayFoodGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 79, this.guiTop + 115, 30, 20, new StringTextComponent("Buy"), e -> {
			if (true) {
				ExplodationMod.PACKET_HANDLER.sendToServer(new EbayFoodGui.ButtonPressedMessage(5, x, y, z));
				EbayFoodGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
