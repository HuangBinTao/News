package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import mybean.Beans;

public class FindDao extends Dao {

	//查找用户，报刊，报社的所有信息
	public List<Beans> findAllUsers(){
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select *from Users";
		
		try {
			return qr.query(sql, new BeanListHandler<>(Beans.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Beans> findAllPublish() {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select *from Publish";
		
		try {
			return qr.query(sql, new BeanListHandler<>(Beans.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Beans> findAllNews() {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select *from News, Publish where News.publishID = Publish.PublishID";
		
		try {
			return qr.query(sql, new BeanListHandler<>(Beans.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
