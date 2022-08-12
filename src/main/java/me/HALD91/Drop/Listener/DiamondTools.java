package me.HALD91.Drop.Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class DiamondTools implements Listener {
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        List <ItemStack> list = e.getDrops();
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_SWORD)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_HELMET)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_CHESTPLATE)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_LEGGINGS)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.DIAMOND_BOOTS)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.BOW)));
        list.removeIf(item -> item.isSimilar(new ItemStack(Material.ARROW)));
    }
}
