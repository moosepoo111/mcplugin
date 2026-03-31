package me.ogsharpness.plugin.weapons;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import your.package.LegendaryWeaponsPlugin;

import java.util.HashMap;
import java.util.Map;

public class WeaponManager {

    private final Map<String, LegendaryWeapon> weapons = new HashMap<>();
    private final NamespacedKey key;

    public WeaponManager(LegendaryWeaponsPlugin plugin) {
        this.key = new NamespacedKey(plugin, "weapon_id");

        registerWeapon(new your.package.weapons.impl.LightningSword());
        registerWeapon(new your.package.weapons.impl.FrostSword());
    }

    public void registerWeapon(LegendaryWeapon weapon) {
        weapons.put(weapon.getId(), weapon);
    }

    public LegendaryWeapon getWeapon(String id) {
        return weapons.get(id);
    }

    public String getWeaponId(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return null;

        ItemMeta meta = item.getItemMeta();
        if (meta == null) return null;

        return meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
    }

    public NamespacedKey getKey() {
        return key;
    }
}