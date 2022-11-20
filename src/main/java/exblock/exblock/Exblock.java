package exblock.exblock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Exblock extends JavaPlugin {
private static Plugin plugin;
public static Exblock instance;
private onblockevent listners;

public Exblock(){
    instance = this;
}

public static Exblock getInstance(){
    return instance;
}

    @Override
    public void onEnable() {
        plugin = this;

        this.listners = new onblockevent();
        Bukkit.getPluginManager().registerEvents(this.listners, this);
    }

    public static Plugin getPlugin(){
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
