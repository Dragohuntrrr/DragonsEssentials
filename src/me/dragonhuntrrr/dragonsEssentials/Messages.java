package me.dragonhuntrrr.dragonsEssentials;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.awt.*;

import net.md_5.bungee.api.chat.TextComponent;

public class Messages {
    public static String prefix = ChatColor.translateAlternateColorCodes('&', "&7[&6&lR&b&lC&7] ");

    public static void sendPlayer(Player player, String text) {
        player.sendMessage(prefix + text);
    }
    public static void sendConsole(String text) {System.out.println( prefix + text);}

    public static void sendClickable(Player player, String text, String command, String hoverMessage) {
        TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&' , text));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        if (!hoverMessage.equalsIgnoreCase("null"))
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', hoverMessage)).create()));
        player.spigot().sendMessage(message);
    }
}
