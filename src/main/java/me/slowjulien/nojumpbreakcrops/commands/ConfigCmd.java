package me.slowjulien.nojumpbreakcrops.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigCmd extends NJBCCommand {

    public ConfigCmd(JavaPlugin plugin) { super(plugin); }

    private static final String msgWrongArgs = "&cA problem happened with the args use :" +
            "\n- /njbc" +
            "\n- /njbc <enabled | disabled>" +
            "\n- /njbc affectop <true | false>";
    private static final String alrEnabled = "&cThe plugin is already &5&nenabled&r&c.";
    private static final String alrDisabled = "&cThe plugin system is already &5&ndisabled&r&c.";
    private static final String alrAffecOp = "&cOperators are &nalready&r&c affected by the plugin !";
    private static final String notAlrAffecOp = "&cOperators are &nalready not&r&c affected by the plugin !";
    private static final String msgSuccessEna = "&aThe plugin has been &5enabled&a.";
    private static final String msgSuccessDis = "&aThe plugin has been &5disabled&a.";
    private static final String msgSuccAffOpTrue = "&aThe default operators are now &5affected &aby the plugin.";
    private static final String msgSuccAffOpFalse = "&aThe default operators are now &5bypassing &athe plugin.";
    private static final String sep = "&7======================";
    private static final String infoMess = sep+"\n &aNJBC Status :\n   - &9Enabled &a: &5%s\n   &a- &9Affect Op &a: &5%s\n"+sep;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            boolean enabled = (boolean) getPlugin().getConfig().get("enabled");
            boolean affectop = (boolean) getPlugin().getConfig().get("affectop");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', String.format(infoMess, enabled, affectop)));
        }
        // /njbc disable | enable
        else if (args.length == 1 && (args[0].equals("enable") || args[0].equals("disable"))) {
            // New State
            boolean newState = (args[0].equals("enable"));
            // Current State
            boolean curState = (boolean) getPlugin().getConfig().get("enabled");

            if(newState == curState) {
                if(curState) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', alrEnabled));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', alrDisabled));
            } else {
                getPlugin().getConfig().set("enabled", newState);
                getPlugin().saveConfig();
                if(newState) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msgSuccessEna));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msgSuccessDis));

            }
            return true;
        }
        // /njbc affectop true | false
        else if (args.length == 2 && (args[1].equals("true") || args[1].equals("false"))) {
            // New State
            boolean newState = (args[1].equals("true"));
            // Current State
            boolean curState = (boolean) getPlugin().getConfig().get("affectop");
            if(newState == curState) {
                if(curState) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', alrAffecOp));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', notAlrAffecOp));
            } else {
                getPlugin().getConfig().set("affectop", newState);
                getPlugin().saveConfig();
                if(newState) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msgSuccAffOpTrue));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msgSuccAffOpFalse));
            }
        }
        // Something is wrong in the args
        else sender.sendMessage(ChatColor.translateAlternateColorCodes('&',msgWrongArgs));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            return new ArrayList<>(Arrays.asList("enable", "disable", "affectop"));
        } else if (args.length == 2 && args[0].equals("affectop")) {
            return new ArrayList<>(Arrays.asList("true", "false"));
        } else {
            return new ArrayList<>();
        }
    }
}
