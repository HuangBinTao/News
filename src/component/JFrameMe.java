package component;

import gui.UserJF;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JFrameMe extends JFrame {
	
	/**
	 * 
	 */
	public ImageIcon icon;
	public JPanel topPane;
	public JPanel con;
	public JLabel b_icon;
	private static final long serialVersionUID = 1L;
	private UserJF userJF;
	public int xs = 0;
	public int ys = 0;
	public JFrameMe() {
		
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//初始化
		initJF();
//		setVisible(true);
		
	}
	
	public static void main(String arg[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		
		JFrameMe jf = new JFrameMe();
		jf.setVisible(true);
	}
	
	
	public void initJF(){
		//初始化
		setSize(500,500);
		setTitle("");
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con = (JPanel) getContentPane();
		//设置背景
//		setLine();
//		setBack(new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\05258PICpYe_1024.jpg"));
//		setBack(new ImageIcon("image\\1.png"));
//		
		
	}
	
	
	/**
	 * 设置背景
	 */
	public Dimension setBack(ImageIcon icon){
		
//		ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\05258PICpYe_1024.jpg");
//		ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\32U58PICj6I_1024.jpg");
//		icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\13458PICjeX_1024.jpg");
		Dimension dim = new Dimension();
		dim.setSize(icon.getIconWidth(), icon.getIconHeight());
		b_icon = new JLabel(icon);
		b_icon.setBounds(0, 0, icon.getIconWidth(),icon.getIconHeight());
//		b_icon.setBounds(0, 0, 1345, 640);
		getLayeredPane().add(b_icon, new Integer(Integer.MIN_VALUE));
		JPanel con = (JPanel) getContentPane();
		
		con.setOpaque(false);
		return dim;
	}
	/**
	 * 设置默认背景
	 */
	public void setBack(){
		
//		ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\05258PICpYe_1024.jpg");
//		ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\32U58PICj6I_1024.jpg");
		icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\13458PICjeX_1024.jpg");
		
		b_icon = new JLabel(icon);
		b_icon.setBounds(0, 0, getWidth(), getHeight());
//		b_icon.setBounds(0, 0, 1345, 640);
		getLayeredPane().add(b_icon, new Integer(Integer.MIN_VALUE));
		JPanel con = (JPanel) getContentPane();
		con.setOpaque(false);
	}
	
	/**
	 * 设置划分线时,不要设置背景
	 */
	
	public void setLine(){
		getLayeredPane().setLayout(null);
		JLabel[][] btns = new JLabel[13][13];
		 for (int i = 0 ; i < 13; i++) {
			 
			 for(int j = 0; j < 13; j++){
				 btns[i][j] = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\13458PICjeX_1024.jpg"));
				 btns[i][j].setSize(96, 96);
				 btns[i][j].setLocation(j*98, i*98);
//				 btns[i][j].setLocation(j*100, i*100);
//				 btns[i][j].setEnabled(false);
////				 btns[i][j].setBorderPainted(false);
//				 btns[i][j].setContentAreaFilled(false);
				 btns[i][j].setBackground(Color.red);
				getLayeredPane().add(btns[i][j], null, new Integer(Integer.MIN_VALUE));
			 }
			 
			
		}
	}

	public UserJF getUserJF() {
		return userJF;
	}

	public void setUserJF(UserJF userJF) {
		this.userJF = userJF;
	}

	public int getXs() {
		return xs;
	}

	public void setXs(int xs) {
		this.xs = xs;
	}

	public int getYs() {
		return ys;
	}

	public void setYs(int ys) {
		this.ys = ys;
	}
	

	
}
