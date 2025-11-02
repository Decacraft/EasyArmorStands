package me.m56738.easyarmorstands.bolt;

import me.m56738.easyarmorstands.EasyArmorStandsPlugin;
import me.m56738.easyarmorstands.addon.Addon;
import org.bukkit.event.HandlerList;
import org.popcraft.bolt.BoltAPI;

public class BoltAddon implements Addon {
    private BoltListener listener;

    @Override
    public String name() {
        return "Bolt";
    }

    @Override
    public void enable() {
        EasyArmorStandsPlugin plugin = EasyArmorStandsPlugin.getInstance();
        BoltAPI bolt = plugin.getServer().getServicesManager().load(BoltAPI.class);
        listener = new BoltListener(plugin, bolt);
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }

    @Override
    public void disable() {
        HandlerList.unregisterAll(listener);
    }

    @Override
    public void reload() {
    }
}
