package service;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import mybean.Beans;
import dao.MyGoodsDao;

public class MyGoodsService {

	public DefaultTableModel setTableModel(String userID) {
		
		//去数据库查找Goods表，结合news表,查找出报刊名，购买数量， 报刊单价，报刊总价 
		List<Beans> beans = new MyGoodsDao().getMyGoodsList(userID);
		DefaultTableModel model = new DefaultTableModel();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> name = new Vector<String>();
		name.add("报刊名");
		name.add("订阅份数");
		name.add("报刊单价");
		name.add("总价");
		
		if(beans.size()==0){
			model.setDataVector(data, name);
			model.setRowCount(17);
			
		}else{
			
			for (Beans bean : beans) {
				Vector<String> row = new Vector<String>();
				row.add(bean.getNewsName());
				row.add(bean.getBuyNum());
				row.add(bean.getNewsPrice());
				row.add(bean.getSumPrice());
				data.add(row);
				model.setDataVector(data, name);
				System.out.println("查找到订单表并且建立表格的模型"+bean.getNewsName());
			}
			
			if(beans.size() <= 17){
				model.setRowCount(17);
			}
		}
		
		return model;
		
	}

}
