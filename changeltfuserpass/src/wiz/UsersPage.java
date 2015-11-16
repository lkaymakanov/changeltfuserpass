package wiz;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.is_bg.ltf.db.common.DBExecutor;
import net.is_bg.ltf.db.common.impl.DataSourceConnectionFactoryDrManager;
import user.User;
import user.UserUpdate;


public class UsersPage extends Page{


	private static final long serialVersionUID = 551478529499786193L;

	 
	private Wizard w;
	
	
	JTextField  pass = new JTextField(20);
	JTextField  passen = new JTextField(20);
	JTextField  usrpass = new JTextField(20);
	JLabel usrnamel  = new JLabel();
	
	UserTable usertbl = new UserTable();
	

	public UsersPage(Wizard wiz) {
		// TODO Auto-generated constructor stub
		w = wiz;
		initPage();
	}
	
	
	
	


	@Override
	protected void initPage() {
		// TODO Auto-generated method stub
		//init table
		usertbl.initTable(this, w.getWizListener());
		usertbl.setSelRowIndex(-1);  //init selected row index
		//create user edit panel
		usereditPanel();
	}
	
	
	
	
	public void initTextFields(){
		pass.setText("pass to encrypt..");
		usrpass.setText("selected user pass...");
		passen.setText("pass after it's encrypted...");
		usertbl.setSelRowIndex(-1); 
		usrnamel.setText("");
	}
	
	
	public void setTextFieldsBySelectedUser(){
	   User u = usertbl.getSelectedUser();
	   if(u == null)  return;
	   
	   usrnamel.setText(u.getUsername());
	   usrpass.setText(u.getPassword());
	}
	
	
	
	
	
	
	//get user table
	public UserTable getUsertbl() {
		return usertbl;
	}


	//update the password
	public void updatePass(){
		if(getUsertbl().getRowSelIndex() == -1){
			Utils.showErrMsg(this, "Please Select User to update...");
			return;
		}
		
		//update to DB
		User u = usertbl.getSelectedUser();
		u.setPassword(usrpass.getText());
		
    	
		DataSourceConnectionFactoryDrManager ds = new DataSourceConnectionFactoryDrManager(w.getConnPage().getConnectionProperties());
       	Connection c = ds.getConnection();
    	
       	
       //	if(ds.getErr().getErr() == ErrCodeMsg.ERRCODE.ERR){Utils.showErrMsg(this, ds.getErr().getErrMsg()); return ;}
    	
    	DBExecutor ex = new DBExecutor(ds);
		UserUpdate st = new UserUpdate(u);
		ex.execute(st);
		
		/*if(ex.getErr().getErr() == ErrCodeMsg.ERRCODE.ERR) {Utils.showErrMsg(this, ex.getErr().getErrMsg()); return ;}
		*/
		//show suceess msg
		Utils.showSuccessMsg(this, "User password sucessfully updated...");
		
	}
	
	//encrypt button pushed
	public  void encrypt(){
    	passen.setText(Utils.getEncryptedPass(pass.getText()));
    }
	
	
	//init the data base connection labels on top
	private void initDbConnectionPane(){
		
	}
	
	private void usereditPanel(){
		
		//the panel to generate pass
				JPanel genPasspanel = new JPanel();
				genPasspanel.setLayout(new GridBagLayout());
				GridBagConstraints gc = new GridBagConstraints();
				
				JLabel passl = new JLabel("Pass");
				JLabel passlen = new JLabel("Encr Pass");
				
				JButton  btnencrypt = new JButton();
				
				btnencrypt.setText("Encrypt");
				btnencrypt.addActionListener(w.getWizListener());
				btnencrypt.setName("encr");
				
				gc.gridx = 0;
				gc.gridy = 0;
				gc.anchor = GridBagConstraints.WEST;
				genPasspanel.add(passl, gc);
				
				gc.gridx = 1;
				gc.gridy = 0;
				genPasspanel.add(pass, gc);
				
				gc.gridx = 0;
				gc.gridy = 1;
				gc.anchor = GridBagConstraints.WEST;
				genPasspanel.add(passlen, gc);
				
				gc.gridx = 1;
				gc.gridy = 1;
				genPasspanel.add(passen, gc);
				
				gc.gridx = 2;
				gc.gridy = 0;
				genPasspanel.add(btnencrypt, gc);
				
				
			
				JLabel usrl = new JLabel("User name");
				JLabel usrpassl = new JLabel("New Pass");
				
				
				
				JButton  btnupdusr = new JButton("Update pass");
				btnupdusr.setName("updpass");
				btnupdusr.addActionListener(w.getWizListener());
				
				gc.gridx = 0;
				gc.gridy = 2;
				gc.anchor = GridBagConstraints.WEST;
				genPasspanel.add(usrl, gc);
				
				gc.gridx = 0;
				gc.gridy = 3;
				gc.anchor = GridBagConstraints.WEST;
				genPasspanel.add(usrpassl, gc);
				
				gc.gridx = 1;
				gc.gridy = 2;
				gc.anchor = GridBagConstraints.CENTER;
				genPasspanel.add(usrnamel, gc);
				
				gc.gridx = 1;
				gc.gridy = 3;
				genPasspanel.add(usrpass, gc);
				
				gc.gridx = 2;
				gc.gridy = 3;
				genPasspanel.add(btnupdusr, gc);
				
				
				
				add(genPasspanel);
				
	}
	
	
	

}
