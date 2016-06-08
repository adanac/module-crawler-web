package com.adanac.module.crawler.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * 数据库访问配置文件各参数的获取
 * @author adanac
 *
 */
public class DbConfig {
	// 数据库及server配置文件路径
	private static final String ACTIONPATH = "config.properties";
	private static DbConfig instance = null;

	private String db_username = null;
	private String db_password = null;
	private String db_name = null;
	private String ip = null;
	private String ags_user = null;
	private String ags_password = null;
	private String ags_domain = null;
	private String ags_host = null;
	private String ags_servicename = null;

	private DbConfig() {
	}

	public String getDb_username() {
		return db_username;
	}

	public String getDb_password() {
		return db_password;
	}

	public String getDb_name() {
		return db_name;
	}

	public String getIp() {
		return ip;
	}

	public String getAgs_user() {
		return ags_user;
	}

	public String getAgs_password() {
		return ags_password;
	}

	public String getAgs_domain() {
		return ags_domain;
	}

	public String getAgs_host() {
		return ags_host;
	}

	public String getAgs_servicename() {
		return ags_servicename;
	}

	public static DbConfig getInstance() {
		if (instance == null) {
			instance = new DbConfig().getNewDbConfig();
		}
		return instance;
	}

	private DbConfig getNewDbConfig() {

		DbConfig dc = new DbConfig();
		Properties prop = new Properties();
		String path = null;
		FileInputStream fis = null;

		try {
			path = DbConfig.class.getClassLoader().getResource("").toURI().getPath();
			fis = new FileInputStream(new File(path + ACTIONPATH));
			prop.load(fis);
			dc.db_username = prop.getProperty("db_username");
			dc.db_password = prop.getProperty("db_password");
			dc.db_name = prop.getProperty("db_name");
			dc.ip = prop.getProperty("ip");
			dc.ags_user = prop.getProperty("ags_user");
			dc.ags_password = prop.getProperty("ags_password");
			dc.ags_domain = prop.getProperty("ags_domain");
			dc.ags_host = prop.getProperty("ags_host");
			dc.ags_servicename = prop.getProperty("ags_servicename");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dc;
	}
}
