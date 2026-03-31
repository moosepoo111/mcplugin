import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WeaponListener implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent event) {

        // Get item
        ItemStack item = event.getItem();

        // Stop errors
        if (item == null) return;
        if (item.getType() != Material.DIAMOND_SWORD) return;
        if (!item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();

        // Check name
        if (!meta.hasDisplayName()) return;

        if (meta.getDisplayName().equals("§bZeus Blade")) {

            World world = event.getPlayer().getWorld();

            // Strike lightning where player is looking
            world.strikeLightning(event.getPlayer().getTargetBlock(null, 50).getLocation());
        }
    }
}