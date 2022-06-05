package tr.mustafaesattemel.armorstandgui;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import tr.mustafaesattemel.armorstandgui.commands.ArmorStandCommand;
import tr.mustafaesattemel.armorstandgui.events.MenuHandler;

import java.util.HashMap;

public final class ArmorStandGUI extends JavaPlugin {

    public HashMap<Player, ArmorStand> armorStands= new HashMap<>();


    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(Color.GREEN+"Plugin has been started!");
        getCommand("armorstand").setExecutor(new ArmorStandCommand());
        getServer().getPluginManager().registerEvents(new MenuHandler(new CreateMenu(),this),this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
