package de.starvalcity.system.filespackage;

public class SystemMessagesManager {

    /* Startup messages */
    public static String startupMessage = "§2Loading §6StarvalCity§2 system ...";
    public static String loadingMySQLDatabase = "§2Loading §eMySQL database §2...";
    public static String loadingEnglishMessages = "§2Loading resource §eenENG.yml §2...";
    public static String loadingGermanMessages = "§2Loading resource §edeGER.yml §2...";
    public static String loadingCommands = "§2Loading §ecommands §2...";
    public static String loadingEvents = "§2Loading §eevents §2and §elisteners §2...";
    public static String loadingDependencies = "§2Loading §eAPI dependencies §2...";
    public static String loadingLogger = "§2Loading §eServer Logger§2 ...";

    /* Shutdown messages */
    public static String shutdownMessage = "§4Disabling §6StarvalCity§2 system ...";

    /* Database messages */
    public static String mySQLDatabaseLoadingSuccess = "§2MySQL database successfully connected!";
    public static String mySQLDatabaseLoadingError = "§4Error while loading MySQL database! Incorrect login or" +
            " inactive database!";

    /* Console command messages */
    public static String playerRelatedCommand = "§4This command can only be executed by a §eplayer§4!";

}
