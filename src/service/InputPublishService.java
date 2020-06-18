package service;

import dao.InputPublishDao;

public class InputPublishService {

	
	
	
	
	//若都不是则未知错误
	public int inputPublish(String publishID, String publishName, String address){
		//若输入框为空，则返回  2
		if(publishID.length() == 0||publishName.length() == 0 || address.length() == 0){
			return 2;
		}else if(hasPublishID(publishID)){
			//若已经存在该报社号，则返回  3
			return 3;
		}else if(hasPublisName(publishName)){
			//若与已有报社名字相同则返回4
			return 4;
		}else {
			//若录入成功则返回  1
			return new InputPublishDao().inputPublish(publishID, publishName, address);
		}
	}

	private boolean hasPublisName(String publishName) {
		// TODO Auto-generated method stub
		return new InputPublishDao().hasPublishName(publishName);
	}

	private boolean hasPublishID(String publishID) {
		
		return new InputPublishDao().hasPublishID(publishID);
	}
	
	
}
