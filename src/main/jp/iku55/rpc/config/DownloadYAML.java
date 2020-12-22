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

import jp.iku55.rpc.util.LoggerUtils;

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
			LoggerUtils.errstart();
			LoggerUtils.errhead(e.getMessage(), "ERR_DOWNLOAD_CONFIG_FILE_FILENOTFOUNDEXCEPTION");
			e.printStackTrace();
			LoggerUtils.errend();
		} catch (ProtocolException e) {
			LoggerUtils.errstart();
			LoggerUtils.errhead(e.getMessage(), "ERR_DOWNLOAD_CONFIG_FILE_PROTOCOLEXCEPTION");
			e.printStackTrace();
			LoggerUtils.errend();
		} catch (MalformedURLException e) {
			LoggerUtils.errstart();
			LoggerUtils.errhead(e.getMessage(), "ERR_DOWNLOAD_CONFIG_FILE_MALFORMEDURLEXCEPTION");
			e.printStackTrace();
			LoggerUtils.errend();
		} catch (IOException e) {
			LoggerUtils.errstart();
			LoggerUtils.errhead(e.getMessage(), "ERR_DOWNLOAD_CONFIG_FILE_IOEXCEPTION");
		    e.printStackTrace();
		    LoggerUtils.errend();
		} catch (Exception e) {
			LoggerUtils.errstart();
			LoggerUtils.errhead(e.getMessage(), "ERR_DOWNLOAD_CONFIG_FILE_EXCEPTION");
			e.printStackTrace();
			LoggerUtils.errend();
		}
	}
}
