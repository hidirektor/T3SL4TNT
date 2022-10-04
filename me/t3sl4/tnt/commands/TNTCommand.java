package me.t3sl4.tnt.commands;

import me.t3sl4.tnt.T3SL4TNT;
import me.t3sl4.tnt.util.Item;
import me.t3sl4.tnt.util.MessageUtil;
import me.t3sl4.tnt.util.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;

import static org.bukkit.Bukkit.getServer;

public class TNTCommand implements CommandExecutor {

    static SettingsManager manager = SettingsManager.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(cmd.getName().equalsIgnoreCase("patlayici")) {
            if(args.length == 0) {
                if(sender instanceof Player) {
                    Player komutGonderen = (Player) sender;
                    if(komutGonderen.isOp() || komutGonderen.hasPermission("t3sl4tnt.general")) {
                        komutGonderen.sendMessage(MessageUtil.INFOLINE1);
                        komutGonderen.sendMessage(MessageUtil.INFOLINE2);
                        komutGonderen.sendMessage(MessageUtil.INFOLINE3);
                        komutGonderen.sendMessage(MessageUtil.INFOLINE4);
                    } else {
                        komutGonderen.sendMessage(MessageUtil.PERMERROR);
                    }
                } else {
                    sender.sendMessage(MessageUtil.CONSOLEERROR);
                }
            } else if(args[0].equalsIgnoreCase("al")) {
                if(sender instanceof Player) {
                    Player komutGonderen = (Player) sender;
                    if(komutGonderen.isOp() || komutGonderen.hasPermission("t3sl4tnt.al")) {
                        if(args.length < 3 && args.length == 2) {
                            int gonderilecekAdet = 1;
                            int gonderilecekTur = Integer.parseInt(args[1]);
                            if(gonderilecekTur == 1) {
                                if(Item.checkInventory(komutGonderen)) {
                                    for(int i=0; i<gonderilecekAdet; i++) {
                                        komutGonderen.getInventory().addItem(T3SL4TNT.item.advancedTNT);
                                    }
                                    komutGonderen.sendMessage((MessageUtil.ADD).replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.ANAME));
                                } else {
                                    komutGonderen.sendMessage(MessageUtil.INVERROR);
                                }
                            } else if(gonderilecekTur == 2) {
                                if(Item.checkInventory(komutGonderen)) {
                                    for(int i=0; i<gonderilecekAdet; i++) {
                                        komutGonderen.getInventory().addItem(T3SL4TNT.item.extraAdvancedTNT);
                                    }
                                    komutGonderen.sendMessage((MessageUtil.ADD).replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.EANAME));
                                } else {
                                    komutGonderen.sendMessage(MessageUtil.INVERROR);
                                }
                            } else {
                                turErrorMsg((Player) sender);
                            }
                        } else if(args.length == 3) {
                            int gonderilecekAdet = Integer.parseInt(args[2]);
                            int gonderilecekTur = Integer.parseInt(args[1]);
                            if(gonderilecekTur == 1) {
                                if(Item.checkInventory(komutGonderen)) {
                                    for(int i=0; i<gonderilecekAdet; i++) {
                                        komutGonderen.getInventory().addItem(T3SL4TNT.item.advancedTNT);
                                    }
                                    komutGonderen.sendMessage((MessageUtil.ADD).replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.ANAME));
                                } else {
                                    komutGonderen.sendMessage(MessageUtil.INVERROR);
                                }
                            } else if(gonderilecekTur == 2) {
                                if(Item.checkInventory(komutGonderen)) {
                                    for(int i=0; i<gonderilecekAdet; i++) {
                                        komutGonderen.getInventory().addItem(T3SL4TNT.item.extraAdvancedTNT);
                                    }
                                    komutGonderen.sendMessage((MessageUtil.ADD).replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.EANAME));
                                } else {
                                    komutGonderen.sendMessage(MessageUtil.INVERROR);
                                }
                            } else {
                                turErrorMsg((Player) sender);
                            }
                        } else {
                            komutGonderen.sendMessage(MessageUtil.ARGAL);
                        }
                    } else {
                        komutGonderen.sendMessage(MessageUtil.PERMERROR);
                    }
                } else {
                    sender.sendMessage(MessageUtil.CONSOLEERROR);
                }
            } else if(args[0].equalsIgnoreCase("ver")) {
                if(sender.isOp() || sender.hasPermission("t3sl4tnt.ver") || !(sender instanceof Player)) {
                    if(args.length < 4 && args.length == 3) {
                        Player target = Bukkit.getPlayer(args[2]);
                        if(target != null) {
                          int gonderilecekAdet = 1;
                          if(isInteger(args[3])) {
                              int gonderilecekTur = Integer.parseInt(args[3]);
                              if(gonderilecekTur == 1) {
                                  if(Item.checkInventory(target)) {
                                      for(int i=0; i<gonderilecekAdet; i++) {
                                          target.getInventory().addItem(T3SL4TNT.item.advancedTNT);
                                      }
                                      sender.sendMessage(MessageUtil.GIVE.replaceAll("%Player%", target.getName()).replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.ANAME));
                                      target.sendMessage(MessageUtil.ADD.replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.ANAME));
                                  } else {
                                      sender.sendMessage(MessageUtil.INVERRORGIVE.replaceAll("%Player%", target.getName()));
                                  }
                              } else if(gonderilecekTur == 2) {
                                  if(Item.checkInventory(target)) {
                                      for(int i=0; i<gonderilecekAdet; i++) {
                                          target.getInventory().addItem(T3SL4TNT.item.advancedTNT);
                                      }
                                      sender.sendMessage(MessageUtil.GIVE.replaceAll("%Player%", target.getName()).replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.EANAME));
                                      target.sendMessage(MessageUtil.ADD.replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.EANAME));
                                  } else {
                                      sender.sendMessage(MessageUtil.INVERRORGIVE.replaceAll("%Player%", target.getName()));
                                  }
                              } else {
                                  turErrorMsg((Player) sender);
                              }
                          } else {
                              sender.sendMessage(MessageUtil.INTERROR);
                          }
                        } else {
                            if(sender instanceof Player) {
                                sender.sendMessage(MessageUtil.NOTONLINE.replaceAll("%Player%", args[2]));
                            } else {
                                Bukkit.getConsoleSender().sendMessage(MessageUtil.NOTONLINE.replaceAll("%Player%", args[2]));
                            }
                        }
                    } else if(args.length == 4) {
                        Player target = Bukkit.getPlayer(args[2]);
                        if(target != null) {
                            if(isInteger(args[3]) && isInteger(args[1])) {
                                int gonderilecekAdet = Integer.parseInt(args[3]);
                                int gonderilecekTur = Integer.parseInt(args[1]);
                                if(gonderilecekTur == 1) {
                                    if(Item.checkInventory(target)) {
                                        for(int i=0; i<gonderilecekAdet; i++) {
                                            target.getInventory().addItem(T3SL4TNT.item.advancedTNT);
                                        }
                                        sender.sendMessage(MessageUtil.GIVE.replaceAll("%Player%", target.getName()).replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.ANAME));
                                        target.sendMessage(MessageUtil.ADD.replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.ANAME));
                                    } else {
                                        sender.sendMessage(MessageUtil.INVERRORGIVE.replaceAll("%Player%", target.getName()));
                                    }
                                } else if(gonderilecekTur == 2) {
                                    if(Item.checkInventory(target)) {
                                        for(int i=0; i<gonderilecekAdet; i++) {
                                            target.getInventory().addItem(T3SL4TNT.item.advancedTNT);
                                        }
                                        sender.sendMessage(MessageUtil.GIVE.replaceAll("%Player%", target.getName()).replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.EANAME));
                                        target.sendMessage(MessageUtil.ADD.replaceAll("%adet%", String.valueOf(gonderilecekAdet)).replaceAll("%advancedTNT%", MessageUtil.EANAME));
                                    } else {
                                        sender.sendMessage(MessageUtil.INVERRORGIVE.replaceAll("%Player%", target.getName()));
                                    }
                                } else {
                                    turErrorMsg((Player) sender);
                                }
                            } else {
                                sender.sendMessage(MessageUtil.INTERROR);
                            }
                        } else {
                            if(sender instanceof Player) {
                                sender.sendMessage(MessageUtil.NOTONLINE.replaceAll("%Player%", args[2]));
                            } else {
                                Bukkit.getConsoleSender().sendMessage(MessageUtil.NOTONLINE.replaceAll("%Player%", args[2]));
                            }
                        }
                    } else {
                        sender.sendMessage(MessageUtil.ARGVER);
                    }
                } else {
                    sender.sendMessage(MessageUtil.PERMERROR);
                }
            } else if(args[0].equalsIgnoreCase("god")) {
                if(sender.isOp() || sender.hasPermission("t3sl4tnt.god") || !(sender instanceof Player)) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if(args.length == 2) {
                        if(target != null) {
                            //TODO
                            //god (kafes) sistemi
                            //Bukkit.getServer().getPluginManager().callEvent(move());
                        } else {
                            if(sender instanceof Player) {
                                sender.sendMessage(MessageUtil.NOTONLINE.replaceAll("%Player%", args[1]));
                            } else {
                                Bukkit.getConsoleSender().sendMessage(MessageUtil.NOTONLINE.replaceAll("%Player%", args[1]));
                            }
                        }
                    } else {
                        sender.sendMessage(MessageUtil.ARGGOD);
                    }
                } else {
                    sender.sendMessage(MessageUtil.PERMERROR);
                }
            } else if(args[0].equalsIgnoreCase("reload")) {
                if(args.length > 1) {
                    sender.sendMessage(MessageUtil.ARGRELOAD);
                } else {
                    if(sender.isOp() || sender.hasPermission("t3sl4tnt.reload") || !(sender instanceof Player)) {
                        manager.reload("config");
                        MessageUtil.loadMessages();
                        sender.sendMessage(MessageUtil.RELOAD);
                    } else {
                        sender.sendMessage(MessageUtil.PERMERROR);
                    }
                }
            }
        }
        return true;
    }

    @EventHandler(priority=EventPriority.NORMAL)
    public void move(PlayerMoveEvent e) {
        e.setCancelled(true);
    }

    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try {
            Integer.parseInt(s);
            isValidInteger = true;
        }
        catch (NumberFormatException ex) {
            return isValidInteger;
        }
        return isValidInteger;
    }

    private void turErrorMsg(Player sender) {
        sender.sendMessage(MessageUtil.TURERROR);
        sender.sendMessage(MessageUtil.TURERROR0);
        sender.sendMessage(MessageUtil.TURERROR1);
    }
}
