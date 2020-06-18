package dao;

import java.beans.Beans;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class RegisterDao extends Dao{

	public int register(String userID, String userName, String userPassword1,
			String userPassword2, String sexy, String phoneNum) {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "insert into Users values(?,?,?,?,?)";
		
		try {
			return qr.update(sql, userID, userName, sexy, phoneNum, userPassword1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean hasUserID(String userID) throws SQLException {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select * from Users where userID = ?";
		if(qr.query(sql, userID, new BeanHandler<>(Beans.class)) == null){
			return false;
		}else{
			return true;
		}
		
	}

	
}
