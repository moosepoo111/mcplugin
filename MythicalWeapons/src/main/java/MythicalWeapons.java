import org.bukkit.plugin.java.JavaPlugin;

public class MythicalWeapons extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("MythicalWeapons enabled!");

        // Register events
        getServer().getPluginManager().registerEvents(new WeaponListener(), this);
    }
}


@Override
public boolean onCommand(org.bukkit.command.CommandSender sender,
                         org.bukkit.command.Command command,
                         String label,
                         String[] args) {

    if (command.getName().equalsIgnoreCase("giveweapon")) {

        if (!(sender instanceof org.bukkit.entity.Player)) {
            sender.sendMessage("Players only!");
            return true;
        }

        org.bukkit.entity.Player player = (org.bukkit.entity.Player) sender;

        // Create weapon
        org.bukkit.inventory.ItemStack sword =
                new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD);

        org.bukkit.inventory.meta.ItemMeta meta = sword.getItemMeta();
        meta.setDisplayName("§bZeus Blade");
        sword.setItemMeta(meta);

        // Give it
        player.getInventory().addItem(sword);

        player.sendMessage("You got the Zeus Blade!");

        return true;
    }

    return false;
}