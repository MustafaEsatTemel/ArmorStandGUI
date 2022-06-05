package tr.mustafaesattemel.armorstandgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import tr.mustafaesattemel.armorstandgui.ArmorStandGUI;
import tr.mustafaesattemel.armorstandgui.CreateMenu;

public class MenuHandler implements Listener {

    private CreateMenu createMenu;
    private ArmorStandGUI plugin;

    public MenuHandler(CreateMenu createMenu, ArmorStandGUI plugin){
        this.createMenu=createMenu;
        this.plugin = plugin;
    }


    private static final String MAIN_MENU= ChatColor.AQUA+"ArmorStandGUI";
    private static final String CREATE_MENU=ChatColor.GREEN+"Create a Armor Stand";
    private static final String CONFIRM_MENU =ChatColor.GREEN+"Confirm Menu";
    private static final String ARMOR_MENU =ChatColor.RED+"Choose armor";

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        //For main menu (Create or Cancel)
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(MAIN_MENU)){

            switch (e.getCurrentItem().getType()){

                case ARMOR_STAND:
                    p.sendMessage("Opened Armor Stand Create Menu");
                    createMenu.openCreateMenu(p);
                    break;

                case BARRIER:
                    p.sendMessage("Closing Armor Stand Create Menu");
                    p.closeInventory();
                    break;
                default:
            }


        }else if(e.getClickedInventory().getTitle().equalsIgnoreCase(CREATE_MENU)){

            if(!plugin.armorStands.containsKey(p)){
                ArmorStand stand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                stand.setVisible(false);
                plugin.armorStands.put(p,stand);
            }


            switch(e.getCurrentItem().getType()){
                case ARMOR_STAND:
                    p.sendMessage("Add arms ?");
                    createMenu.openConfirmMenu(p, Material.ARMOR_STAND);
                    break;
                case BEACON:
                    p.sendMessage("Add glow ?");
                    createMenu.openConfirmMenu(p,Material.BEACON);
                    break;
                case LEATHER_CHESTPLATE:
                    p.sendMessage("Choose armor ?");
                    createMenu.openArmorMenu(p);
                    break;
                case STONE_SLAB2:
                    p.sendMessage("Add base ?");
                    createMenu.openConfirmMenu(p,Material.STONE_SLAB2);
                    break;
                case GREEN_RECORD:
                    p.sendMessage("Created armor stand!");
                    if(plugin.armorStands.containsKey(p)){
                        ArmorStand armorStand = plugin.armorStands.get(p);
                        armorStand.setVisible(true);
                        plugin.armorStands.remove(p);
                    }
                    p.closeInventory();
                    break;
                case RED_SANDSTONE:
                    p.sendMessage("Deleted armor stand!");
                    if(plugin.armorStands.containsKey(p)){
                        ArmorStand armorStand = plugin.armorStands.get(p);
                        armorStand.remove();
                        plugin.armorStands.remove(p);
                    }
                    p.closeInventory();
                    break;
                default :
            }
            e.setCancelled(true);

        }else if(e.getClickedInventory().getTitle().equalsIgnoreCase(CONFIRM_MENU)){

        if (e.getClickedInventory().contains(Material.ARMOR_STAND)){
            switch (e.getCurrentItem().getType()){
                case GREEN_RECORD:
                    p.sendMessage("Option confirmed!");

                    if(plugin.armorStands.containsKey(p)){
                        ArmorStand stand = plugin.armorStands.get(p);
                        stand.setArms(true);
                    }

                    createMenu.openCreateMenu(p);
                    break;
                case RED_SANDSTONE:
                    p.sendMessage("Option confirmed!");

                    if(plugin.armorStands.containsKey(p)){
                        ArmorStand stand = plugin.armorStands.get(p);
                        stand.setArms(false);
                    }

                    createMenu.openCreateMenu(p);
                    break;
                default:
            }


        }else if(e.getClickedInventory().contains(Material.BEACON)) {
                switch (e.getCurrentItem().getType()){
                    case GREEN_RECORD:
                        p.sendMessage("Option confirmed!");

                        if(plugin.armorStands.containsKey(p)){
                            ArmorStand stand = plugin.armorStands.get(p);
                            stand.setGlowing(true);
                        }

                        createMenu.openCreateMenu(p);
                        break;
                    case RED_SANDSTONE:
                        p.sendMessage("Option confirmed!");

                        if(plugin.armorStands.containsKey(p)){
                            ArmorStand stand = plugin.armorStands.get(p);
                            stand.setGlowing(false);
                        }

                        createMenu.openCreateMenu(p);
                        break;
                    default:
                }


            }else if(e.getClickedInventory().contains(Material.STONE_SLAB2)) {
            switch (e.getCurrentItem().getType()){
                case GREEN_RECORD:
                    p.sendMessage("Option confirmed!");

                    if(plugin.armorStands.containsKey(p)){
                        ArmorStand stand = plugin.armorStands.get(p);
                        stand.setBasePlate(true);
                    }

                    createMenu.openCreateMenu(p);
                    break;
                case RED_SANDSTONE:
                    p.sendMessage("Option confirmed!");

                    if(plugin.armorStands.containsKey(p)){
                        ArmorStand stand = plugin.armorStands.get(p);
                        stand.setBasePlate(false);
                    }

                    createMenu.openCreateMenu(p);
                    break;
                default:
            }


        }

            e.setCancelled(true);
        }else if (e.getClickedInventory().getTitle().equalsIgnoreCase(ARMOR_MENU)){

                if(plugin.armorStands.containsKey(p)){
                    ArmorStand stand = plugin.armorStands.get(p);
                    switch (e.getCurrentItem().getType()){
                        case DIAMOND_HELMET:
                            if (stand.getHelmet().getType() == Material.DIAMOND_HELMET){
                                stand.setHelmet(null);
                                p.sendMessage("Removed");
                            }else{
                                stand.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                                p.sendMessage("Added");
                            }
                            break;
                        case DIAMOND_CHESTPLATE:
                            if (stand.getHelmet().getType() == Material.DIAMOND_CHESTPLATE){
                                stand.setChestplate(null);
                                p.sendMessage("Removed");
                            }else{
                                stand.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                                p.sendMessage("Added");
                            }
                            break;
                        case DIAMOND_LEGGINGS:
                            if (stand.getHelmet().getType() == Material.DIAMOND_LEGGINGS){
                                stand.setLeggings(null);
                                p.sendMessage("Removed");
                            }else{
                                stand.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                                p.sendMessage("Added");
                            }
                            break;
                        case DIAMOND_BOOTS:
                            if (stand.getHelmet().getType() == Material.DIAMOND_BOOTS){
                                stand.setBoots(null);
                                p.sendMessage("Removed");
                            }else{
                                stand.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                                p.sendMessage("Added");
                            }
                        case GREEN_RECORD:
                            p.sendMessage("Armor confirmed !");
                            createMenu.openCreateMenu(p);
                    }
                    e.setCancelled(true);

                }




        }



    }


}
