package gui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import component.JFAction;
import component.JFrameMe;

public class ManagerJF extends JFrameMe implements JFAction {

	//创建一个切换面板
	JTabbedPane tab_pan = new JTabbedPane();
	//创建一个
	
	public ManagerJF(){
		init();
		setBack(new ImageIcon("image//2.jpg"));
		setTitle("管理员操作界面");
		setIconImage(new ImageIcon("image//103.png").getImage());
		setVisible(true);//放在最后
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManagerJF();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			createComponent();
			addComonent();
			setLocate();
			addListener();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		tab_pan.add("录入报刊",null);
		tab_pan.add("录入报社",null);
		tab_pan.add("查询功能",null);
		tab_pan.add("统计功能",null);
	}

	@Override
	public void addComonent() {
		// TODO Auto-generated method stub
		con.add(tab_pan);
	}

	@Override
	public void setLocate() {
		// TODO Auto-generated method stub
		tab_pan.setBounds(0, 0, 500, 500);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub

	}

	

}
