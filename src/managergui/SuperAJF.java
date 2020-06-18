package managergui;

import java.sql.SQLException;

import javax.swing.ImageIcon;

import component.JButtonMe;
import component.JComboBoxMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabelMe;
import component.JLabel_B;
import component.JTextFiledMe;

public class SuperAJF extends JFrameMe implements JFAction{
	//创建标签
	private JLabel_B b = new JLabel_B("主标签");
	private JLabelMe b_ID = new JLabelMe("ID标签");
	private JLabelMe b_name = new JLabelMe("名字标签");
	private JLabelMe b_last = new JLabelMe("最后标签");
	
	//参加输入框和下拉选择框
	private JTextFiledMe t_ID = new JTextFiledMe();
	private JTextFiledMe t_name = new JTextFiledMe();
	private JTextFiledMe t_address = new JTextFiledMe();
	private JComboBoxMe jcom_publis = new JComboBoxMe(); 
 	
	//创建按钮
	private JButtonMe btn_re = new JButtonMe("返回");
	private JButtonMe btn_input = new JButtonMe("录入");
	
	public SuperAJF(){
		init();
		setBack(new ImageIcon("image//背景.jpg"));
		setIconImage(new ImageIcon("image//103.png").getImage());
		setVisible(true);//放在最后
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SuperAJF();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			load();
			createComponent();
			addComonent();
			setLocate();
			addListener();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComonent() {
		// TODO Auto-generated method stub
		con.add(getB());
		con.add(getB_ID());
		con.add(getB_name());
		con.add(getB_last());
		con.add(getT_ID());
		con.add(getT_name());
		con.add(getT_address());
		con.add(getJcom_publis());
		con.add(getBtn_input());
		con.add(getBtn_re());
	}

	@Override
	public void setLocate() {
		// y+40
		getB().setLocation(xs+160, ys+20);
		getB_ID().setLocation(xs+100, ys+80);
		getB_name().setLocation(xs+100, ys+130);
		getB_last().setLocation(xs+100, ys+180);
		getT_ID().setLocation(xs+200, ys+80);
		getT_name().setLocation(xs+200, ys+130);
		getT_address().setLocation(xs+200, ys+180);
		getJcom_publis().setLocation(xs+200, ys+180);
		getBtn_input().setLocation(xs+130, ys+230);
		getBtn_re().setLocation(xs+250, ys+230);
		
		
		
	}

	public void load(){
		
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	public JLabel_B getB() {
		return b;
	}

	public void setB(JLabel_B b) {
		this.b = b;
	}

	public JLabelMe getB_ID() {
		return b_ID;
	}

	public void setB_ID(JLabelMe b_ID) {
		this.b_ID = b_ID;
	}

	public JLabelMe getB_name() {
		return b_name;
	}

	public void setB_name(JLabelMe b_name) {
		this.b_name = b_name;
	}

	public JLabelMe getB_last() {
		return b_last;
	}

	public void setB_last(JLabelMe b_last) {
		this.b_last = b_last;
	}

	public JTextFiledMe getT_address() {
		return t_address;
	}

	public void setT_address(JTextFiledMe t_address) {
		this.t_address = t_address;
	}

	public JComboBoxMe getJcom_publis() {
		return jcom_publis;
	}

	public void setJcom_publis(JComboBoxMe jcom_publis) {
		this.jcom_publis = jcom_publis;
	}

	public JButtonMe getBtn_re() {
		return btn_re;
	}

	public void setBtn_re(JButtonMe btn_re) {
		this.btn_re = btn_re;
	}

	public JButtonMe getBtn_input() {
		return btn_input;
	}

	public void setBtn_input(JButtonMe btn_input) {
		this.btn_input = btn_input;
	}

	public JTextFiledMe getT_ID() {
		return t_ID;
	}

	public void setT_ID(JTextFiledMe t_ID) {
		this.t_ID = t_ID;
	}

	public JTextFiledMe getT_name() {
		return t_name;
	}

	public void setT_name(JTextFiledMe t_name) {
		this.t_name = t_name;
	}

}
