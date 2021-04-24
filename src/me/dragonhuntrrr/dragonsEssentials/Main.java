package me.dragonhuntrrr.dragonsEssentials;

import me.dragonhuntrrr.dragonsEssentials.Resouces.Files;
import me.dragonhuntrrr.dragonsEssentials.events.Commands.gmCommand;
import me.dragonhuntrrr.dragonsEssentials.events.Commands.permbanCommand;
import me.dragonhuntrrr.dragonsEssentials.events.Commands.tradeCommand;
import me.dragonhuntrrr.dragonsEssentials.events.ListenerClass;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {



    public static Plugin plugin;

    public void onEnable() {

        plugin = this;
        registerEvents(this, new ListenerClass());
        getCommand("gamemode").setExecutor(new gmCommand());
        getCommand("permban").setExecutor(new permbanCommand());
        getCommand("trade").setExecutor(new tradeCommand());
    }

    public void onDisable() {
        plugin = null;
    }


    //Much easier then registering events in 10 different methods
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {

        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    //To access the plugin variable from other classes
    public static Plugin getPlugin() {
        return plugin;
    }




}
