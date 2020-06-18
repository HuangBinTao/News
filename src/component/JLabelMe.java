package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelMe extends JLabel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabelMe(){
		setSize(100, 35);
//		setFont(new Font("华文新魏", Font.PLAIN, 20));
		setFont(new Font("华文细黑", Font.BOLD, 20));
//		setForeground(Color.RED);
		
		//待删除项
//		setLocation(100, 100);
	}
	
	public  JLabelMe(String name){
		
		super(name);
		setSize(100, 35);
//		setFont(new Font("华文新魏", Font.PLAIN, 20));
		setFont(new Font("华文细黑", Font.BOLD, 20));
//		setForeground(Color.RED);
		
		
		//待删除项
		setLocation(100, 100);
		
		
	}
	
}
