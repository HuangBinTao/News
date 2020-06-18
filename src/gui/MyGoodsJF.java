package gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import service.MyGoodsService;
import util.UtilIM;
import component.JButtonMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabel_B;

public class MyGoodsJF extends JFrameMe implements JFAction{

	/**
	 * 
	 */
	
	private JLabel_B b = new JLabel_B("我的订单");
	
	private String userID;
	
	private JTable table = new JTable();
	
	private JScrollPane jsc = new JScrollPane(table);
	
	private JButtonMe btn_find = new JButtonMe("查询");
	
	
	private static final long serialVersionUID = 1L;

	public MyGoodsJF(){
		init();
		setBack(new ImageIcon("image//3.jpg"));
		setVisible(true);  //放在最后，最后删除
	}
	
	public MyGoodsJF(String userID){
		this.userID = userID;
		init();
		setBack(new ImageIcon("image//3.jpg"));
		setIconImage(new ImageIcon("image//102.png").getImage());
//		con.setOpaque(true);
//		setVisible(true);  //放在最后，最后删除
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyGoodsJF();
	}

	public void load(){
		//去数据库查找Goods表，结合news表,users表，查找出报刊名，购买数量， 报刊单价，报刊总价 
		
		//当点击切换面板切换时，监听使用该对象调用load方法
		table.setModel(new MyGoodsService().setTableModel(userID));
	}
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		try {
			createComponent();
			addComonent();
			setLocate();
			addListener();
			load();
//			con.setOpaque(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComonent() {
		// TODO Auto-generated method stub
		con.add(b);
		con.add(getJsc());
		con.add(btn_find);
		
	}

	@Override
	public void setLocate() {
		// TODO Auto-generated method stub
		b.setLocation(150, 10);
//		b.setForeground(Color.black);
//		b.setFont(new Font("华文新魏", Font.BOLD, 35));
		// 设置放表格的jsc的属性
		getJsc().setSize(400, 300);
		getJsc().setLocation(40, 70);
		//设置按钮的大小
		btn_find.setLocation(190, 380);
		
	}

	public void setTuichuButton(UserJF userJF){
		//添加退出按钮
		con.add(new UtilIM().getTuichuButton(userJF));
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getJsc() {
		return jsc;
	}

	public void setJsc(JScrollPane jsc) {
		this.jsc = jsc;
	}

}
