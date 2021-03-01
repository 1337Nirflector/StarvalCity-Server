package de.starvalcity.system.base.messages;

import java.util.ArrayList;

public class PrefixesHandler {

    public static ArrayList<String> prefixes = new ArrayList<>();

    String basicPrefix = "§7[§6§lStarvalCity§7]§f ";
    String staffPrefix = "§7[§9§lStaff§7]§f ";

    public void initializePrefixes() {
        prefixes.set(0, basicPrefix);
        prefixes.set(1, staffPrefix);
    }
}
