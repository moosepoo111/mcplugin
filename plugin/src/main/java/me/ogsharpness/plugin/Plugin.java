package me.ogsharpness.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import me.ogsharpness.plugin.listeners.InteractListener ;
import me.ogsharpness.plugin.weapons.WeaponManager;
import me.ogsharpness.plugin.utils.CooldownManager;
import me.ogsharpness.plugin.commands.GiveWeaponCommand;

public class LegendaryWeaponsPlugin extends JavaPlugin {

    private WeaponManager weaponManager;
    private CooldownManager cooldownManager;

    @Override
    public void onEnable() {
        this.weaponManager = new WeaponManager(this);
        this.cooldownManager = new CooldownManager();

        getServer().getPluginManager().registerEvents(
                new InteractListener(weaponManager, cooldownManager),
                this
        );

        getCommand("giveweapon").setExecutor(
                new GiveWeaponCommand(weaponManager)
        );
    }
}