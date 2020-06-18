package managergui;

import gui.ManagerJFA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import service.InputPublishService;

public class InputPublishJF extends SuperAJF {

	public InputPublishJF(){
		reset();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InputPublishJF();
	}
	
	
	public void reset(){
		//修改标签， 主标签， ID标签， name标签， last标签
		getB().setText("录入报社");
		getB_ID().setText("报社号:");
		getB_name().setText("报社名:");
		getB_last().setText("报社地址:");
		
		//隐藏输入框jcom_publish
		getJcom_publis().setSize(0, 0);
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		super.addListener();
		getBtn_re().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ManagerJFA();
			}
		});
		
		
		getBtn_input().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//若输入框为空，则返回  2
				//若已经存在该报社号，则返回  3
				//若与已有报社名字相同则返回4
				//若录入成功则返回  1
				//若都不是则未知错误
				
				String publishID = getT_ID().getText();
				String publishName = getT_name().getText();
				String address = getT_address().getText();
				
				int i = new InputPublishService().inputPublish(publishID, publishName, address);
				switch(i) {
				case 2:JOptionPane.showMessageDialog(null, "输入不能为空", "提示框", JOptionPane.ERROR_MESSAGE);
					break;
				case 3:JOptionPane.showMessageDialog(null, "已经存在该报社号", "提示框", JOptionPane.ERROR_MESSAGE);
					break;
				case 4:JOptionPane.showMessageDialog(null, "报社名已存在", "提示框", JOptionPane.ERROR_MESSAGE);
					break;
				case 1:JOptionPane.showMessageDialog(null, "录入成功", "提示框", JOptionPane.PLAIN_MESSAGE);
					break;
				default :JOptionPane.showMessageDialog(null, "未知错误", "提示框", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}

}
