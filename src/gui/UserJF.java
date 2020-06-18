package gui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import service.MyGoodsService;
import component.JButtonMe;
import component.JFAction;
import component.JFrameMe;

public class UserJF extends JFrameMe implements JFAction{

	private JTabbedPane tab_pan = new JTabbedPane();
	private String userID;
	private UserResetJF userResetJF;
	private BooksNewsJF booksNewsJF;
	private MyGoodsJF myGoodsJF;
	private JButtonMe btn_tuichu =new JButtonMe("退出");
	public UserJF(){
		//无参的默认为账号为111的用户
		userID = "111";
		init();
		setVisible(true);  //放在最后
	}
	
	public UserJF(String userID){
		//无参的默认为账号为111的用户
		this.userID = userID;
		init();
		setIconImage(new ImageIcon("image//102.png").getImage());
		setVisible(true);  //放在最后
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserJF();
	}

	@Override
	public void init() {
	
		try {
			setTitle("用户操作界面");
			createComponent();
			addComonent();
			setLocate();
			addListener();
			setBack(new ImageIcon("image//用户背景.jpg"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

//	public void load(){
//		myGoodsJF.getTable().setModel(new MyGoodsService().setTableModel(userID));
//	}
	
	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComonent() {
		//	将切换面板添加进来
		con.add(tab_pan);
//		con.add(btn_tuichu);
		
	}

	@Override
	public void setLocate() {
		//设置切换面板的大小
		tab_pan.setSize(500, 500);
		
		// 将面板设置出几个选项
		userResetJF = new UserResetJF(userID);
		booksNewsJF = new BooksNewsJF(userID);
		myGoodsJF = new MyGoodsJF(userID);
//		userResetJF.setUserJF(this);
//		booksNewsJF.setUserJF(this);
//		booksNewsJF.setUserJF(this);
		/**
		 * 添加退出按钮
		 */
		userResetJF.setTuichuButton(this); 
		booksNewsJF.setTuichuButton(this);
		myGoodsJF.setTuichuButton(this);
		tab_pan.addTab("个人信息", userResetJF.getContentPane());
		tab_pan.addTab("订阅报刊", booksNewsJF.getContentPane());
		tab_pan.addTab("查看订单", myGoodsJF.getContentPane());
//		tab_pan.addTab("退出登录", null);
		
		//设置按钮属性
		btn_tuichu.setLocation(400, 0);
		
		//设置切换面板透明
//		tab_pan.setOpaque(false);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
		tab_pan.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				//当切换界面时，就刷新一下我的 订单表
				myGoodsJF.load();
				
			}
		});
	}

}
