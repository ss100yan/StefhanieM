package com.revature.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * This is a configuration class that will access the data in my properties file.
 */
public class Props {

	public Properties getProps() {
		Class<Props> clazz = Props.class;
		Properties props = new Properties();
		InputStream fis = clazz.getResourceAsStream("/credentials.properties");

		// Now we have to load the properties in the file:
		try {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return props;
	}
	
	public static void main(String[] args) {
		Props prop = new Props();
		Properties credentials = prop.getProps();
		
		System.out.println(credentials.get("username"));
		System.out.println(credentials.get("password"));
	}

}
