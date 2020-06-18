package service;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import mybean.Beans;
import dao.BooksNewsDao;

public class BooksNewsService {

	//订阅成功  1
	//若存在该报刊，则判断是否已经订阅过，若订阅过则更新数量，否则插入信息
	public int booksnews(String userID, String newsID, int buyNum){
		
		int i = 5;
		
		if(!hasNewsID(newsID)){
			return 5;
		}
		
		if(new BooksNewsDao().has_goods_in_GoodsTable(userID, newsID)){
			//更新
			i = new BooksNewsDao().updateGoods(userID, newsID, buyNum);
		}else{
			//插入
			i = new BooksNewsDao().insertGoods(userID, newsID, buyNum);
		}
		
		return i;
	}

	private boolean hasNewsID(String newsID) {
		// 是否存在该报刊号
		
		return new BooksNewsDao().hasNewsID(newsID);
	}

	public TableModel getTableModel() {
		// 得到报刊的信息
		List<Beans> beans = null;
		beans = new BooksNewsDao().getNewsInfo();
		DefaultTableModel model = new DefaultTableModel();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> name = new Vector<String>();
		name.add("报刊号");
		name.add("报刊名");
		name.add("报刊单价");
		name.add("报社名");
		if(beans.size()>0){
			for (Beans bean : beans) {
				Vector<String> row = new Vector<String>();
				row.add(bean.getNewsID());
				row.add(bean.getNewsName());
				row.add(bean.getNewsPrice());
				row.add(bean.getPublishName());
				data.add(row);
			}
			model.setDataVector(data, name);
			if(beans.size() <= 17){
				model.setRowCount(17);
			}
		}else{
			model.setDataVector(data, name);
			model.setRowCount(17);
		}
		return model;
	}
	
	
}
