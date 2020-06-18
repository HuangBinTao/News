package text;

import java.awt.Label;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

import mybean.Beans;

import org.apache.commons.beanutils.BeanUtils;

import component.JComboBoxMe;
import component.JFrameMe;
import component.JLabelMe;
import component.JTextFiledMe;

public class text extends JFrameMe{

	public text() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		topPane.add(new JTextFiledMe("电饭锅"));
//		getContentPane().add(new JLabelMe("d阿fdsg斯蒂芬"));
//		getContentPane().add(new JComboBoxMe(new String[]{
//				"换个", "十多个", "沙发", "adsf"
//		}));
//		
//		ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\image\\e1.png");
//		JLabel b = new JLabel(icon);
//		b.setBounds(0, 0, 500, 500);
//		getLayeredPane().add(b, new Integer(Integer.MIN_VALUE));
//		JPanel con = (JPanel) getContentPane();
//		con.setOpaque(false);
		JComboBoxMe jcom = new JComboBoxMe(new String[]{
				"换个", "十多个", "沙发", "adsf"
		});
		topPane.add(jcom);
		setVisible(true);
		
	}
	

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userID", "sdf");
		Beans bean = new Beans();
		try {
			BeanUtils.populate(bean, map);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
