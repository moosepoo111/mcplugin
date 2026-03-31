package me.ogsharpness.plugin.weapons;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class LegendaryWeapon {

    public abstract String getId();
    public abstract String getName();
    public abstract long getCooldown();

    public abstract void onRightClick(Player player, PlayerInteractEvent event);
}
