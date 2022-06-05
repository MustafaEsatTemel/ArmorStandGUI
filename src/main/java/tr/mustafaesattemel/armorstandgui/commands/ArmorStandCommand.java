package tr.mustafaesattemel.armorstandgui.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ArmorStandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory main_menu = Bukkit.createInventory(player,9, ChatColor.AQUA+"ArmorStandGUI");

            //Menu items abilities.
            ItemStack create = new ItemStack(Material.ARMOR_STAND,1);
            ItemMeta create_meta = create.getItemMeta();
            create_meta.setDisplayName(ChatColor.GREEN+"Create");
            List<String> create_meta_lore = new ArrayList<>();
            create_meta_lore.add(ChatColor.GOLD+"Create a new armor stand!");
            create_meta.setLore(create_meta_lore);

            ItemStack close = new ItemStack(Material.BARRIER);
            ItemMeta close_meta = close.getItemMeta();
            close_meta.setDisplayName(ChatColor.RED+"Close");
            close.setItemMeta(close_meta);

            main_menu.setItem(0,create);
            main_menu.setItem(8,close);
            player.openInventory(main_menu);
        }

        return true;
    }
}
