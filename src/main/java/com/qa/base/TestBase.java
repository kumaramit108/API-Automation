package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public Properties prop;
	
	public TestBase(){
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("D:\\Selenium Projects\\restapi\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
