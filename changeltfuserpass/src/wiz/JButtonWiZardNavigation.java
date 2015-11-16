package wiz;

import javax.swing.JButton;

public class JButtonWiZardNavigation extends JButton{
	
	private static final long serialVersionUID = 2256890227118709053L;


	public enum BUTTON_STATE{CONNECT, BACK};
	BUTTON_STATE st = BUTTON_STATE.CONNECT;  //the buuton state 
	
	
	public JButtonWiZardNavigation() {
		// TODO Auto-generated constructor stub
		setText("Connect >>");
	}
	
	
	//set the button state
	public void setState(BUTTON_STATE st){
		this.st = st;
		
		//set text
		if(st == BUTTON_STATE.CONNECT)  setText("Connect >>");
		if(st == BUTTON_STATE.BACK)  setText("<< Back");
	}


	public BUTTON_STATE getState() {
		return st;
	}
	
	
}
