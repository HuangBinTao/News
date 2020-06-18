package gui;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import service.BooksNewsService;
import util.UtilIM;
import component.JButtonMe;
import component.JDialogMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabel_B;

public class BooksNewsJF extends JFrameMe implements JFAction{

	
	
	private JLabel_B b = new JLabel_B("订阅报刊");
	
	private JTable table = new JTable();
	private JScrollPane jsc = new JScrollPane(table);
	
	private JButtonMe btn_book = new JButtonMe("订阅");
	
	private String userID;
	private JDialogMe jd = null;
	
	public BooksNewsJF(){
		
		init();
		setBack(new ImageIcon("image//2.jpg"));
		setIconImage(new ImageIcon("image//102.png").getImage());
		
//		setVisible(true); //放在最后待删除
	}
	
	public BooksNewsJF(String userID) {
		// TODO Auto-generated constructor stub
		this.userID = userID;
		init();
		setBack(new ImageIcon("image//2.jpg"));
		
//		setVisible(true); //放在最后待删除
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BooksNewsJF("1");
		
	}

	public void setTuichuButton(UserJF userJF){
		//添加退出按钮
		con.add(new UtilIM().getTuichuButton(userJF));
	}
	
	public void load(){
		
		//加载时设置表格的样式
		//表格为查阅数据库表中的报刊表
		table.setModel(new BooksNewsService().getTableModel());
		
	}
	
	@Override
	public void init() {
		
		try {
//			setTitle("用户操作界面");
			createComponent();
			addComonent();
			setLocate();
			addListener();
			load();
//			setBack(new ImageIcon("image//2.jpg"));
			
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

		con.add(b);
		con.add(jsc);
		con.add(btn_book);
		
		
	}

	@Override
	public void setLocate() {
		b.setLocation(150, 10);
		
		// 设置放表格的jsc的属性
		jsc.setSize(400, 300);
		jsc.setLocation(40, 70);
		//设置按钮的大小
		btn_book.setLocation(190, 380);
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		btn_book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					JFrameMe jd = new UtilIM().out_jf(userID);
					jd.addWindowListener(new WindowListener() {
						
						@Override
						public void windowOpened(WindowEvent e) {
							// TODO Auto-generated method stub
							btn_book.setEnabled(false);
							
						}
						
						@Override
						public void windowIconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeiconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeactivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowClosing(WindowEvent e) {
							// TODO Auto-generated method stub
							
							btn_book.setEnabled(true);
						}
						
						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub
							
							btn_book.setEnabled(true);
						}
						
						@Override
						public void windowActivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
				
				 
				 
			}
		});
		
		
		
		
	}

}
