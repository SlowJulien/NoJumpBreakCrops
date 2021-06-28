package me.slowjulien.nojumpbreakcrops.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;


public abstract class NJBCCommand implements CommandExecutor {

    private JavaPlugin plugin;

    public NJBCCommand(JavaPlugin plugin) {
        super();
        this.plugin = plugin;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

}
