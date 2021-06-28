package me.slowjulien.nojumpbreakcrops.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {
    private static final String PL_PREFIX = "[NoJumpBreakCrops]";

    public static void consoleLog(String msg) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + PL_PREFIX + " " + msg);
    }

    public static void errConsoleLog(String msg) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + PL_PREFIX + " " + msg);
    }
}
