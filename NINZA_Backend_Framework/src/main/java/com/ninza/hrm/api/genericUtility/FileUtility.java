package com.ninza.hrm.api.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./config-env-Data/configEnvdata.properties");
		Properties pos = new Properties();
		pos.load(fis);
		String data = pos.getProperty(key);
		return data;
		
	}
	
	public void setDataToPropertyFile(String key, String value) throws Throwable {
		FileInputStream fis = new FileInputStream("./config-env-Data/configEnvdata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		pro.setProperty(key, value);
		
		FileOutputStream fos = new FileOutputStream("./config-env-Data/configEnvdata.properties");
		pro.store(fos, "Created One Key");
		
	}
}