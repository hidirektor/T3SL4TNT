package me.t3sl4.tnt.util;

import java.util.List;

public class MessageUtil {
    public static String PREFIX;
    public static String CONSOLEERROR;
    public static String PERMERROR;
    public static String INFOLINE1;
    public static String INFOLINE2;
    public static String INFOLINE3;
    public static String INFOLINE4;
    public static String RELOAD;
    public static String TNTAL;
    public static String ITEMNAME;
    public static List<String> ITEMLORE;

    static SettingsManager manager = SettingsManager.getInstance();

    public static void loadMessages() {
        PREFIX = colorize(manager.get("config").getString("Prefix"));
        CONSOLEERROR = PREFIX + colorize(manager.get("config").getString("Messages.Error.ConsoleError"));
        PERMERROR = PREFIX + colorize(manager.get("config").getString("Messages.Error.PermError"));
        INFOLINE1 = colorize(manager.get("config").getString("Messages.Info.Info1"));
        INFOLINE2 = colorize(manager.get("config").getString("Messages.Info.Info2"));
        INFOLINE3 = colorize(manager.get("config").getString("Messages.Info.Info3"));
        INFOLINE4 = colorize(manager.get("config").getString("Messages.Info.Info4"));
        TNTAL = PREFIX + colorize(manager.get("config").getString("Messages.Success.tntAl"));
        RELOAD = PREFIX + colorize(manager.get("config").getString("Messages.Success.Reload"));
        ITEMNAME = colorize(manager.get("config").getString("TNT.Name"));
        ITEMLORE = colorizeList(manager.get("config").getStringList("TNT.Lore"));
    }

    public static String colorize(String str) {
        return str.replace("&", "§");
    }

    public static List<String> colorizeList(List<String> str) {
        for(int x=0; x<str.size(); x++) {
            str.set(x, str.get(x).replace("&", "§"));
        }
        return str;
    }
}