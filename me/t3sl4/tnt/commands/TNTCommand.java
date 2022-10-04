package me.t3sl4.tnt.commands;

import me.t3sl4.tnt.util.MessageUtil;
import me.t3sl4.tnt.util.SettingsManager;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
            } else if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("t3sl4tnt.reload")) {
                manager.reload("config");
                MessageUtil.loadMessages();
                sender.sendMessage(MessageUtil.RELOAD);
            }
        }
        return true;
    }

    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try
        {
            Integer.parseInt(s);
            isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
        }
        return isValidInteger;
    }
}
