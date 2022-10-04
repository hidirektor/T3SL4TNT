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
    public static String INFOLINE5;
    public static String RELOAD;
    public static String TNTAL;
    public static String ARGAL;
    public static String ARGVER;
    public static String ARGGOD;
    public static String ARGRELOAD;
    public static String NOTONLINE;
    public static String TURERROR;
    public static String TURERROR0;
    public static String TURERROR1;
    public static String INTERROR;
    public static String INVERROR;
    public static String INVERRORGIVE;
    public static String ANAME;
    public static List<String> ALORE;
    public static String EANAME;
    public static List<String> EALORE;
    public static String ADD;
    public static String GIVE;

    static SettingsManager manager = SettingsManager.getInstance();

    public static void loadMessages() {
        PREFIX = colorize(manager.get("config").getString("Prefix"));
        CONSOLEERROR = PREFIX + colorize(manager.get("config").getString("Messages.Error.ConsoleError"));
        PERMERROR = PREFIX + colorize(manager.get("config").getString("Messages.Error.PermError"));
        INFOLINE1 = colorize(manager.get("config").getString("Messages.Info.Info1"));
        INFOLINE2 = colorize(manager.get("config").getString("Messages.Info.Info2"));
        INFOLINE3 = colorize(manager.get("config").getString("Messages.Info.Info3"));
        INFOLINE4 = colorize(manager.get("config").getString("Messages.Info.Info4"));
        INFOLINE5 = colorize(manager.get("config").getString("Messages.Info.Info5"));
        TNTAL = PREFIX + colorize(manager.get("config").getString("Messages.Success.tntAl"));
        RELOAD = PREFIX + colorize(manager.get("config").getString("Messages.Success.Reload"));
        ARGAL = PREFIX + colorize(manager.get("config").getString("Messages.Usages.alCmd"));
        ARGVER = PREFIX + colorize(manager.get("config").getString("Messages.Usages.verCmd"));
        ARGGOD = PREFIX + colorize(manager.get("config").getString("Messages.Usages.godCmd"));
        ARGRELOAD = PREFIX + colorize(manager.get("config").getString("Messages.Usages.reloadCmd"));
        NOTONLINE = PREFIX + colorize(manager.get("config").getString("Messages.Error.NotOnline"));
        TURERROR = PREFIX + colorize(manager.get("config").getString("Messages.Error.TurError"));
        TURERROR0 = PREFIX + colorize(manager.get("config").getString("Messages.Error.TurError-0"));
        TURERROR1 = PREFIX + colorize(manager.get("config").getString("Messages.Error.TurError-1"));
        INTERROR = PREFIX + colorize(manager.get("config").getString("Messages.Error.IntError"));
        INVERROR = PREFIX + colorize(manager.get("config").getString("Messages.Error.InvError"));
        INVERRORGIVE = PREFIX + colorize(manager.get("config").getString("Messages.Error.InvErrorGive"));
        ANAME = colorize(manager.get("config").getString("TNT.Advanced-Name"));
        ALORE = colorizeList(manager.get("config").getStringList("TNT.Advanced-Lore"));
        EANAME = colorize(manager.get("config").getString("TNT.ExtraAdvanced-Name"));
        EALORE = colorizeList(manager.get("config").getStringList("TNT.ExtraAdvanced-Lore"));
        ADD = PREFIX + colorize(manager.get("config").getString("Messages.Success.Add"));
        GIVE = PREFIX + colorize(manager.get("config").getString("Messages.Success.Give"));
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