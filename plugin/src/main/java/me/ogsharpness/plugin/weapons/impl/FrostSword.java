package me.ogsharpness.plugin.weapons.impl;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ogsharpness.plugin.weapons.LegendaryWeapon;

public class FrostSword extends LegendaryWeapon {

    public String getId() { return "frost_sword"; }
    public String getName() { return "§bFrost Sword"; }
    public long getCooldown() { return 4000; }

    public void onRightClick(Player player, PlayerInteractEvent event) {
        player.getNearbyEntities(5,5,5).forEach(e -> {
            if (e instanceof org.bukkit.entity.LivingEntity) {
                org.bukkit.entity.LivingEntity target = (org.bukkit.entity.LivingEntity) e;

                target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 2));
            }
        });

        player.sendMessage("§bEnemies frozen!");
    }
}