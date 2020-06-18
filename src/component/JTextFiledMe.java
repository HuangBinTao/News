package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class JTextFiledMe extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextFiledMe(){
		setSize(150, 35);
		setFont(new Font("华文新魏", Font.PLAIN, 17));
//		setBorder(new LineBorder(Color.black, 1, true));
	}
	public JTextFiledMe(String text){
		super(text);
		setSize(150, 35);
		setFont(new Font("华文新魏", Font.PLAIN, 17));
	}
}
