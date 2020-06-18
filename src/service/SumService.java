package service;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import mybean.Beans;
import dao.SumDao;

public class SumService {

	//根据值去数据库找对应的（用户，报刊，报社）表，将得到的表的model设置到表上
	public DefaultTableModel getTableModel(String str){
		
		
		List<Beans> beans = null;
		DefaultTableModel model = new DefaultTableModel();
		if(str.equals("用户")){
			beans = new SumDao().findUsersSum();
		}else if(str.equals("报刊")){
			beans = new SumDao().findNewsSum();
		}else if(str.equals("报社")){
			beans = new SumDao().findPublishSum();
		}
		
		
		if(beans.size() == 0){
			String[] name = new String[]{
					"属性1", "属性2", "属性3", "属性4"
			};
			model = new DefaultTableModel(name, 11);
		}else{
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			for (Beans bean : beans) {
				Vector<String> row = new Vector<String>();
				if(str.equals("用户")){
					row.add(bean.getUserID());
					row.add(bean.getUserName());
					row.add(bean.getBuyNum());
					row.add(bean.getSumPrice());
					data.add(row);
				}else if(str.equals("报刊")){
					row.add(bean.getNewsID());
					row.add(bean.getNewsName());
					row.add(bean.getSellNum());
					row.add(bean.getSumPrice());
					data.add(row);
				}else if(str.equals("报社")){
					row.add(bean.getPublishID());
					row.add(bean.getPublishName());
					row.add(bean.getSellNum());
					row.add(bean.getSumPrice());
					data.add(row);
				}
			}
			Vector<String> name = new Vector<String>();
			if(str.equals("用户")){
				name.add("账号");
				name.add("用户名");
				name.add("订阅份数");
				name.add("总价");
			}else if(str.equals("报刊")){
				name.add("报刊号");
				name.add("报刊名");
				name.add("销售总数");
				name.add("总售价");
			}else if(str.equals("报社")){
				name.add("报社号");
				name.add("报社名");
				name.add("销售份数");
				name.add("销售总价");
			}
			model.setDataVector(data, name);
			if(beans.size() <= 11){
				model.setRowCount(11);
			}
		}
		
		
		return model;
		
	}

	public StringBuffer getTaStr(String jcom_str) {
		// TODO Auto-generated method stub
		List<Beans> beans = null;
		StringBuffer taStr = new StringBuffer();
		if(jcom_str.equals("用户")){
			beans = new SumDao().findUsersSum();
		}else if(jcom_str.equals("报刊")){
			beans = new SumDao().findNewsSum();
		}else if(jcom_str.equals("报社")){
			beans = new SumDao().findPublishSum();
		}
		
		if(beans == null){	
			taStr = new StringBuffer("没有值。。。");
		}else{
			if(jcom_str.equals("用户")){
				for (Beans bean : beans) {
					taStr.append("   账号："+bean.getUserID()+"   用户名："+bean.getUserName()+"   订阅份数："+bean.getBuyNum()+"   总价："+bean.getSumPrice()+"\n");
				}
			}else if(jcom_str.equals("报刊")){
				for (Beans bean : beans) {
					taStr.append("   报刊号："+bean.getNewsID()+"   报刊名："+bean.getNewsName()+"   销售份数："+bean.getSellNum()+"   总售价："+bean.getSumPrice()+"\n");
				}
			}else if(jcom_str.equals("报社")){
				for (Beans bean : beans) {
					taStr.append("   报社号："+bean.getPublishID()+"   报社名："+bean.getPublishName()+"   销售数："+bean.getSellNum()+"   总售价："+bean.getSumPrice()+"\n");
				}
			}
		}
		
		
		return taStr;
	}
	
	
	//根据值去数据库找对应的（用户，报刊，报社）表，将得到的数据封装为字符串打印到文本域中
	
	
	
	
	
}
