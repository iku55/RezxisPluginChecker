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
	private static List<Plugin> differentPlugins = new ArrayList<Plugin>();
	private static List<Plugin> notavailablePlugins = new ArrayList<Plugin>();
	private static LinkedHashMap<String, PluginVersions> plversions = new LinkedHashMap<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void onEnable() {
		String yamlVersion;
		
		// config.yml
		// - save config
		info(ChatColor.AQUA+"config.yml��ǂݎ���Ă��܂��B");
		getConfig().options().copyDefaults();
        saveDefaultConfig();
        
        // versions.yml
        // - setup/save versions.yml
     	info(ChatColor.AQUA+"versions.yml��ǂݎ���Ă��܂��B");
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
        	info(ChatColor.AQUA+"versions.yml�͍ŐV�ł��B");
        } else {
        	info(ChatColor.AQUA+"versions.yml���_�E�����[�h���Ă��܂��B");
    		DownloadYAML.downloadVersionsYAML();
    		PluginVersionsList.reload();
        }

        // plugins comparison
        // -main
        info(ChatColor.AQUA+"���̃T�[�o�[�ɓ����Ă���v���O�C����Rezxis�̃o�[�W�����Ɣ�r���Ă��܂��B");
        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        for (Plugin plugin : plugins) {
			if (PluginVersionsList.get().contains(plugin.getName())) {
				Boolean isMatch = false;
				List<String> versions = new ArrayList<String>();
				
				for (Object obj : PluginVersionsList.get().getList(plugin.getName()+"")) {
					if (obj instanceof LinkedHashMap) {
						LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) obj;
						versions.add(map.get("version")+"(for "+map.get("mcversion")+")");
						if (plugin.getDescription().getVersion().equals(map.get("version"))) {
							isMatch = true;
						}
					}
				}
				
				plversions.put(plugin.getName(), new PluginVersions(plugin.getName(), versions));
				if (isMatch) {
					matchedPlugins.add(plugin);
					info(ChatColor.GREEN + "\""+plugin.getName()+"\"�̃o�[�W������Rezxis�̃o�[�W�����ƈ�v���Ă��܂�! ");
				} else {
					differentPlugins.add(plugin);
					info(ChatColor.YELLOW + "\""+plugin.getName()+"\"�̃o�[�W������Rezxis�̃o�[�W�����ƈႢ�܂��B");
					info(ChatColor.YELLOW + "Rezxis�Ŏg�p����Ă���\""+plugin.getName()+"\"�̃o�[�W������"+String.join(",", versions)+"�ł��B");
				}
			} else {
				notavailablePlugins.add(plugin);
				info(ChatColor.RED+"\""+plugin.getName()+"\"��Rezxis�Ŏg�p�ł��܂���B");
			}
		}
        // - show result
		info(ChatColor.GREEN+"���̃T�[�o�[�ɓ����Ă���"+ChatColor.WHITE+plugins.length+ChatColor.GREEN+"�̃v���O�C���̂����A�o�[�W��������v���Ă���v���O�C����"+ChatColor.WHITE+matchedPlugins.size()+ChatColor.GREEN+"�A�o�[�W�������Ⴄ�v���O�C����"+ChatColor.WHITE+differentPlugins.size()+ChatColor.GREEN+"�A�g�p�ł��Ȃ��v���O�C����"+ChatColor.WHITE+notavailablePlugins.size()+ChatColor.GREEN+"����܂����B");
		
		// register commands
		info(ChatColor.AQUA+"�R�}���h��o�^���Ă��܂��B");
		this.getCommand("pllist").setExecutor(new CmdPluginList());
		
		// end
		info(ChatColor.GREEN+"�v���O�C����L�������܂���");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("[RezxisPluginChecker] "+ChatColor.RED+"�v���O�C���𖳌������܂����B");
	}
	
	private void info(String text) {
		getServer().getConsoleSender().sendMessage("[RezxisPluginChecker] "+text);
	}
	
	/**
	 * Rezxis�̃o�[�W�����ƈ�v���Ă���v���O�C��(Plugin�^)��List��Ԃ��܂��B
	 * @return java.util.List<org.bukkit.plugin.Plugin>
	 * @author iku55
	 * @since 1.0.0
	 */
	public static List<Plugin> getMatchedplugins() {
		return matchedPlugins;
	}
	
	/**
	 * Rezxis�̃o�[�W�����ƈႤ�v���O�C��(Plugin�^)��List��Ԃ��܂��B
	 * @return java.util.List<org.bukkit.plugin.Plugin>
	 * @author iku55
	 * @since 1.0.0
	 */
	public static List<Plugin> getDifferentplugins() {
		return differentPlugins;
	}
	
	/**
	 * Rezxis�Ŏg�p�ł��Ȃ��v���O�C��(Plugin�^)��List��Ԃ��܂��B
	 * @return java.util.List<org.bukkit.plugin.Plugin>
	 * @author iku55
	 * @since 1.0.0
	 */
	public static List<Plugin> getNotavailableplugins() {
		return notavailablePlugins;
	}
	
	/**
	 * versions.yml�̓��e��String��PluginVersions��LinkedHashMap�ɂ������̂�Ԃ��܂��B
	 * @return java.util.LinkedHashMap<java.lang.String, jp.iku55.rpc.PluginVersions>
	 * @author iku55
	 * @since 1.1.0
	 */
	public static LinkedHashMap<String, PluginVersions> getPlversions() {
		return plversions;
	}
}
