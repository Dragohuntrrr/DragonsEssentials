package me.dragonhuntrrr.dragonsEssentials.events.Players;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Bukkit.getBanList(BanList.Type.IP).isBanned(event.getPlayer().getAddress().getHostName()))  {
            if (!Bukkit.getBanList(BanList.Type.NAME).isBanned(event.getPlayer().getName())) {
                event.getPlayer().kickPlayer(ChatColor.translateAlternateColorCodes('&', "&4&lYou are banned!\n" +
                        " \n" +
                        "&5&lOff account of banned players are to be banned\n" +
                        "\n" +
                        "If you believe this is a bug, please report it on the discord server!" +
                        "\n" +
                        "&5 Ban ID: &5&l#1234"));
            }
        }

    }
}
