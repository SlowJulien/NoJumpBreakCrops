package me.slowjulien.nojumpbreakcrops.commands;

import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;


public abstract class NJBCCommand implements TabExecutor {

    private JavaPlugin plugin;

    public NJBCCommand(JavaPlugin plugin) {
        super();
        this.plugin = plugin;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

}
