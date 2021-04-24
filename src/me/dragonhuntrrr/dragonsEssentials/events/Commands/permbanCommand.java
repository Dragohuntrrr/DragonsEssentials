package me.dragonhuntrrr.dragonsEssentials.events.Commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permbanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("permban")) {

            if (args.length == 1) {

                Player player = Bukkit.getPlayer(args[0]);
                Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "You got banned!", null, null);
                player.kickPlayer("Kicked lol!");
            }
        }

        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1)
            return StringUtil.copyPartialMatches(args[0], Arrays.asList(Bukkit.getOnlinePlayers().stream().map(Player::getName).toArray(String[]::new)), new ArrayList<>());

        return null;

    }
}
