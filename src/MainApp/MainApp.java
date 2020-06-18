package MainApp;

import java.sql.SQLException;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import gui.LoginSelectJF;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
			
			LoginSelectJF jf = new LoginSelectJF();
			jf.setSize(450, 420);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
