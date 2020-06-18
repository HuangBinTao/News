package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import mybean.Beans;

public class UserResetDao  extends Dao{

		//通过账号得到用户的信息
		@SuppressWarnings("deprecation")
		public Beans getUserInfoByUserID(String userID) {
			// TODO Auto-generated method stub
			QueryRunner qr = new QueryRunner(ds);
			String sql = "select *from Users where userID = ?";
			try {
				return qr.query(sql, userID, new BeanHandler<>(Beans.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("查找用户表的单个人的个人信息时候出错了");
			}
			return null;
		}
		
		//修改用户的用户名 ，性别， 电话
		public int resetUserInfo(String userID, String userName, String sexy, String phoneNum) {
			// TODO Auto-generated method stub
			QueryRunner qr = new QueryRunner(ds);
			String sql = "update Users set userName = ?, sexy = ?, phoneNum = ? where userID = ?";
			try {
				return qr.update(sql, userName, sexy, phoneNum, userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("在修改用户的信息时出现异常");
			}
			return 0;
		}
}
