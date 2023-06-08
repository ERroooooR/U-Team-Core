package info.u_team.u_team_core.gui.elements;

import info.u_team.u_team_core.util.RGBA;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class ActivatableButton extends UButton {
	
	protected boolean activated;
	
	protected RGBA activatedColor;
	
	public ActivatableButton(int x, int y, int width, int height, Component text, boolean activated, RGBA activatedColor) {
		this(x, y, width, height, text, activated, activatedColor, EMTPY_PRESSABLE);
	}
	
	public ActivatableButton(int x, int y, int width, int height, Component text, boolean activated, RGBA activatedColor, OnPress pessable) {
		super(x, y, width, height, text, pessable);
		this.activated = activated;
		this.activatedColor = activatedColor;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public RGBA getActivatedColor() {
		return activatedColor;
	}
	
	public void setActivatedColor(RGBA activatedColor) {
		this.activatedColor = activatedColor;
	}
	
	@Override
	public RGBA getCurrentBackgroundColor(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		return activated ? activatedColor : buttonColor;
	}
}
