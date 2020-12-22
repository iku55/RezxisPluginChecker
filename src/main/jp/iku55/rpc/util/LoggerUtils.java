package jp.iku55.rpc.util;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class LoggerUtils {
	public static void info(String message, Boolean header) {
		if (header) {
			Bukkit.getServer().getConsoleSender().sendMessage("[RezxisPluginChecker] "+message);
		} else {
			Bukkit.getServer().getConsoleSender().sendMessage(message);
		}
	}
	
	public static void errinfo(String message, Boolean header) {
		if (header) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"[RezxisPluginChecker] [ERR]"+message);
		} else {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"[ERR] "+message);
		}
	}
	
	public static void errhead(String errcontent, String errid) {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"[RezxisPluginChecker] [ERR] �G���[���������܂����I");
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"[RezxisPluginChecker] [ERR] �ł���΃o�O�񍐂����肢���܂�: https://github.com/iku55/RezxisPluginChecker/issues");
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"[RezxisPluginChecker] [ERR] �G���[���e: "+errcontent+"("+errid+"");
	}
	
	public static void errstart() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"---------- [ERRLOG] ----------");
	}
	
	public static void errend() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"------------------------------");
	}
}
