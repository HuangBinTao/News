package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import service.LoginService;
import text.JFramText;
import component.JButtonMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabelMe;
import component.JLabel_B;
import component.JTextFiledMe;

public class LoginJF extends JFrameMe implements JFAction{

	public JLabel_B b = new JLabel_B("登录界面");//主题标签
	public JLabelMe b_zh = new JLabelMe("账号:");
	public JLabelMe b_pass = new JLabelMe("密码:");
	public JTextFiledMe t_zh = new JTextFiledMe();
	public JPasswordField t_pass = new JPasswordField();
	public JButtonMe btn_login = new JButtonMe("登录");
	public JButtonMe btn_register = new JButtonMe("注册");
	public JButtonMe btn_return = new JButtonMe("◎");
	public String name;
	
	public LoginJF(String name){
		this.name = name;
		Dimension dim;
		init();
		if(name.equals("管理员")){
			ImageIcon icon = new ImageIcon("image//103.png");
			setIconImage(icon.getImage());
			dim = setBack(new ImageIcon("image//管理员.1.jpg"));
			b.setText("");
		}else{
			ImageIcon icon = new ImageIcon("image//102.png");
			setIconImage(icon.getImage());
			dim = setBack(new ImageIcon("image//用户登录2.1.jpg"));
//			b.setSize(200, 100);
			b.setText("用户登录");
			b.setForeground(Color.BLACK);
		}
		
		
		
		
		
		setSize(dim.width, dim.height);
		setLocationRelativeTo(null);
		setVisible(true);//放在最后
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new JFramText();     //坐标窗体
//		LoginJF jf = new LoginJF("自己");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			
			if(name.equals("管理员")){
				t_zh.setText("111");
			}
			
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
		con.add(b_zh);
		con.add(b_pass);
		con.add(t_zh);
		con.add(t_pass);
		con.add(btn_login);
		con.add(btn_register);
		con.add(btn_return);
		
	}

	@Override
	public void setLocate() {
//		int x = -50, y = -50;  //位置的控制
		
		int x = 400, y = 0;
		if(name.equals("用户")){
			x=410;y=70;
			b_zh.setText("");
//			b.setLocation(x, y);
			b_pass.setText("");
		}
		b.setLocation(x+170, y+90);
		b_zh.setLocation(x+110, y+160);
		b_pass.setLocation(x+110, y+200);
		t_zh.setLocation(x+170, y+160);
		t_pass.setLocation(x+170, y+200);
		t_zh.setSize(180, 35);
		t_pass.setSize(180, 35);
		btn_login.setLocation(x+170, y+250);
		btn_login.setSize(180, 35);
		btn_login.setBackground(Color.BLUE);
		btn_register.setLocation(x+225, y+250);
		btn_return.setBounds(x+360, y+250, 50, 35);
		
		btn_login.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
		btn_login.setLocation(x+170, y+250);
		
		if(name.equals("管理员")){
			btn_register.setSize(0, 0);
//			btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
			
		}else if(name.equals("用户")){
			
			t_zh.setSize(150, 28);
			t_pass.setSize(150, 28);
			btn_login.setSize(150, 35);
			t_pass.setLocation(x+170, y+207);
			btn_return.setBounds(x+470, y-60, 50, 35);
			btn_register.setBounds(x+460, y+380, 60, 35);
		}
		
		
		
		
	}

	@Override
	public void addListener() {
		// 返回按钮事件
		btn_return.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new LoginSelectJF();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		//注册按钮事件
		btn_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterJF();
				
			}
		});
		
		//为登录按钮添加事件
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				if(name.equals("自己")){
//					dispose();
//					new UserJF("111");
//				}else 
					if(name.equals("用户")){
					
					//判断输入框是否为空
					if(t_zh.getText().length() == 0 || t_pass.getPassword().length == 0){
						JOptionPane.showMessageDialog(null, "请输入用户名和密码","提示框", JOptionPane.ERROR_MESSAGE);
						
					}else{
						
						//得到账号和密码
						String userID = t_zh.getText();
						String userPassword = new String(t_pass.getPassword());
						
						int i = 0;
						try {
							i = new LoginService().login(userID, userPassword);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						switch(i){
						case 3:JOptionPane.showMessageDialog(null, "账号或密码错误", "提示框", JOptionPane.ERROR_MESSAGE);
						break;
						case 1:
						JOptionPane.showMessageDialog(null, "登录成功", "提示框", JOptionPane.PLAIN_MESSAGE);
						dispose();
						new UserJF(t_zh.getText());
						
						break;
						default :JOptionPane.showMessageDialog(null, "未知错误", "提示框", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
					
				}else if(name.equals("管理员")){
					//设置管理员账号和密码
					//若输入为空则提示
					//不为空则显示账号或密码错误
					String zh = t_zh.getText();
					String passstr = new String(t_pass.getPassword());
					if(zh.length() == 0 || passstr.length() == 0){
						JOptionPane.showMessageDialog(null, "请输入账号和密码", "提示框", JOptionPane.ERROR_MESSAGE);
					}else if(zh.equals("111")&&passstr.equals("111")){
						JOptionPane.showMessageDialog(null, "登录成功", "提示框", JOptionPane.PLAIN_MESSAGE);
						dispose();
						new ManagerJFA();
					}else {
						JOptionPane.showMessageDialog(null, "账号或密码错误", "提示框", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				}
				
			}
		});
		
		
	}

}
