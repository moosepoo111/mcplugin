package me.ogsharpness.plugin.weapons.impl;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.Particle;
import org.bukkit.Sound;

import your.package.weapons.LegendaryWeapon;

public class LightningSword extends LegendaryWeapon {

    public String getId() { return "lightning_sword"; }
    public String getName() { return "§bLightning Sword"; }
    public long getCooldown() { return 5000; }

    public void onRightClick(Player player, PlayerInteractEvent event) {
        Location target = player.getTargetBlockExact(50).getLocation();

        player.getWorld().strikeLightning(target);

        player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, target, 50);
        player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
    }
}