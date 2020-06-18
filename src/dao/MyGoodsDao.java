package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import mybean.Beans;



public class MyGoodsDao extends Dao{

	@SuppressWarnings("deprecation")
	public List<Beans> getMyGoodsList(String userID) {
		//去数据库查找Goods表，结合news表，查找出报刊名，购买数量， 报刊单价，报刊总价 
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select * , buyNum*newsPrice as sumPrice from Goods, News where Goods.newsID = News.newsID and userID = ?";
		
		try {
			return qr.query(sql, userID, new BeanListHandler<>(Beans.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
