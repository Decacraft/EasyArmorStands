package me.m56738.easyarmorstands.bolt;

import me.m56738.easyarmorstands.EasyArmorStandsPlugin;
import me.m56738.easyarmorstands.api.editor.Session;
import me.m56738.easyarmorstands.api.editor.SessionManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.popcraft.bolt.BoltAPI;
import org.popcraft.bolt.protection.Protection;
import org.popcraft.bolt.util.Permission;

public class BoltListener implements Listener {
    private final EasyArmorStandsPlugin plugin;
    private final BoltAPI bolt;

    public BoltListener(EasyArmorStandsPlugin plugin, BoltAPI bolt) {
        this.bolt = bolt;
        this.plugin = plugin;
    }

    @EventHandler
    public void onClickEntity(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        SessionManager sessionManager = plugin.sessionManager();
        Session session = sessionManager.getSession(player);
        if (session == null) {
            return;
        }
        Entity entity = event.getRightClicked();
        Protection protection = bolt.findProtection(entity);
        if (protection != null && !bolt.canAccess(protection, player, Permission.EDIT)) {
            player.sendMessage(ChatColor.RED + "You do not have permission to edit this entity.");
            sessionManager.stopSession(session);
            event.setCancelled(true);
        }
    }
}
