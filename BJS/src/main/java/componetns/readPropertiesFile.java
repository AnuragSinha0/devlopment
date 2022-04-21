package componetns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class readPropertiesFile {

	static Properties prop = new Properties();

	public static String getPropertyByKeyValue(String key) throws Exception {
		String propertyFIlepath = System.getProperty("user.dir") + "/src/test/resources/url.properties";
		FileInputStream file = new FileInputStream(propertyFIlepath);
		prop.load(file);
		String keyValue = prop.get(key).toString();

		if (StringUtils.isEmpty(keyValue)) {

			throw new Exception(
					"***** Value Is Null/Empty for Key ***** :  " + key + "***** In Properties File ***** ");
		}
		return keyValue;
	}

	
	/*public static void writePropertyByKeyValue() throws Exception {
		String proprtyFilepath = System.getProperty("user.dir") + "/src/test/resources/url.properties";
		FileOutputStream output = new FileOutputStream(proprtyFilepath);
		prop.setProperty("password",  encriptData.encodePasswrod());
		prop.store(output, "");
	}
	public static void main(String[] args) throws Exception {
		writePropertyByKeyValue();
	}*/
}
