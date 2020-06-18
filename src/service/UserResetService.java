package service;

import dao.UserResetDao;
import mybean.Beans;

public class UserResetService {

		//通过账号得到用户的信息
		public Beans getUserInfoByUserID(String userID) {
			// TODO Auto-generated method stub
			
			return new UserResetDao().getUserInfoByUserID(userID);
		}
		
		//修改用户的用户名 ，性别， 电话
		public int resetUserInfo(String userID, String userName, String sexy, String phoneNum) {
			// TODO Auto-generated method stub
			return new UserResetDao().resetUserInfo(userID, userName, sexy, phoneNum);
		}
			
			
			
}
