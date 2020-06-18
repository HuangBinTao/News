package managergui;

import gui.ManagerJFA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.SumService;

public class SumJF extends SuperBJF {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public SumJF(){
		setTitle("统计界面");
		reset();
		setVisible(true);//放在最后
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SumJF();
	}

	private void reset() {
		// TODO Auto-generated method stub
		getB().setText("统计功能");
		
		getJcom().addItem("用户");
		getJcom().addItem("报社");
		getJcom().addItem("报刊");
	}
	
	
	@Override
	public void addListener() {
		//为返回按钮添加事件
		super.addListener();
		getBtn_re().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ManagerJFA();
			}
		});
		
		
			//为预览(find)按钮添加事件
			getBtn_find().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//获得下拉选择框的值
					String jcom_str = getJcom().getSelectedItem().toString();
					//根据值去数据库找对应的（用户，报刊，报社）表，将得到的表的model设置到表上
					getTable().setModel(new SumService().getTableModel(jcom_str));
				}
			});
			
			//为打印(skip)按钮添加事件
			getBtn_skip().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//获得下拉选择框的值
					String jcom_str = getJcom().getSelectedItem().toString();
					//根据值去数据库找对应的（用户，报刊，报社）表，将得到的数据封装为字符串打印到文本域中(返回一个字符串数组)
					StringBuffer taStr = new SumService().getTaStr(jcom_str);
					getTa().setText(taStr.toString());
				}
			});
				
	}
}
