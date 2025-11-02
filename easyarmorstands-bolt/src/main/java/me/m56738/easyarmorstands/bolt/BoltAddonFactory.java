package me.m56738.easyarmorstands.bolt;

import me.m56738.easyarmorstands.EasyArmorStandsPlugin;
import me.m56738.easyarmorstands.addon.AddonFactory;
import org.bukkit.Bukkit;

public class BoltAddonFactory implements AddonFactory<BoltAddon> {
    @Override
    public boolean isEnabled() {
        return EasyArmorStandsPlugin.getInstance().getConfiguration().integration.bolt.enabled;
    }

    @Override
    public boolean isAvailable() {
        return Bukkit.getPluginManager().getPlugin("Bolt") != null;
    }

    @Override
    public BoltAddon create() {
        return new BoltAddon();
    }
}
