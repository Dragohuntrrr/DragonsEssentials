package me.dragonhuntrrr.dragonsEssentials.events.Commands;

import me.dragonhuntrrr.dragonsEssentials.Main;
import me.dragonhuntrrr.dragonsEssentials.Messages;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class tradeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("trade")) {

            if (sender instanceof Player) {

                if (args.length == 2) {

                    Player player = (Player) sender;
                    Player receiver = Bukkit.getServer().getPlayer(args[1]);

                    player.sendMessage("1");
                    if (args[0].equalsIgnoreCase("request")) {
                        player.sendMessage("2");

                        if (receiver != null) {
                            player.sendMessage("3");


                            TextComponent tradeMessageAccept = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a&l[Accept]   "));
                            TextComponent tradeMessageDeny = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&4&l[Deny]"));

                            tradeMessageAccept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/trade accept"));
                            tradeMessageDeny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/trade deny"));

                            tradeMessageAccept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "Accept trade request")).create()));
                            tradeMessageDeny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "Deny trade request")).create()));


                            receiver.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                    "&b&l--------------------\n" +
                                            "&fTrade request from " + player.getName()
                            ));

                            receiver.sendMessage(" \n" + " \n");

                            receiver.spigot().sendMessage(tradeMessageAccept, tradeMessageDeny);
                            receiver.sendMessage(
                                    "&b&l--------------------"
                            );

                        } else
                            Messages.sendPlayer(player, "Found no player named " + receiver.getName());


                    } else if (args[0].equalsIgnoreCase("accept")) {

                        player.sendMessage("hey!");
                    }
                }
            } else {
                Messages.sendConsole("Console may not use this command!");
            }
        }
        return false;
    }
}