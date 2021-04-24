package me.dragonhuntrrr.dragonsEssentials.events.Commands;

import me.dragonhuntrrr.dragonsEssentials.Main;
import me.dragonhuntrrr.dragonsEssentials.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gmCommand implements CommandExecutor, TabCompleter {

    public static Main main;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gamemode")) {

            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.hasPermission("dragonEssentials.command.gamemode")) {

                    if (args.length >= 1) {

                        if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative")) {
                            if (args.length == 2)
                                player = Bukkit.getServer().getPlayer(args[1]);

                            player.setGameMode(GameMode.CREATIVE);
                            Messages.sendPlayer(player, "Gamemode set to " + player.getGameMode());

                        } else if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival")) {
                            if (args.length == 2)
                                player = Bukkit.getServer().getPlayer(args[1]);

                            player.setGameMode(GameMode.SURVIVAL);
                            Messages.sendPlayer(player, "Gamemode set to " + player.getGameMode());

                        } else if (args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("spectator")) {
                            if (args.length == 2)
                                player = Bukkit.getServer().getPlayer(args[1]);

                            player.setGameMode(GameMode.SPECTATOR);
                            Messages.sendPlayer(player, "Gamemode set to " + player.getGameMode());

                        } else if (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure")) {
                            if (args.length == 2)
                                player = Bukkit.getServer().getPlayer(args[1]);

                            player.setGameMode(GameMode.ADVENTURE);
                            Messages.sendPlayer(player, "Gamemode set to " + player.getGameMode());

                        } else {

                            Messages.sendPlayer(player, "Invalid arguments!");
                        }

                    } else {

                        Messages.sendPlayer(player, "Missing arguments!");
                    }
                } else {
                    Messages.sendPlayer(player, "You do not have permission to use this command!");
                }
            }
        }

        return false;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1)
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("adventure", "creative", "spectator", "survival"), new ArrayList<>());

        if (args.length == 2)
            return StringUtil.copyPartialMatches(args[1], Arrays.asList(Bukkit.getOnlinePlayers().stream().map(Player::getName).toArray(String[]::new)), new ArrayList<>());

        return null;
    }
}