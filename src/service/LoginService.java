package service;

import java.sql.SQLException;

import mybean.Beans;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class LoginService {

	//3’À∫≈ªÚ√‹¬Î¥ÌŒÛ
	//1µ«¬º≥…π¶
	public int login(String userID, String userPassword) throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select *from Users where userID = ? and userPassword = ?";
		String[] params = new String[]{
				userID, userPassword
		};
		if(qr.query(sql, params, new BeanHandler<>(Beans.class)) == null){
			return 3;
		}else{
			return 1;
		}
		
	}

}
