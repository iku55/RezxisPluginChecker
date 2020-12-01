package jp.iku55.rpc;

import java.util.LinkedHashMap;
import java.util.List;

import org.bukkit.plugin.Plugin;

import jp.iku55.rpc.config.PluginVersionsList;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class GenPluginList {
	public static TextComponent generatePluginList(List<Plugin> plugins, LinkedHashMap<String, PluginVersions> plversions) {
		TextComponent plMessage = new TextComponent();
		int count = 0;
		for (Plugin plugin : plugins) {
			count++;
			if (count != 1) plMessage.addExtra(", ");
			TextComponent msg = new TextComponent(plugin.getName());
			
			
			TextComponent hoverl1 = new TextComponent(plugin.getName());
			hoverl1.setColor(ChatColor.AQUA);
			ComponentBuilder hovermsg = new ComponentBuilder(hoverl1);
			hovermsg.append("\n");
			
			TextComponent hoverl2;
			if (plugin.getDescription().getDescription() == null) {
				hoverl2 = new TextComponent("(No description)");
			} else {
				hoverl2 = new TextComponent(plugin.getDescription().getDescription());
			}
			hoverl2.setColor(ChatColor.GRAY);
			hovermsg.append(hoverl2);
			hovermsg.append("\n");
					
			TextComponent hoverl3 = new TextComponent("v"+plugin.getDescription().getVersion());
			hoverl3.setColor(ChatColor.GRAY);
			hovermsg.append(hoverl3);
			
			if (PluginVersionsList.get().contains(plugin.getName())) {
				hovermsg.append("\n");
				
				TextComponent hoverl4 = new TextComponent("In rezxis: "+String.join(", ", plversions.get(plugin.getName()).getVersions()));
				hoverl4.setColor(ChatColor.BLUE);
				hovermsg.append(hoverl4);
			}
			
			msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hovermsg.create()));
			
			plMessage.addExtra(msg);
		}
		return plMessage;
	}
}
