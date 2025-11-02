package me.m56738.easyarmorstands.config.integration;

import me.m56738.easyarmorstands.config.integration.lands.LandsConfig;
import me.m56738.easyarmorstands.lib.configurate.objectmapping.ConfigSerializable;
import me.m56738.easyarmorstands.lib.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class IntegrationConfig {
    @Setting("WorldGuard")
    public IntegrationEntryConfig worldGuard;
    @Setting("PlotSquared")
    public IntegrationEntryConfig plotSquared;
    @Setting("FancyHolograms")
    public IntegrationEntryConfig fancyHolograms;
    @Setting("HeadDatabase")
    public IntegrationEntryConfig headDatabase;
}
