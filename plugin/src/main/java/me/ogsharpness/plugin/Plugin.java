package your.package;

import org.bukkit.plugin.java.JavaPlugin;
import your.package.listeners.InteractListener;
import your.package.weapons.WeaponManager;
import your.package.utils.CooldownManager;
import your.package.commands.GiveWeaponCommand;

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