package me.slowjulien.nojumpbreakcrops.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class EnableDisable extends NJBCCommand {

    public EnableDisable(JavaPlugin plugin) {
        super(plugin);
    }

    private static final String msgWrongArgs = "&cYou must chose a boolean : <&dtrue&c> or <&dfalse&c>.";
    private static final String msgAlrActivated = "&cThe anti-jumpbreak-crops system is already &a&nactivated";
    private static final String msgAlrDeactivated = "&cThe anti-jumpbreak-crops system is already &ndeactivated";
    private static final String msgSuccess = "&aThe anti-jumpbreak-crops has been set to : &5";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1 || (!args[0].equals("true") && !args[0].equals("false"))) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msgWrongArgs));
            return true;
        }

        // New State
        boolean newState = Boolean.parseBoolean(args[0]);
        // Current State
        boolean curState = (boolean) getPlugin().getConfig().get("enabled");

        if(newState == curState) {
            if(curState) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msgAlrActivated));
            else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msgAlrDeactivated));
        } else {
            getPlugin().getConfig().set("enabled", newState);
            getPlugin().saveConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msgSuccess + newState));
        }
        return true;
    }

}

