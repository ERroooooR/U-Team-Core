package info.u_team.u_team_core.gui.elements;

import com.mojang.blaze3d.vertex.PoseStack;

import info.u_team.u_team_core.api.gui.ScaleProvider;
import info.u_team.u_team_core.api.gui.Scalable;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class ScalableCheckboxButton extends CheckboxButton implements Scalable, ScaleProvider {
	
	protected float scale;
	
	public ScalableCheckboxButton(int x, int y, int width, int height, Component text, boolean checked, boolean drawText, float scale) {
		this(x, y, width, height, text, checked, drawText, scale, EMTPY_PRESSABLE);
	}
	
	public ScalableCheckboxButton(int x, int y, int width, int height, Component text, boolean checked, boolean drawText, float scale, OnPress pessable) {
		this(x, y, width, height, text, checked, drawText, scale, pessable, EMPTY_TOOLTIP);
	}
	
	public ScalableCheckboxButton(int x, int y, int width, int height, Component text, boolean checked, boolean drawText, float scale, OnTooltip tooltip) {
		this(x, y, width, height, text, checked, drawText, scale, EMTPY_PRESSABLE, tooltip);
	}
	
	public ScalableCheckboxButton(int x, int y, int width, int height, Component text, boolean checked, boolean drawText, float scale, OnPress pessable, OnTooltip tooltip) {
		super(x, y, width, height, text, checked, drawText, pessable, tooltip);
		this.scale = scale;
	}
	
	@Override
	public float getScale() {
		return scale;
	}
	
	@Override
	public void setScale(float scale) {
		this.scale = scale;
	}
	
	@Override
	public void renderForeground(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		if (drawText) {
			// TODO replace with font getter!
			final var fontRenderer = Minecraft.getInstance().font;
			
			final var message = getCurrentText();
			if (message != TextComponent.EMPTY) {
				final var currentScale = getCurrentScale(matrixStack, mouseX, mouseY, partialTicks);
				
				final var positionFactor = 1 / currentScale;
				
				final float xStart;
				final var yStart = (y + ((int) (height - 8 * currentScale)) / 2) * positionFactor;
				
				if (leftSideText) {
					xStart = (x - ((fontRenderer.width(message) * currentScale) + 4)) * positionFactor;
				} else {
					xStart = (x + width + 4) * positionFactor;
				}
				
				final var color = getCurrentTextColor(matrixStack, mouseX, mouseY, partialTicks).getColorARGB();
				
				matrixStack.pushPose();
				matrixStack.scale(currentScale, currentScale, 0);
				
				if (dropShadow) {
					fontRenderer.drawShadow(matrixStack, getCurrentText(), xStart, yStart, color);
				} else {
					fontRenderer.draw(matrixStack, getCurrentText(), xStart, yStart, color);
				}
				
				matrixStack.popPose();
			}
		}
	}
	
	@Override
	public float getCurrentScale(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		return scale;
	}
}
