package managergui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import component.JButtonMe;
import component.JComboBoxMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabel_B;

public class SuperBJF extends JFrameMe implements JFAction {
	//创建主标签
	
	//创建下拉选择框，查询按钮，预览按钮，退出按钮
	
	//创建表格,创建滚动面板
	
	//创建文本域
	
	//创建主标签
	private JLabel_B b = new JLabel_B("主标签");
	//创建下拉选择框，查询按钮，预览按钮，退出按钮
	private JButtonMe btn_find = new JButtonMe("预览");
	private JButtonMe btn_skip = new JButtonMe("打印");
	private JButtonMe btn_re = new JButtonMe("返回");
	private JComboBoxMe jcom = new JComboBoxMe();
	//创建表格,创建滚动面板
	private JTable table = new JTable();
	private JScrollPane jsc = new JScrollPane(table);
	//创建文本域
	private JTextArea ta = new JTextArea();
	private JScrollPane jsc_ta = new JScrollPane(ta);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuperBJF(){
		init();
		setBack(new ImageIcon("image//背景.jpg"));
		setModelForTable();
		setIconImage(new ImageIcon("image//103.png").getImage());
//		setVisible(true);//放在最后,待删除
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SuperBJF();
	}
	/**
	 * 设置表格
	 */
	public void setModelForTable(){
		String[] name = new String[]{
				"属性1","属性2","属性3","属性4"
		};
		
		DefaultTableModel model = new DefaultTableModel(name, 11);
		getTable().setModel(model);
	}
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
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
		//创建主标签
		con.add(getB());
		//创建下拉选择框，查询按钮，预览按钮，退出按钮
		con.add(getJcom());
		con.add(getBtn_find());
		con.add(getBtn_skip());
		con.add(getBtn_re());
		//添加滚动面板
		con.add(jsc);
		//创建文本域
		con.add(jsc_ta);
	}

	@Override
	public void setLocate() {
		//创建主标签
		getB().setLocation(xs+170, ys+20);
		//创建下拉选择框，查询按钮，预览按钮，退出按钮
		getJcom().setLocation(xs+30, ys+80);
		getBtn_find().setLocation(xs+140, ys+80);
		getBtn_skip().setLocation(xs+250, ys+80);
		getBtn_re().setLocation(xs+360, ys+80);
		//设置滚动面板
		jsc.setSize(400, 200);
		jsc.setLocation(xs+42, ys+120);
		//创建文本域
//		getTa().setBounds(xs+42, ys+330, 400, 120);
		jsc_ta.setBounds(xs+42, ys+330, 400, 120);
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

	public JComboBoxMe getJcom() {
		return jcom;
	}

	public void setJcom(JComboBoxMe jcom) {
		this.jcom = jcom;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButtonMe getBtn_re() {
		return btn_re;
	}

	public void setBtn_re(JButtonMe btn_re) {
		this.btn_re = btn_re;
	}

	public JButtonMe getBtn_find() {
		return btn_find;
	}

	public void setBtn_find(JButtonMe btn_find) {
		this.btn_find = btn_find;
	}

	public JButtonMe getBtn_skip() {
		return btn_skip;
	}

	public void setBtn_skip(JButtonMe btn_skip) {
		this.btn_skip = btn_skip;
	}

	public JTextArea getTa() {
		return ta;
	}

	public void setTa(JTextArea ta) {
		this.ta = ta;
	}

}
