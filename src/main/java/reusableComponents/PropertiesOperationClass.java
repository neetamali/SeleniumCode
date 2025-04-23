package reusableComponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperationClass {

	static Properties prop = new Properties();
	
	public static String getPropertyValueKey(String key) throws Exception {
		//load data from properties file
		String propFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
	FileInputStream fis = new FileInputStream(propFilePath);
	prop.load(fis);
	
	//read data
	String value = prop.get(key).toString();
	if(StringUtils.isEmpty(value)) {
		throw new Exception("Value is not specified for "+key+" in the properties file");
		
	}
	return value;
	}
}
