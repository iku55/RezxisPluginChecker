package jp.iku55.rpc.commands;

import java.util.LinkedHashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import jp.iku55.rpc.GenPluginList;
import jp.iku55.rpc.Main;
import jp.iku55.rpc.PluginVersions;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class CmdPluginList implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		List<Plugin> matchedPlugins = Main.getMatchedplugins();
		List<Plugin> differentPlugins = Main.getDifferentplugins();
		List<Plugin> notavailablePlugins = Main.getNotavailableplugins();
		LinkedHashMap<String, PluginVersions> plversions = Main.getPlversions();
		
		TextComponent matchedPlMessage = GenPluginList.generatePluginList(matchedPlugins, plversions);
		TextComponent differentPlMessage = GenPluginList.generatePluginList(differentPlugins, plversions);
		TextComponent notavailablePlMessage = GenPluginList.generatePluginList(notavailablePlugins, plversions);
		
		sender.sendMessage(ChatColor.GREEN+"Rezxisのバージョンと同じプラグイン("+matchedPlugins.size()+"):");
		sender.spigot().sendMessage(matchedPlMessage);
		sender.sendMessage(ChatColor.YELLOW+"Rezxisのバージョンと違うプラグイン("+differentPlugins.size()+"):");
		sender.spigot().sendMessage(differentPlMessage);
		sender.sendMessage(ChatColor.RED+"Rezxisで使用できないプラグイン("+notavailablePlugins.size()+"):");
		sender.spigot().sendMessage(notavailablePlMessage);
		return true;
	}

}
