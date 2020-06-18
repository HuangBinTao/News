package dao;

import java.sql.SQLException;

import mybean.Beans;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class InputPublishDao extends Dao {

	
	public int inputPublish(String publisID, String publishName, String address) {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "insert into Publish values(?,?,?)";
		
		try {
			return qr.update(sql, publisID, publishName,address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean hasPublishID(String publishID) {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select * from Publish where publishID = ?";
		try {
			@SuppressWarnings("deprecation")
			Beans bean = qr.query(sql, publishID, new BeanHandler<>(Beans.class));
			if(bean!=null){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean hasPublishName(String publishName) {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select * from Publish where publishName = ?";
		try {
			@SuppressWarnings("deprecation")
			Beans bean = qr.query(sql, publishName, new BeanHandler<>(Beans.class));
			if(bean!=null){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
}
