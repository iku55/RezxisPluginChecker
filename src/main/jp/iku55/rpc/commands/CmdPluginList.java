package jp.iku55.rpc.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import jp.iku55.rpc.Main;
import net.md_5.bungee.api.ChatColor;

public class CmdPluginList implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//TODO:�v���O�C���̐���\��
		//int plLength = Bukkit.getPluginManager().getPlugins().length;
		List<Plugin> matchedPlugins = Main.getMatchedplugins();
		List<Plugin> differentPlugins = Main.getDifferentplugins();
		List<Plugin> notavailablePlugins = Main.getNotavailableplugins();
		List<String> matchedPlnames = Main.getMatchedplnames();
		List<String> differentPlnames = Main.getDifferentplnames();
		List<String> notavailablePlnames = Main.getNotavailableplnames();
		
		sender.sendMessage(ChatColor.GREEN+"Rezxis�̃o�[�W�����Ɠ����v���O�C��("+matchedPlugins.size()+"):");
		sender.sendMessage(String.join(", ", matchedPlnames));
		sender.sendMessage(ChatColor.YELLOW+"Rezxis�̃o�[�W�����ƈႤ�v���O�C��("+differentPlugins.size()+"):");
		sender.sendMessage(String.join(", ", differentPlnames));
		sender.sendMessage(ChatColor.RED+"Rezxis�Ŏg�p�ł��Ȃ��v���O�C��("+notavailablePlugins.size()+"):");
		sender.sendMessage(String.join(", ", notavailablePlnames));
		return true;
	}

}
