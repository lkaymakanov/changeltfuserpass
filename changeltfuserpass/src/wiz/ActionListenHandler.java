package wiz;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




public class ActionListenHandler implements ActionListener, ListSelectionListener{

	Wizard w;
	
	public ActionListenHandler(Wizard wiz){
		w = wiz;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 Component c = (Component)arg0.getSource();
		 handleAction(c);
	}
	
	
	//handle actions of components
	public void handleAction(Component c) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 if(c.getName() == null) return;
		 
		 //wizard button
		 if(c.getName().equals("bCon")){
			 w.wizbuttonPushed();
		 }
		
		 if(c.getName().equals("rFile")){
			 w.getConnPage().radioFile();
		 }
		 
		 if(c.getName().equals("rSpec")){
			 w.getConnPage().radioSpec();
		 }
		 
		 if(c.getName().equals("rOrcl")){
			 w.getConnPage().radioOrcl();
		 }
		 if(c.getName().equals("rPgr")){
			 w.getConnPage().radioPgr();
		 }
		 
		 if(c.getName().equals("encr")){
			 w.getUserPage().encrypt();
		 }
		 
		 if(c.getName().equals("updpass")){
			 w.getUserPage().updatePass();
		 }
		
		 if(c.getName().equals("openfdlg")){
			 w.getConnPage().openFile();
		 }
	}

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		JTable table = w.getUserPage().getUsertbl().getTable();
		int first=0, last=0; 
		// If cell selection is enabled, both row and column change events are fired
        if (e.getSource() == table.getSelectionModel()
              && table.getRowSelectionAllowed()) {
            // Column selection changed
             first = e.getFirstIndex();
             last = e.getLastIndex();
        } else if (e.getSource() == table.getColumnModel().getSelectionModel()
               && table.getColumnSelectionAllowed() ){
            // Row selection changed
             first = e.getFirstIndex();
             last = e.getLastIndex();
        }
        int selIndex =   table.getSelectedRow();
        
        w.getUserPage().getUsertbl().setSelRowIndex(selIndex);
        w.getUserPage().setTextFieldsBySelectedUser();
        System.out.println("selected  row " + selIndex);
        System.out.println("first = " + first + "last = "+ last + " difference " + (last - first));
        if (e.getValueIsAdjusting()) {
            // The mouse button has not yet been released
        }
	}
	
}
