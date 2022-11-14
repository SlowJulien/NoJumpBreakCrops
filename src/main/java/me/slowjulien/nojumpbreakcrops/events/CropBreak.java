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
    private final String permission;

    public CropBreak(JavaPlugin plugin) {
        super();
        this.plugin = plugin;
        this.permission = "njbc.breakcrops";
    }

    @EventHandler
    public void onBreakCrop(PlayerInteractEvent e) {
        // If the plugin is disabled
        if (!((boolean) plugin.getConfig().get("enabled"))) return;

        if (e.getAction() == Action.PHYSICAL) {
            Player p = e.getPlayer();
            try {
                if (e.getClickedBlock().getType() == Material.FARMLAND) {

                    // If permission is explicitly set to false
                    if (p.isPermissionSet(this.permission) && !p.hasPermission(this.permission)) {
                        e.setCancelled(true);
                    } else if (!p.hasPermission(this.permission)) { // The player does not have the perm...
                        // If the player is not an operator OR
                        // If the player is an operator AND the plugin is affecting operators
                        if (!p.isOp() || (p.isOp() && ((boolean) plugin.getConfig().get("affectop")))) {
                            e.setCancelled(true);
                        }
                    }

                }
            } catch (NullPointerException ignored) {
            }

        }
    }

}
