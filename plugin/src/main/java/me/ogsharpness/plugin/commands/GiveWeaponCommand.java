package me.ogsharpness.plugin.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.persistence.PersistentDataType;

import me.ogsharpness.plugin.weapons.WeaponManager;

public class GiveWeaponCommand implements CommandExecutor {

    private final WeaponManager weaponManager;

    public GiveWeaponCommand(WeaponManager wm) {
        this.weaponManager = wm;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player player)) return true;

        if (args.length == 0) {
            player.sendMessage("§cUse: /giveweapon <id>");
            return true;
        }

        String id = args[0];

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§b" + id);
        meta.getPersistentDataContainer().set(
                weaponManager.getKey(),
                PersistentDataType.STRING,
                id
        );

        item.setItemMeta(meta);

        player.getInventory().addItem(item);
        player.sendMessage("§aGiven " + id);

        return true;
    }
}