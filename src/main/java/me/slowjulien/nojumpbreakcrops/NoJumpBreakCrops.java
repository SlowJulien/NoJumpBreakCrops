package me.slowjulien.nojumpbreakcrops;

import me.slowjulien.nojumpbreakcrops.commands.ConfigCmd;
import me.slowjulien.nojumpbreakcrops.events.CropBreak;
import me.slowjulien.nojumpbreakcrops.utils.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoJumpBreakCrops extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        // Register the only one event
        getServer().getPluginManager().registerEvents(new CropBreak(this), this);

        // Config File
        configFileGeneration();
        // Commands
        loadCommands();

        Logger.consoleLog("Plugin enabled.");
    }

    @Override
    public void onDisable() {
        Logger.consoleLog("Plugin disabled.");
    }


    private void loadCommands() {
        this.getCommand("njbc").setExecutor(new ConfigCmd(this));
    }

    private void configFileGeneration() {
        config.addDefault("enabled", true);
        // If set to true operators without the permission njbc.breakcrops can't break
        config.addDefault("affectop", false);
        config.options().copyDefaults(true);
        saveConfig();
    }

}
