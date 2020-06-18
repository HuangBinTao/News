package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class JComboBoxMe extends JComboBox<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JComboBoxMe(){
		setSize(100, 35);
//		setFont(new Font("华文仿宋", Font.BOLD, 17));
		setFont(new Font("华文细黑", Font.BOLD, 17));
//		setForeground(Color.RED);
		
		//待删除项
//		setLocation(100, 100);
	}
	
	public JComboBoxMe(String[] name){
		super(name);
		setSize(100, 35);
//		setFont(new Font("华文仿宋", Font.BOLD, 17));
		setFont(new Font("华文细黑", Font.BOLD, 17));
//		setForeground(Color.RED);
		//待删除项
		setLocation(100, 100);
	}
}
