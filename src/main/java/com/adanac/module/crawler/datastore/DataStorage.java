package com.adanac.module.crawler.datastore;

import java.sql.Connection;
import java.util.List;

import com.adanac.module.crawler.db.MySql2;
import com.adanac.module.crawler.entity.News;

/**
 * 將數據存儲到數據庫
 * Created by allen
 */
public class DataStorage {

	public void dataStore(String strUrl, List<News> newsList) {
		String sqlLeagues = "";
		// 创建MySql类的对象 用于执行MySql语句
		MySql2 ms = new MySql2();
		Connection conn = ms.getConn();
		int i = 0; // 定义一个i来记录循环次数
		// 开始读取数据 如果读到的数据不为空 则往里面读
		String scontent = "";
		String title = "";
		for (News news : newsList) {
			scontent = news.getShortContent().replaceAll("\"", "\'");
			title = news.getTitle().replaceAll("\"", "\'");
			// MySql插入语句
			sqlLeagues = "INSERT INTO tab1(url,title,content) values(\"" + news.getUrl() + "\"," + "\"" + title + "\","
					+ "\"" + scontent + "\")";
			ms.datatoMySql(sqlLeagues);
			i++;
			System.out.println("第" + i + "条数据插入成功");
		}
		ms.closeConn(conn);
		System.out.println("数据存储完毕,共插入数据库" + i + "条记录");
	}
}
