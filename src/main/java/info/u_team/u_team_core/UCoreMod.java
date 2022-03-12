package info.u_team.u_team_core;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import info.u_team.u_team_core.util.annotation.AnnotationManager;
import info.u_team.u_team_core.util.verify.JarSignVerifier;
import net.minecraftforge.fml.common.Mod;

@Mod(UCoreMod.MODID)
public class UCoreMod {
	
	public static final String MODID = "uteamcore";
	public static final Logger LOGGER = LogUtils.getLogger();
	
	public UCoreMod() {
		JarSignVerifier.checkSigned(MODID);
		
		AnnotationManager.callAnnotations(MODID);
	}
}
