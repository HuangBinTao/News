package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import mybean.Beans;

public class InputNewsDao extends Dao{

	
	
	public int inputNews(String newsID, String newsName, double newsPrices, String publishName) {
		QueryRunner qr = new QueryRunner(ds);
		
		String publishIDs = getPublishIDByPublishName(publishName);
		
		String sql = "insert into News (newsID, newsName, newsPrice, publishID)values(?, ?, ?, ?)";
		
		try {
			return qr.update(sql, newsID, newsName, newsPrices, publishIDs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0 ;
	}

	private String getPublishIDByPublishName(String publishName) {
		QueryRunner qr = new QueryRunner(ds);
		Beans bean = null;
		String sql = "select *from Publish where publishName = ?";
		try {
			bean = qr.query(sql, publishName, new BeanHandler<>(Beans.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bean.getPublishID());
		return bean.getPublishID();
	}

	public List<Beans> getPublishInfo() throws SQLException {
//		ComboPooledDataSource ks = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select *from Publish";
		
		return qr.query(sql, new BeanListHandler<>(Beans.class));
	}

	public boolean hasNewsName(String newsName) {
		QueryRunner  qr = new QueryRunner(ds);
		String sql = "select *from News where newsName = ?";
		try {
			if(qr.query(sql, newsName, new BeanHandler<>(Beans.class))!=null){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean hasNewsID(String newsID) {
		QueryRunner  qr = new QueryRunner(ds);
		String sql = "select *from News where newsID = ?";
		try {
			if(qr.query(sql, newsID, new BeanHandler<>(Beans.class))!=null){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
