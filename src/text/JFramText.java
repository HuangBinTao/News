package text;

import javax.swing.ImageIcon;

import component.JFrameMe;

public class JFramText extends JFrameMe {

	public JFramText(){
		setLine();
		setBack(new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\32U58PICj6I_1024.jpg"));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFramText();
	}

}
