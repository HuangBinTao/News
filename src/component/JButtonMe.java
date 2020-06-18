package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class JButtonMe extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButtonMe(){
		setSize(100, 35);
//		setFont(new Font("华文彩云", Font.PLAIN, 15));
		setFont(new Font("华文细黑", Font.BOLD, 15));
//		setForeground(Color.RED);
	}
	public JButtonMe(String name){
		super(name);
		setSize(100, 35);
//		setFont(new Font("华文彩云", Font.PLAIN, 17));
		setFont(new Font("华文细黑", Font.BOLD, 17));
//		setForeground(Color.RED);
	}
}
