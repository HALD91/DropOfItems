package me.HALD91.Drop.Listener;

import me.HALD91.Drop.Drop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class DiamondTools implements Listener {
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        List<ItemStack> list = e.getDrops();
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_SWORD)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_HELMET)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_CHESTPLATE)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_LEGGINGS)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_BOOTS)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.BOW)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.ARROW)));
        list.removeIf(item -> (item.isSimilar(new ItemStack(Material.GOLDEN_APPLE)) && item.getDurability() == 0));
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Item item = event.getItemDrop();
        ItemStack itemStack = item.getItemStack();
        Material itemType = itemStack.getType();

        // Check if the dropped item is a specific type OR it is enchanted
        if ((itemType == Material.DIAMOND_SWORD ||
                itemType == Material.DIAMOND_HELMET ||
                itemType == Material.DIAMOND_CHESTPLATE ||
                itemType == Material.DIAMOND_LEGGINGS ||
                itemType == Material.DIAMOND_BOOTS ||
                itemType == Material.BOW ||
                itemType == Material.ARROW ||
                (itemType == Material.GOLDEN_APPLE && itemStack.getDurability() == 0)) &&
                itemStack.getEnchantments().isEmpty()){
            event.getPlayer().sendMessage("True");
            //event.setCancelled(true);
            item.remove();
        } else {
            event.getPlayer().sendMessage("False");
            event.getPlayer().sendMessage(String.valueOf(itemType));
        }
    }
}
