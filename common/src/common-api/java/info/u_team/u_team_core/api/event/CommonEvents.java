package info.u_team.u_team_core.api.event;

import info.u_team.u_team_core.util.ServiceUtil;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

public interface CommonEvents {
	
	static void registerSetup(SetupEvent event) {
		Handler.INSTANCE.registerSetup(event);
	}
	
	static void registerRegister(RegisterEvent event) {
		Handler.INSTANCE.registerRegister(event);
	}
	
	static void registerStartServerTick(StartServerTick event) {
		Handler.INSTANCE.registerStartServerTick(event);
	}
	
	static void registerEndServerTick(EndServerTick event) {
		Handler.INSTANCE.registerEndServerTick(event);
	}
	
	static void registerStartLevelTick(StartLevelTick event) {
		Handler.INSTANCE.registerStartLevelTick(event);
	}
	
	static void registerEndLevelTick(EndLevelTick event) {
		Handler.INSTANCE.registerEndLevelTick(event);
	}
	
	interface Handler {
		
		Handler INSTANCE = ServiceUtil.loadOne(Handler.class);
		
		void registerSetup(SetupEvent event);
		
		void registerRegister(RegisterEvent event);
		
		void registerStartServerTick(StartServerTick event);
		
		void registerEndServerTick(EndServerTick event);
		
		void registerStartLevelTick(StartLevelTick event);
		
		void registerEndLevelTick(EndLevelTick event);
	}
	
	@FunctionalInterface
	interface SetupEvent {
		
		void onSetup();
	}
	
	@FunctionalInterface
	public interface RegisterEvent {
		
		void onRegister(ResourceKey<? extends Registry<?>> key);
	}
	
	@FunctionalInterface
	interface StartServerTick {
		
		void onStartTick(MinecraftServer server);
	}
	
	@FunctionalInterface
	interface EndServerTick {
		
		void onEndTick(MinecraftServer server);
	}
	
	@FunctionalInterface
	interface StartLevelTick {
		
		void onStartTick(ServerLevel level);
	}
	
	@FunctionalInterface
	interface EndLevelTick {
		
		void onEndTick(ServerLevel level);
	}
}
