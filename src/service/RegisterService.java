package service;

import java.sql.SQLException;

import dao.RegisterDao;

public class RegisterService {

	//  1注册成功
	public int register(String userID, String userName, String userPassword1,
			String userPassword2, String sexy, String phoneNum) {
		
		if(hasUserID(userID)){
			//3已经存在该账号
			return 3;
		}else if(!userPassword1.equals(userPassword2)){
			System.out.println(userPassword1);
			System.out.println(userPassword2);
			//2两次密码输入不一致
			return 2;
		}else {
			
			return new RegisterDao().register(userID, userName, userPassword1, userPassword2, sexy, phoneNum);
		}
		
		
		
	}

	private boolean hasUserID(String userID) {
		// TODO Auto-generated method stub
		try {
			return new RegisterDao().hasUserID(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("在判断数据库有没有该账号的时候出现异常");
		}
		return false;
	}

	
	
	
	
	
}
