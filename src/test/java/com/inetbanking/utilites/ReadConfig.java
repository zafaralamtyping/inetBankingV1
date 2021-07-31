package com.inetbanking.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		try {
			FileInputStream fis = new FileInputStream("./Configurations/config.properties");
			pro = new Properties();
			pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is: " + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		return pro.getProperty("baseURL");
	}
	
	public String getUserName() {
		return pro.getProperty("username");
	}
	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getChromePath() {
		return pro.getProperty("chromepath");
	}
	
	public String getIEPath() {
		return pro.getProperty("iepath");
	}
	public String getFirefoxPath() {
		return pro.getProperty("firefoxpath");
	}
	
}
