package jp.iku55.rpc.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import jp.iku55.rpc.util.LoggerUtils;

import java.io.File;
import java.io.IOException;

public class PluginVersionsList {

    private static File file;
    private static FileConfiguration customFile;

    //Finds or generates the custom config file
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("RezxisPluginChecker").getDataFolder(), "versions.yml");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
            	LoggerUtils.errhead(e.getMessage(), "ERR_CONFIG_FILE_CREATE");
                e.printStackTrace();
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try{
            customFile.save(file);
        }catch (IOException e){
        	LoggerUtils.errstart();
        	LoggerUtils.errhead(e.getMessage(), "ERR_CONFIG_FILE_SAVE");
            e.printStackTrace();
            LoggerUtils.errend();
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
