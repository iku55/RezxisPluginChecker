package jp.iku55.rpc.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import jp.iku55.rpc.util.LoggerUtils;

public class GetVer {
	public static List<String> getYAMLVersion() {
		List<String> text = new ArrayList<String>();
		
		try {
            URL url = new URL("https://github.com/iku55/rez_versions/raw/main/ver");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            
            String line;
            while ((line = in.readLine()) != null) {
                text.add(line);
            }
            in.close();
        }
        catch (MalformedURLException e) {
        	LoggerUtils.errstart();
        	LoggerUtils.errhead(e.getMessage(), "ERR_GET_CONFIG_VERSION_MALFORMEDURLEXCEPTION");
            e.printStackTrace();
            LoggerUtils.errend();
        }
        catch (IOException e) {
        	LoggerUtils.errstart();
        	LoggerUtils.errhead(e.getMessage(), "ERR_GET_CONFIG_VERSION_IOEXCEPTION");
            e.printStackTrace();
            LoggerUtils.errend();
        }
		
		return text;
	}
}
