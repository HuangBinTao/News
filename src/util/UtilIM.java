package util;

import gui.LoginJF;
import gui.UserJF;
import gui.UserResetJF;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import service.BooksNewsService;
import service.UserResetService;
import mybean.Beans;
import component.JButtonMe;
import component.JComboBoxMe;
import component.JDialogMe;
import component.JFrameMe;
import component.JLabelMe;
import component.JTextFiledMe;


public class UtilIM implements GetConponet {

	@Override
	public JButtonMe getTuichuButton(UserJF userJF) {
		// TODO Auto-generated method stub
		JButtonMe btn = new JButtonMe();
		btn.setLocation(430, 2);
		btn.setSize(50, 30);
		btn.setText("◎");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				userJF.dispose();
				new LoginJF("用户");
				
			}
		});
		return btn;
	}

	/**
	 * 弹出订阅报刊的界面（报刊号和要订阅的数量）
	 * @return 
	 */
	@Override
	public JFrameMe out_jf(String userID) {
		
		int x = 0, y = 0;
		
		// TODO Auto-generated method stub
		JFrameMe jf = new JFrameMe();

		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
//		jf.setFocusable(true);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//创建标签
		JLabelMe b_newsID = new JLabelMe("报刊号");
		JLabelMe b_buyNum = new JLabelMe("订阅数量");
		b_newsID.setLocation(x+30, y+10);
		b_buyNum.setLocation(x+30, y+50);
		jf.con.add(b_newsID);
		jf.con.add(b_buyNum);
		//创建输入框
		JTextFiledMe t_newsID = new JTextFiledMe();
		JTextFiledMe t_buyNum = new JTextFiledMe();
		t_newsID.setLocation(x+110, y+10);
		t_buyNum.setLocation(x+110, y+50);
		jf.con.add(t_newsID);
		jf.con.add(t_buyNum);
		//创建按钮
		JButtonMe btn_return = new JButtonMe("返回");
		JButtonMe btn_book = new JButtonMe("订阅");
		btn_book.setLocation(x+80, y+100);
		btn_return.setLocation(x+130, y+100);
		jf.con.add(btn_book);
//		jf.con.add(btn_return);
		
		
		//添加订阅按钮的事件
		btn_book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 5;
				// 获得报刊号，获得订阅数，录入数据库
				String newsID = t_newsID.getText();
				String buyNums =  t_buyNum.getText();
				int buyNum = 0;
				
				
				//如果输入框没有写东西，则提示   
				if(newsID.length() == 0|| buyNums.length() == 0){
					JOptionPane.showMessageDialog(null, "请输入完整信息", "提示框", JOptionPane.ERROR_MESSAGE);
					
				}else{
					//订阅数量和订阅输入字符问题
					try{
						buyNum = Integer.parseInt(t_buyNum.getText());
						if(buyNum <= 0 ){
							JOptionPane.showMessageDialog(null, "订阅的数量要大于0", "提示框", JOptionPane.ERROR_MESSAGE);
						return;
						}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "订阅数请输入数字", "提示框", JOptionPane.ERROR_MESSAGE);
					return;
					}
					//执行数据库的操作Service
					
					i = new BooksNewsService().booksnews(userID, newsID, buyNum);
					//若不存在该报刊号则错误  0
					if(i == 5){
						JOptionPane.showMessageDialog(null, "订阅失败，不存在该报刊", "提示框", JOptionPane.ERROR_MESSAGE);
					}else if(i == 1){
						//订阅成功  1
						//若存在该报刊，则判断是否已经订阅过，若订阅过则更新数量，否则插入信息
						JOptionPane.showMessageDialog(null, "订阅成功", "提示框", JOptionPane.PLAIN_MESSAGE);
						jf.dispose();
					}else if(i == 0){
						JOptionPane.showMessageDialog(null, "未知错误", "提示框", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				}
				
				
				
			}
		});
		
		
		return jf;
	}

	
	/**
	 * 弹出修改个人信息的框
	 * @return 
	 */
	@Override
	public JFrameMe out_resetJF(String userID) {
		
		
		// TODO Auto-generated method stub
		UserResetJF userResetJF = new UserResetJF(userID);
		
		//设置输入框可编辑
//		userResetJF.getT_userID().setEditable(true);
		userResetJF.getT_userName().setEditable(true);
//		userResetJF.getT_sexy().setEditable(true);
		userResetJF.getT_phoneNum().setEditable(true);
		
		
		userResetJF.setX_(-80);
		userResetJF.setY_(-30);
		userResetJF.setLocate();
		userResetJF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//将标签该一下，改为修改信息
		userResetJF.getB().setText("修改信息");
		
		userResetJF.getB().setLocation((int)userResetJF.getB().getLocation().getX(),(int)userResetJF.getB().getLocation().getY()+50);
		//将账号标签和账号输入框和性别框设置为0大小
		userResetJF.getB_userID().setSize(0, 0);
		userResetJF.getT_userID().setSize(0, 0);
		userResetJF.getT_sexy().setSize(0, 0);
		//调整整个框的大小
		userResetJF.setSize(330, 330);
		//调位置
		userResetJF.setLocationRelativeTo(null);
		//将所有输入框设置为可编辑
		userResetJF.getT_userName().setEnabled(true);
		userResetJF.getT_sexy().setEnabled(true);
		userResetJF.getT_phoneNum().setEnabled(true);
		
		//设置背景
		userResetJF.setBack(new ImageIcon("image//2.jpg"));
		
		//创建下拉选择框，添加到面板，得到性别的位置和大小，设置位置和大小,并且设置字体
		JComboBoxMe jcom_sexy = new JComboBoxMe(new String[]{
				"男", "女"
		});
		userResetJF.con.add(jcom_sexy);
		jcom_sexy.setLocation(userResetJF.getT_sexy().getLocation());
		jcom_sexy.setFont(new Font("宋体", Font.BOLD, 14));
		
		//为修改按钮添加监听
		userResetJF.getBtn_reset().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//判断用户名和电话是否为空
				String userName = userResetJF.getT_userName().getText();
				String sexy = jcom_sexy.getSelectedItem().toString();
				String phoneNum = userResetJF.getT_phoneNum().getText();
				if(userResetJF.getT_userName().getText().length() == 0 || userResetJF.getT_phoneNum().getText().length()==0){
					JOptionPane.showMessageDialog(null, "请输入完整信息", "提示框", JOptionPane.ERROR_MESSAGE);
				}else {
					int i = new UserResetService().resetUserInfo(userID, userName, sexy, phoneNum);
					
					switch(i){
					case 1:JOptionPane.showMessageDialog(null, "修改成功", "提示框", JOptionPane.PLAIN_MESSAGE);
					userResetJF.dispose();
					break;
					default :JOptionPane.showMessageDialog(null, "未知错误", "提示框", JOptionPane.ERROR_MESSAGE);
					
					}
				}
				
				
				
			}
		});
		
		
		/**
		 * 加载数据
		 */
		
		Beans bean = new UserResetService().getUserInfoByUserID(userID);
		userResetJF.getT_userName().setText(bean.getUserName());
		jcom_sexy.setSelectedItem((bean.getSexy()));
		userResetJF.getT_phoneNum().setText(bean.getPhoneNum());
		
		
		//为窗体添加关闭窗体的监听
		
		//设置可见,放在最后
		userResetJF.setVisible(true);
		
		
		
		
		
		return userResetJF;
		
	}
	
	

	

}
