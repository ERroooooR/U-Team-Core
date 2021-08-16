package info.u_team.u_team_core.api.gui;

import com.mojang.blaze3d.vertex.PoseStack;

import info.u_team.u_team_core.util.RGBA;

public interface IBackgroundColorProvider {
	
	RGBA getCurrentBackgroundColor(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks);
	
}
