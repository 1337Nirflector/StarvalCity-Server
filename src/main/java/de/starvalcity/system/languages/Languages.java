package de.starvalcity.system.languages;

import java.util.HashMap;

public class Languages {

    public static HashMap<String, String> availableLanguages = new HashMap<>();

    public static String deGE = "lang_german";
    public static String enUK = "lang_english";

    public static void setAvailableLanguages(HashMap<String, String> availableLanguages) {
        Languages.availableLanguages = availableLanguages;
        availableLanguages.put(deGE, "german");
        availableLanguages.put(enUK, "english");
    }
}
