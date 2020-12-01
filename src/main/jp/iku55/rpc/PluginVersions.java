package jp.iku55.rpc;

import java.util.List;

public class PluginVersions {
	private String name;
	private List<String> versions;
	
	public PluginVersions(String name, List<String> versions) {
		this.name = name;
		this.versions = versions;
	}
	
	public String getName() {
		return name;
	}
	
	public List<String> getVersions() {
		return versions;
	}
	
	public void addVersion(String version) {
		this.versions.add(version);
	}
}
