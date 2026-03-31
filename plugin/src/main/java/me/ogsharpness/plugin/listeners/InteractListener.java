package me.ogsharpness.plugin.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import your.package.weapons.*;
import your.package.utils.CooldownManager;

public class InteractListener implements Listener {

    private final WeaponManager weaponManager;
    private final CooldownManager cooldownManager;

    public InteractListener(WeaponManager wm, CooldownManager cm) {
        this.weaponManager = wm;
        this.cooldownManager = cm;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        String id = weaponManager.getWeaponId(item);
        if (id == null) return;

        LegendaryWeapon weapon = weaponManager.getWeapon(id);
        if (weapon == null) return;

        if (cooldownManager.isOnCooldown(player, id)) {
            player.sendMessage("§cOn cooldown!");
            return;
        }

        weapon.onRightClick(player, event);
        cooldownManager.setCooldown(player, id, weapon.getCooldown());
    }
}