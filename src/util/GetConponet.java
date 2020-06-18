package util;

import gui.UserJF;
import component.JButtonMe;
import component.JDialogMe;
import component.JFrameMe;

public interface GetConponet {

	public JButtonMe getTuichuButton(UserJF userJF);
	

	public JFrameMe out_jf(String userID);
	
	public JFrameMe out_resetJF(String userID);
	
}
