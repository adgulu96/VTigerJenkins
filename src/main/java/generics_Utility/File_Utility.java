package generics_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility 
{
	/**
	 * This method is used to pass the value from the PROPERTY FILE
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Abinash
	 */
	public String getKeyandValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value =pro.getProperty(key);
		return value;
		
//		String URL=pro.getProperty("url");		
//		String USERNAME=pro.getProperty("username");
//		String PASSWORD=pro.getProperty("password");
	}
}
