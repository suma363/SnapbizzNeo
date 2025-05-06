package FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
public String getDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/main/resources/Config.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String data = pObj.getProperty(key);
		
		return data;
	}

}
