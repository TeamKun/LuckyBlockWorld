package net.kunmc.lab.luckyblockworld;

import net.kunmc.lab.luckyblockworld.command.CommandRegister;
import net.kunmc.lab.luckyblockworld.config.ServerConfig;
import net.kunmc.lab.luckyblockworld.listener.TickListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("luckyblockworld")
public class LuckyBlockWorld {

    public LuckyBlockWorld() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(TickListener::onServerTick);
        ServerConfig.register(ModLoadingContext.get());
    }

    @SubscribeEvent
    public void onCommandRegister(RegisterCommandsEvent e) {
        CommandRegister.register(e.getDispatcher());
    }
}
