package service;

import java.sql.SQLException;
import java.util.List;

import mybean.Beans;
import dao.InputNewsDao;

public class InputNewsService {

	
	
	
	
	//若都不是则未知错误
	public int inputNews(String newsID, String newsName, String newsPrice, String publishName){
		//若输入框为空，则返回  2
		if(newsID.length() == 0 || newsName.length() == 0 || publishName.length() == 0 || newsPrice.length() == 0){
			return 2;
		}else if(hasNewsID(newsID)){
			//若已经存在该报刊号，则返回  3
			return 3;
		}else if(hasNewsName(newsName)){
			//若与已有报刊名字相同则返回4
			return 4;
		}else {
			double newsPrices = 0;
			try{
				newsPrices = Double.parseDouble(newsPrice);
			}catch(Exception e){
				return 5;
			}
			//若录入成功则返回  1
			return new InputNewsDao().inputNews(newsID, newsName, newsPrices, publishName);
		}
	}

	private boolean hasNewsName(String newsName) {
		// TODO Auto-generated method stub
		return new InputNewsDao().hasNewsName(newsName);
	}

	private boolean hasNewsID(String newsID) {
		
		
		return new InputNewsDao().hasNewsID(newsID);
	}

	public List<Beans> getPublishInfo() {
		// TODO Auto-generated method stub
		List<Beans> beans = null;
		try {
			beans = new InputNewsDao().getPublishInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beans;
	}
	
	
	
	
}
