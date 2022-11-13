package me.slowjulien.nojumpbreakcrops.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CropBreak implements Listener {

    private final JavaPlugin plugin;

    public CropBreak(JavaPlugin plugin) {
        super();
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreakCrop(PlayerInteractEvent e) {
        // If the plugin is disabled
        if(!((boolean) plugin.getConfig().get("enabled"))) return;

        if(e.getAction() == Action.PHYSICAL) {
            Player p = e.getPlayer();
            try {
                if(e.getClickedBlock().getType() == Material.FARMLAND) {

                     if(!p.hasPermission("njbc.breakcrops")){
                        e.setCancelled(true);
                    } else if(p.isOp()) {
                         if(((boolean) plugin.getConfig().get("affectop")) && !p.hasPermission("njbc.breakcrops")) {
                             e.setCancelled(true);
                         }
                    }

                }
            } catch (NullPointerException ignored) {}
        }
    }

}
