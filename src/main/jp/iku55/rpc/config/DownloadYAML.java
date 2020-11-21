package jp.iku55.rpc.config;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.bukkit.Bukkit;

public class DownloadYAML {
	public static void downloadVersionsYAML() {
		try {
			URL url = new URL("https://raw.githubusercontent.com/iku55/rez_versions/main/versions.yml");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setAllowUserInteraction(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestMethod("GET");
			conn.connect();
	
			int httpStatusCode = conn.getResponseCode();
			if (httpStatusCode != HttpURLConnection.HTTP_OK) {
				throw new Exception("HTTP Status " + httpStatusCode);
			}
	
			// Input Stream
			DataInputStream dataInStream = new DataInputStream(conn.getInputStream());
	
			// Output Stream
			DataOutputStream dataOutStream = new DataOutputStream(
					new BufferedOutputStream(
			              new FileOutputStream(
			            		  new File(Bukkit.getServer().getPluginManager().getPlugin("RezxisPluginChecker").getDataFolder(), "versions.yml")
			            		  )));
	
			// Read Data
			byte[] b = new byte[4096];
			int readByte = 0;
	
			while (-1 != (readByte = dataInStream.read(b))) {
				dataOutStream.write(b, 0, readByte);
			}
	
			// Close Stream
			dataInStream.close();
			dataOutStream.close();
	
		} catch (FileNotFoundException e) {
			    e.printStackTrace();
		} catch (ProtocolException e) {
			    e.printStackTrace();
		} catch (MalformedURLException e) {
			    e.printStackTrace();
		} catch (IOException e) {
		    	e.printStackTrace();
		} catch (Exception e) {
			    System.out.println(e.getMessage());
			    e.printStackTrace();
		}
	}
}
