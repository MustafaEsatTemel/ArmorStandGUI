package tr.mustafaesattemel.armorstandgui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tr.mustafaesattemel.armorstandgui.commands.ArmorStandCommand;

public class CreateMenu {


    public void openCreateMenu(Player player){

        Inventory create_menu = Bukkit.createInventory(player,18, ChatColor.GREEN+"Create a Armor Stand");

        ItemStack arms = new ItemStack(Material.ARMOR_STAND);
        ItemStack glow = new ItemStack(Material.BEACON);
        ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack base = new ItemStack(Material.STONE_SLAB2);
        ItemStack complete = new ItemStack(Material.GREEN_RECORD);
        ItemStack cancel = new ItemStack(Material.RED_SANDSTONE);

        ItemMeta arms_meta = arms.getItemMeta();
        arms_meta.setDisplayName(ChatColor.GREEN+"Arms");
        ItemMeta glow_meta = glow.getItemMeta();
        glow_meta.setDisplayName(ChatColor.GREEN+"Glow");
        ItemMeta armor_meta = armor.getItemMeta();
        armor_meta.setDisplayName(ChatColor.GREEN+"Armor");
        ItemMeta base_meta = base.getItemMeta();
        base_meta.setDisplayName(ChatColor.GREEN+"Base");
        ItemMeta complete_meta =complete.getItemMeta();
        complete_meta.setDisplayName(ChatColor.GREEN+"Complete & Create");
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.RED+"Cancel Creation");

        arms.setItemMeta(arms_meta);
        glow.setItemMeta(glow_meta);
        armor.setItemMeta(armor_meta);
        base.setItemMeta(base_meta);
        complete.setItemMeta(complete_meta);
        cancel.setItemMeta(cancel_meta);

        create_menu.setItem(0,arms);
        create_menu.setItem(1,glow);
        create_menu.setItem(2,armor);
        create_menu.setItem(3,base);
        create_menu.setItem(16,complete);
        create_menu.setItem(17,cancel);

        player.openInventory(create_menu);

    }

    public void openConfirmMenu(Player player,Material option){
        Inventory confirm_menu = Bukkit.createInventory(player,36,ChatColor.GREEN+"Confirm Menu");

        ItemStack option_item = new ItemStack(option);
        ItemMeta option_meta = option_item.getItemMeta();

        if (option == Material.ARMOR_STAND){
            option_meta.setDisplayName(ChatColor.YELLOW+"Add arms ?");
            option_item.setItemMeta(option_meta);

        }else if(option == Material.BEACON){
            option_meta.setDisplayName(ChatColor.YELLOW+"Add glows ?");
            option_item.setItemMeta(option_meta);
        }else if(option==Material.LEATHER_CHESTPLATE){
            option_meta.setDisplayName(ChatColor.YELLOW+"Add armor ?");
            option_item.setItemMeta(option_meta);
        }else if(option==Material.STONE_SLAB2){
            option_meta.setDisplayName(ChatColor.YELLOW+"Add base ?");
            option_item.setItemMeta(option_meta);
        }

        ItemStack yes = new ItemStack(Material.GREEN_RECORD);
        ItemMeta yes_meta = yes.getItemMeta();
        yes_meta.setDisplayName(ChatColor.GREEN+"Yes");
        yes.setItemMeta(yes_meta);

        ItemStack no = new ItemStack(Material.RED_SANDSTONE);
        ItemMeta no_meta = no.getItemMeta();
        no_meta.setDisplayName(ChatColor.RED+"No");
        no.setItemMeta(no_meta);

        confirm_menu.setItem(13,option_item);
        confirm_menu.setItem(21,yes);
        confirm_menu.setItem(23,no);


        player.openInventory(confirm_menu);
    }


    public void openArmorMenu (Player player){
        Inventory armorMenu = Bukkit.createInventory(player,45,ChatColor.RED+"Choose armor");

        ItemStack head = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack body = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

        ItemStack confirm = new ItemStack(Material.GREEN_RECORD);
        ItemMeta confirm_meta = confirm.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.GREEN + "Done");
        confirm.setItemMeta(confirm_meta);

        armorMenu.setItem(11, head);
        armorMenu.setItem(12, body);
        armorMenu.setItem(14, legs);
        armorMenu.setItem(15, boots);
        armorMenu.setItem(40, confirm);

        player.openInventory(armorMenu);

    }

}
