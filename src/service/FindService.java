package service;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import mybean.Beans;
import dao.FindDao;

public class FindService {

	//根据值去数据库找对应的（用户，报刊，报社）表，将得到的表的model设置到表上
	public DefaultTableModel getTableModel(String str){
		
		List<Beans> beans = null;
		DefaultTableModel model = new DefaultTableModel();
		if(str.equals("用户")){
			beans = new FindDao().findAllUsers();
		}else if(str.equals("报刊")){
			beans = new FindDao().findAllNews();
		}else if(str.equals("报社")){
			beans = new FindDao().findAllPublish();
		}
		
		
		if(beans.size() == 0){
			String[] name = new String[]{
					"属性1", "属性2", "属性3", "属性4"
			};
			model = new DefaultTableModel(name, 16);
		}else{
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			for (Beans bean : beans) {
				Vector<String> row = new Vector<String>();
				if(str.equals("用户")){
					row.add(bean.getUserID());
					row.add(bean.getUserName());
					row.add(bean.getSexy());
					row.add(bean.getPhoneNum());
					data.add(row);
				}else if(str.equals("报刊")){
					row.add(bean.getNewsID());
					row.add(bean.getNewsName());
					row.add(bean.getNewsPrice());
					row.add(bean.getPublishName());
					data.add(row);
				}else if(str.equals("报社")){
					row.add(bean.getPublishID());
					row.add(bean.getPublishName());
					row.add(bean.getAddress());
					data.add(row);
				}
			}
			Vector<String> name = new Vector<String>();
			if(str.equals("用户")){
				name.add("账号");
				name.add("用户名");
				name.add("性别");
				name.add("电话");
			}else if(str.equals("报刊")){
				name.add("报刊号");
				name.add("报刊名");
				name.add("报刊单价");
				name.add("报社");
			}else if(str.equals("报社")){
				name.add("报社号");
				name.add("报社名");
				name.add("报社地址");
			}
			
			
			model.setDataVector(data, name);
			if(beans.size()<=11){
				model.setRowCount(11);
				System.out.println("设置最小行数");
			}
		}
		return model;
	}
	
	//根据值去数据库找对应的（用户，报刊，报社）表，将得到的数据封装为字符串打印到文本域中(返回一个字符串数组)
	public StringBuffer getTa_str(String str){
		List<Beans> beans = null;
		StringBuffer taStr = new StringBuffer();
		if(str.equals("用户")){
			beans = new FindDao().findAllUsers();
		}else if(str.equals("报刊")){
			beans = new FindDao().findAllNews();
		}else if(str.equals("报社")){
			beans = new FindDao().findAllPublish();
		}
		
		if(beans == null){	
			taStr = new StringBuffer("没有值。。。");
		}else{
			if(str.equals("用户")){
				for (Beans bean : beans) {
					taStr.append("   账号："+bean.getUserID()+"   用户名："+bean.getUserName()+"   性别："+bean.getSexy()+"   电话："+bean.getPhoneNum()+"\n");
				}
			}else if(str.equals("报刊")){
				for (Beans bean : beans) {
					taStr.append("   报刊号："+bean.getNewsID()+"   报刊名："+bean.getNewsName()+"   报刊单价："+bean.getNewsPrice()+"   报社："+bean.getPublishName()+"\n");
				}
			}else if(str.equals("报社")){
				for (Beans bean : beans) {
					taStr.append("   报社号："+bean.getPublishID()+"   报社名："+bean.getPublishName()+"   地址："+bean.getAddress()+"\n");
				}
			}
		}
		
		
		return taStr;
	}
	
}
