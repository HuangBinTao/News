package managergui;

import gui.ManagerJFA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import mybean.Beans;
import service.InputNewsService;
import component.JFAction;
import component.JLabelMe;
import component.JTextFiledMe;

public class InputNewsJF extends SuperAJF {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabelMe b_newsPrice;
	JTextFiledMe t_newsPrice;
	
	public InputNewsJF(){
		
		resetB();
//		load();
//		addListener();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InputNewsJF();
	}
	
	
	//修改标签,设置t_adress为隐藏
	public void resetB(){
		//修改标签， 主标签， ID标签， name标签， last标签
		getB().setText("录入报刊");
		getB_ID().setText("报刊号:");
		getB_name().setText("报刊名:");
		getB_last().setText("报社:");
		
		//创建一个报刊价格标签,输入框
		b_newsPrice = new JLabelMe("报刊单价");
		t_newsPrice = new JTextFiledMe();
		con.add(b_newsPrice);
		con.add(t_newsPrice);
		/**
		 * 设置新加的组件的位置
		 */
		setLocateA();
		
		//隐藏输入框t_address
		getJcom_publis().setSize(getT_address().getSize());
		getT_address().setSize(0, 0);
	}
	
	@Override
	//加载报社下拉选择框
	public void load(){
		
		List<Beans> beans = new InputNewsService().getPublishInfo();
		if(beans != null){
			for (Beans bean : beans) {System.out.println(bean.getPublishName());
				getJcom_publis().addItem(bean.getPublishName());
			}
		}
	}
	
	
	public void setLocateA() {
		getBtn_input().setLocation(getXs()+130, getYs()+280);
		getBtn_re().setLocation(getXs()+250, getYs()+280);
		
		b_newsPrice.setLocation(getXs()+100, getYs()+230);
		t_newsPrice.setLocation(getXs()+200, getYs()+230);
		
	};
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		super.addListener();
		
		//返回按钮事件
		getBtn_re().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ManagerJFA();
			}
		});
		
		//录入按钮事件
		getBtn_input().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取三个输入框的值
				//若输入框为空，则返回  2
				//若已经存在该报刊号，则返回  3
				//若与已有报刊名字相同则返回4
				//若单价输入不符则返回5
				//若录入成功则返回  1
				//若都不是则未知错误
				
				String newsID = getT_ID().getText();
				String newsName = getT_name().getText();
				String publishName = getJcom_publis().getSelectedItem().toString();
				String newsPrice = t_newsPrice.getText();
				int i = 8;
				i = new InputNewsService().inputNews(newsID, newsName, newsPrice, publishName);
				switch(i) {
				case 5:JOptionPane.showMessageDialog(null, "报刊单价输入错误", "提示框", JOptionPane.ERROR_MESSAGE);
				break;
				case 2:JOptionPane.showMessageDialog(null, "输入不能为空", "提示框", JOptionPane.ERROR_MESSAGE);
					break;
				case 3:JOptionPane.showMessageDialog(null, "已经存在该报刊号", "提示框", JOptionPane.ERROR_MESSAGE);
					break;
				case 4:JOptionPane.showMessageDialog(null, "报刊名已存在", "提示框", JOptionPane.ERROR_MESSAGE);
					break;
				case 1:JOptionPane.showMessageDialog(null, "录入成功", "提示框", JOptionPane.PLAIN_MESSAGE);
					break;
				default :JOptionPane.showMessageDialog(null, "未知错误", "提示框", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		
	}
	

}
