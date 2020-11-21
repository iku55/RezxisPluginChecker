package jp.iku55.rpc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import jp.iku55.rpc.commands.CmdPluginList;
import jp.iku55.rpc.config.DownloadYAML;
import jp.iku55.rpc.config.GetVer;
import jp.iku55.rpc.config.PluginVersionsList;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	private static List<Plugin> matchedPlugins = new ArrayList<Plugin>();
	private static List<String> matchedPlnames = new ArrayList<String>();
	private static List<Plugin> differentPlugins = new ArrayList<Plugin>();
	private static List<String> differentPlnames = new ArrayList<String>();
	private static List<Plugin> notavailablePlugins = new ArrayList<Plugin>();
	private static List<String> notavailablePlnames = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void onEnable() {
		String yamlVersion;
		
		// config.yml
		// - save config
		info(ChatColor.AQUA+"config.ymlを読み取っています。");
		getConfig().options().copyDefaults();
        saveDefaultConfig();
        
        // versions.yml
        // - setup/save versions.yml
     	info(ChatColor.AQUA+"versions.ymlを読み取っています。");
     	PluginVersionsList.setup();
        PluginVersionsList.get().options().copyDefaults(true);
        PluginVersionsList.save();
        
        // - get version of versions.yml
        if (PluginVersionsList.get().isSet("yamlversion")) {
        	yamlVersion = PluginVersionsList.get().getString("yamlversion");
        } else {
        	yamlVersion = "";
        }
        
        // - download versions.yml
        String ghYAMLVersion = String.join("", GetVer.getYAMLVersion());
        if (ghYAMLVersion.equals(yamlVersion)) {
        	info(ChatColor.AQUA+"versions.ymlは最新です。");
        } else {
        	info(ChatColor.AQUA+"versions.ymlをダウンロードしています。");
    		DownloadYAML.downloadVersionsYAML();
    		PluginVersionsList.reload();
        }

        // plugins comparison
        // -main
        info(ChatColor.AQUA+"このサーバーに入っているプラグインをRezxisのバージョンと比較しています。");
        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        for (Plugin plugin : plugins) {
			if (PluginVersionsList.get().contains(plugin.getName())) {
				Boolean isMatch = false;
				ArrayList<String> versions = new ArrayList<String>();
				
				for (Object obj : PluginVersionsList.get().getList(plugin.getName()+"")) {
					if (obj instanceof LinkedHashMap) {
						LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) obj;
						versions.add(map.get("version")+"(for "+map.get("mcversion")+")");
						if (plugin.getDescription().getVersion().equals(map.get("version"))) {
							isMatch = true;
						}
					}
				}
				if (isMatch) {
					matchedPlugins.add(plugin);
					matchedPlnames.add(plugin.getName());
					info(ChatColor.GREEN + "\""+plugin.getName()+"\"のバージョンはRezxisのバージョンと一致しています! ");
				} else {
					differentPlugins.add(plugin);
					differentPlnames.add(plugin.getName());
					info(ChatColor.YELLOW + "\""+plugin.getName()+"\"のバージョンはRezxisのバージョンと違います。");
					info(ChatColor.YELLOW + "Rezxisで使用されている\""+plugin.getName()+"\"のバージョンは"+String.join(",", versions)+"です。");
				}
			} else {
				notavailablePlugins.add(plugin);
				notavailablePlnames.add(plugin.getName());
				info(ChatColor.RED+"\""+plugin.getName()+"\"はRezxisで使用できません。");
			}
		}
        // - show result
		info(ChatColor.GREEN+"このサーバーに入っている"+ChatColor.WHITE+plugins.length+ChatColor.GREEN+"個のプラグインのうち、バージョンが一致しているプラグインが"+ChatColor.WHITE+matchedPlugins.size()+ChatColor.GREEN+"個、バージョンが違うプラグインが"+ChatColor.WHITE+differentPlugins.size()+ChatColor.GREEN+"個、使用できないプラグインが"+ChatColor.WHITE+notavailablePlugins.size()+ChatColor.GREEN+"個ありました。");
		
		// register commands
		info(ChatColor.AQUA+"コマンドを登録しています。");
		this.getCommand("pllist").setExecutor(new CmdPluginList());
		
		// end
		info(ChatColor.GREEN+"プラグインを有効化しました");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("[RezxisPluginChecker] "+ChatColor.RED+"プラグインを無効化しました。");
	}
	
	private void info(String text) {
		getServer().getConsoleSender().sendMessage("[RezxisPluginChecker] "+text);
	}
	
	public static List<Plugin> getMatchedplugins() {
		return matchedPlugins;
	}
	
	public static List<Plugin> getDifferentplugins() {
		return differentPlugins;
	}
	
	public static List<Plugin> getNotavailableplugins() {
		return notavailablePlugins;
	}
	
	public static List<String> getMatchedplnames() {
		return matchedPlnames;
	}
	
	public static List<String> getDifferentplnames() {
		return differentPlnames;
	}
	
	public static List<String> getNotavailableplnames() {
		return notavailablePlnames;
	}
}
