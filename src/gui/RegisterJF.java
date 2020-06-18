package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import service.RegisterService;
import component.JButtonMe;
import component.JComboBoxMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabelMe;
import component.JLabel_B;
import component.JTextFiledMe;

public class RegisterJF extends JFrameMe implements JFAction{

	
	private static final long serialVersionUID = 1L;
	
	//创建标签主题标签b,userID, userName, userPassword, sexy, phoneNum
	private JLabel_B b = new JLabel_B("注册界面");
	private JLabelMe b_userID = new JLabelMe("账号:");
	private JLabelMe b_userName = new JLabelMe("用户名:");
	private JLabelMe b_userPassword1 = new JLabelMe("密码:");
	private JLabelMe b_userPassword2 = new JLabelMe("确认密码:");
	private JLabelMe b_sexy = new JLabelMe("性别:");
	private JLabelMe b_phoneNum = new JLabelMe("电话号码:");
	
	//创建输入框和下拉性别的选择框
	private JTextFiledMe t_userID = new JTextFiledMe();
	private JTextFiledMe t_userName = new JTextFiledMe();
	private JPasswordFieldMe t_userPassword1 = new JPasswordFieldMe();
	private JPasswordFieldMe t_userPassword2 = new JPasswordFieldMe();
	private JComboBoxMe jcom_sexy = new JComboBoxMe(new String[]{
			"男", "女"
	});
	private JTextFiledMe t_phoneNum = new JTextFiledMe();
	//创建按钮（注册， 返回）
	private JButtonMe btn_register = new JButtonMe("注册");
	private JButtonMe btn_return = new JButtonMe("返回");
	
	
	
	//创建中间面板的三个面板，并且设置位置和大小
//	private JPaneBlue pan_center_top = new JPaneBlue();
//	private JPaneBlue pan_center_center = new JPaneBlue();
//	private JPaneBlue pan_center_buttom = new JPaneBlue();
	
	public RegisterJF(){
		
		init();
		setIconImage(new ImageIcon("image//102.png").getImage());
		setVisible(true);//放在最后
	}
	
	public static void main(String[] args) {
		
//		 new JFramText();  //坐标窗体
		 new RegisterJF();
	}

	@Override
	public void init() {
		
		try {
			setTitle("注册界面");
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

	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComonent() {
			//将五个面板加入到内容面板中
//			con.add(pan_center, BorderLayout.CENTER);
//			con.add(pan_west, BorderLayout.WEST);
//			con.add(pan_east, BorderLayout.EAST);
//			con.add(pan_north, BorderLayout.NORTH);
//			con.add(pan_south, BorderLayout.SOUTH);
			
			//将三个蓝色面板加到中间面板
//			pan_center.add(pan_center_top);
//			pan_center.add(pan_center_center);
//			pan_center.add(pan_center_buttom);
		
		//将标签加进面板
		con.add(b);
		con.add(b_userID);
		con.add(b_userName);
		con.add(b_userPassword1);
		con.add(b_userPassword2);
		con.add(b_sexy);
		con.add(b_phoneNum);
		
		//将输入框和下拉选择框加入面板
		con.add(t_userID);
		con.add(t_userName);
		con.add(t_userPassword1);
		con.add(t_userPassword2);
		con.add(jcom_sexy);
		con.add(t_phoneNum);
		
		//将按钮加入到面板中
		con.add(btn_register);
		con.add(btn_return);
		
		
	}

	@Override
	public void setLocate() {
		int x = 0, y = 0; //位置的控制
		
		//设置标签的位置
		b.setLocation(x+150, y+10);
		b_userID.setLocation(x+110, y+70);
		b_userName.setLocation(x+110, y+110);
		b_userPassword1.setLocation(x+110, y+150);
		b_userPassword2.setLocation(x+110, y+190);
		b_sexy.setLocation(x+110, y+230);
		b_phoneNum.setLocation(x+110, y+270);
		
		//设置输入框和下拉选择框的位置
		t_userID.setLocation(210, y+70);
		t_userID.setLocation(x+210, y+70);
		t_userName.setLocation(x+210, y+110);
		t_userPassword1.setLocation(x+210, y+150);
		t_userPassword2.setLocation(x+210, y+190);
		jcom_sexy.setLocation(x+210, y+230);
		t_phoneNum.setLocation(x+210, y+270);
		
		
		//设置按钮的位置
		btn_register.setLocation(x+130, y+330);
		btn_return.setLocation(x+250, y+330);
	}

	@Override
	public void addListener() {
		//返回按钮事件
		btn_return.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginJF("用户");
				
			}
		});
		
		//注册按钮事件
		btn_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(t_userID.getText().length() == 0 || t_userName.getText().length() == 0 || t_userPassword1.getPassword().length == 0||t_userPassword2.getPassword().length==0||t_phoneNum.getText().length() == 0 ){
					JOptionPane.showMessageDialog(null, "请输入完整信息","提示框", JOptionPane.ERROR_MESSAGE);
//					
				}else{
					//得到输入框的值
					String userID = t_userID.getText();
					String userName = t_userName.getText();
					String userPassword1 = new String(t_userPassword1.getPassword());
					String userPassword2 = new String(t_userPassword2.getPassword());
					String sexy = jcom_sexy.getSelectedItem().toString();
					String phoneNum = t_phoneNum.getText();
					
					
					int i = new RegisterService().register(userID, userName, userPassword1,userPassword2,sexy,phoneNum);
					switch(i){
					case 3:JOptionPane.showMessageDialog(null, "已经存在该账号", "提示框", JOptionPane.ERROR_MESSAGE);
					break;
					case 2:JOptionPane.showMessageDialog(null, "两次密码输入不一致","提示框", JOptionPane.ERROR_MESSAGE);
					break;
					case 1:new LoginJF("用户");
					dispose();
					JOptionPane.showMessageDialog(null, "注册成功", "提示框", JOptionPane.PLAIN_MESSAGE);
					break;
					default :JOptionPane.showMessageDialog(null, "未知错误", "提示框", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
			}
		});
		
		
	}

}
