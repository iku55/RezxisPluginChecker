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
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"[RezxisPluginChecker] [ERR] エラーが発生しました！");
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"[RezxisPluginChecker] [ERR] できればバグ報告をお願いします: https://github.com/iku55/RezxisPluginChecker/issues");
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"[RezxisPluginChecker] [ERR] エラー内容: "+errcontent+"("+errid+"");
	}
	
	public static void errstart() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"---------- [ERRLOG] ----------");
	}
	
	public static void errend() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"------------------------------");
	}
}
