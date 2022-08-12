package me.HALD91.Drop;

import me.HALD91.Drop.Listener.DiamondTools;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Drop extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DiamondTools(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
