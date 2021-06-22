package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	public static Properties readProperties(String fileName) throws Exception
	{
		fileName = fileName.trim();
		InputStream fileReader = new FileInputStream(fileName);
		Properties properties = new Properties();
		properties.load(fileReader);
		return properties;
	}

}
