package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabel_B extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel_B(){
		setSize(350, 50);
		setFont(new Font("华文新魏", Font.BOLD, 35));
		setForeground(Color.WHITE);
		
		//待删除项
		setLocation(100, 100);
	}
	
	public  JLabel_B(String name){
		
		super(name);
		setSize(350, 50);
//		setFont(new Font("华文新魏", Font.BOLD, 35));
		setFont(new Font("华文细黑", Font.BOLD, 35));
		setForeground(Color.WHITE);
		
		
		//待删除项
		setLocation(100, 100);
		
		
	}
}
