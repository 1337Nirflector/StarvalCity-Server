package de.starvalcity.system.basepackage;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FileWriter {

    private final File file;
    private final YamlConfiguration yamlConfiguration;

    public FileWriter(String FilePath, String FileName) {

        this.file = new File(FilePath, FileName);
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);

    }

    public FileWriter setValue(String ValuePath, Object Value) {
        yamlConfiguration.set(ValuePath, Value);
        return this;
    }

    public boolean exist() {
        return file.exists();
    }

    public Object getObject(String ValuePath) {
        return yamlConfiguration.get(ValuePath);
    }

    public int getInt(String ValuePath) {
        return yamlConfiguration.getInt(ValuePath);
    }

    public String getString(String ValuePath) {
        return yamlConfiguration.getString(ValuePath);
    }

    public boolean containsString(String ValuePath) {
        return yamlConfiguration.get
    }

    public boolean getBoolean(String ValuePath) {
        return yamlConfiguration.getBoolean(ValuePath);
    }

    public long getLong(String ValuePath) {
        return yamlConfiguration.getLong(ValuePath);
    }

    public List<String> getStringList(String ValuePath) {
        return yamlConfiguration.getStringList(ValuePath);
    }

    public Set<String> getKeys(boolean deep) {
        return yamlConfiguration.getKeys(deep);
    }

    public ConfigurationSection getConfigurationSection(String Section) {
        return yamlConfiguration.getConfigurationSection(Section);
    }

    public FileWriter saveFile() {
        try {
            yamlConfiguration.save(this.file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return this;
    }
}
