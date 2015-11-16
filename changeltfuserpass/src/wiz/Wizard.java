package wiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;







import net.is_bg.ltf.db.common.DBConfig;
import net.is_bg.ltf.db.common.impl.logging.LogFactorySystemOut;
import net.is_bg.ltf.db.common.impl.timer.ElapsedTimer;
import net.is_bg.ltf.db.common.impl.visit.VisitEmpty;
import net.is_bg.ltf.db.common.interfaces.timer.IElaplsedTimer;
import net.is_bg.ltf.db.common.interfaces.timer.IElaplsedTimerFactory;
import net.is_bg.ltf.db.common.interfaces.visit.IVisit;
import net.is_bg.ltf.db.common.interfaces.visit.IVisitFactory;
import wiz.JButtonWiZardNavigation.BUTTON_STATE;

public class Wizard extends JFrame {
	
	

	private static final long serialVersionUID = 1782579312920885244L;
	
	CardLayout card ;
	JPanel wizpanel;
	JButtonWiZardNavigation btnNavigation;
	
	//action listener 
	ActionListenHandler wizListener;
	
	//the pages
	ConnectionPage connPage;
	UsersPage      userPage;
	Dimension dLittle = new Dimension(400, 260);
	Dimension dBig= new Dimension(800, 600);

	public static void main(String []args){
		 /*try {
			UIManager.setLookAndFeel(
			          UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Wizard w = new Wizard(); w.showWiz();
		w.setResizable(false);
	}
	
	
	public Wizard() {
		wizListener = new ActionListenHandler(this);
		connPage = new ConnectionPage(this);
		userPage = new UsersPage(this);
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void showWiz(){
		setSize(dLittle);
		
		setVisible(true);
	}
	
	private void init(){
		wizpanel = new JPanel();
		card = new CardLayout();   //use card layout to switch panels
		wizpanel.setLayout(card);
		getContentPane().add(BorderLayout.CENTER, wizpanel);
		
		//wizard pages - connection page & userspage
		wizpanel.add( "1", connPage);
		wizpanel.add( "2", userPage);
		
		
		DBConfig.initDBConfig(new LogFactorySystemOut(), new IVisitFactory() {
			@Override
			public IVisit getVist() {
				// TODO Auto-generated method stub
				return new VisitEmpty();
			}
		}, null, new IElaplsedTimerFactory() {
			
			@Override
			public IElaplsedTimer getElapsedTimer() {
				// TODO Auto-generated method stub
				return new ElapsedTimer();
			}
		});
		
		//navigation button panel
		JPanel buttonp = new JPanel();
	    getContentPane().add(BorderLayout.SOUTH,buttonp);
	    btnNavigation = new JButtonWiZardNavigation();
	    btnNavigation.setName("bCon");
		buttonp.add(btnNavigation);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNavigation.addActionListener(getWizListener());
		
	}
	
	//navigation button is pushed  -- handler
	public  void wizbuttonPushed(){
		 //connect & show next page & change state if successful
		 if(btnNavigation.getState() == BUTTON_STATE.CONNECT){
			try{	 
				btnNavigation.setEnabled(false);  
				connPage.Connect();
				
					
				
				card.next(wizpanel);
				btnNavigation.setState(BUTTON_STATE.BACK);
				setSize(dBig);
				btnNavigation.setEnabled(true);
			}catch(Exception e){
				Utils.showErrMsg(this, e.getMessage());
				return ;
			}
			
			return;
		 }
		
		 //goto connection page
		 if(btnNavigation.getState() == BUTTON_STATE.BACK){
			 card.next(wizpanel);
			 setSize(dLittle);
			 btnNavigation.setState(BUTTON_STATE.CONNECT);
		 }
	}


	
	//getters & setters
	public ActionListenHandler getWizListener() {
		return wizListener;
	}


	public ConnectionPage getConnPage() {
		return connPage;
	}


	public void setConnPage(ConnectionPage connPage) {
		this.connPage = connPage;
	}


	public UsersPage getUserPage() {
		return userPage;
	}


	public void setUserPage(UsersPage userPage) {
		this.userPage = userPage;
	}



	
	
}
