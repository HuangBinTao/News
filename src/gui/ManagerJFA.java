package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import managergui.FindJF;
import managergui.InputNewsJF;
import managergui.InputPublishJF;
import managergui.SumJF;
import component.JButtonMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabel_B;

public class ManagerJFA extends JFrameMe implements JFAction,ActionListener {

	//创建五个按钮，录入报刊，录入报社，查询，统计，退出
	private JButtonMe btn_input_publish = new JButtonMe("录入报社");
	private JButtonMe btn_input_news = new JButtonMe("录入报刊");
	private JButtonMe btn_find = new JButtonMe("查询功能");
	private JButtonMe btn_sum = new JButtonMe("统计功能");
	private JButtonMe btn_re = new JButtonMe("退出");
	//创建一个主标签，管理员操作界面
	private JLabel_B b = new JLabel_B("管理员操作界面");
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public ManagerJFA() {
		
		
		init();
		setBack(new ImageIcon("image//背景.jpg"));
		setIconImage(new ImageIcon("image//103.png").getImage());
		setVisible(true);//放在最后
	}
	
	
	@Override
	public void init() {
		
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

	}

	@Override
	public void addComonent() {
		con.add(b);
		con.add(btn_input_news);
		con.add(btn_input_publish);
		con.add(btn_find);
		con.add(btn_sum);
		con.add(btn_re);

	}

	@Override
	public void setLocate() {
		// TODO Auto-generated method stub
		b.setLocation(xs+120, ys+20);
		btn_input_news.setLocation(xs+120, ys+80);
		btn_input_publish.setLocation(xs+120, ys+150);
		btn_find.setLocation(xs+120, ys+220);
		btn_sum.setLocation(xs+120, ys+290);
		btn_re.setLocation(xs+120, ys+360);
		
		
		//重新设置按钮大小
		btn_input_news.setSize(250, 60);
		btn_input_publish.setSize(250, 60);
		btn_find.setSize(250, 60);
		btn_sum.setSize(250, 60);
		btn_re.setSize(250, 60);
		
	}

	@Override
	public void addListener() {
		//退出按钮事件
		btn_re.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginJF("管理员");
				
			}
		});
		
		//录入报刊按钮事件
		btn_input_news.addActionListener(this);
		//录入报社按钮事件
		btn_input_publish.addActionListener(this);
		//查询功能按钮事件
		btn_find.addActionListener(this);
		//统计功能按钮事件
		btn_sum.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		
		new ManagerJFA();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_input_news){
			dispose();
			new InputNewsJF();
		}else if(e.getSource() == btn_input_publish){
			dispose();
			new InputPublishJF();
		}else if(e.getSource() == btn_find){
			dispose();
			new FindJF();
		}else if(e.getSource() == btn_sum){
			dispose();
			new SumJF();
		}
		
	}

}
