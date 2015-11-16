package wiz;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import user.User;




public class UserTable {
	
	public static final int[] COLUMN_WIDTHS = new int[] {
        50, 50
	};
	public static final String[] COLUMN_NAMES = new String[] {
        "User", "Pass"
 	};
 
 
	JTable table = new JTable();
	UserTableData data = new UserTableData();
	User edtUsr;
	int selRowIndex = -1;
	
	public UserTable(){
		
	}
	
	public void setData(UserTableData data){
		this.data = data;
		table.setModel(data);
	}
	
	public void setUsers(List<User> users) {
		this.data.setUsers(users);
		table.setModel(data);
	}
	
	
	public void initTable(JPanel panel, ListSelectionListener list){
		
			//create table columns
			for (int i = 0; i < COLUMN_WIDTHS.length; i++) {
	            TableColumn col = new TableColumn(i, COLUMN_WIDTHS[i]);
	            col.setIdentifier(COLUMN_NAMES[i]);
	            col.setHeaderValue(COLUMN_NAMES[i]);
	            table.addColumn(col);
	        }
			
			//add table to scroll panel
			JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			table.setFillsViewportHeight(true);
			
			
			panel.add(scrollPane);
			
			//add selection listener
			table.getSelectionModel().addListSelectionListener(list);
	}

	
	//retrieve selected User from  table
	public User getSelectedUser(){
		if(selRowIndex == -1 || selRowIndex > data.getUsers().size()){
			return null;
		}
		return (User) data.getUsers().get(selRowIndex);
	}
	
	//getters  & setters
	public JTable getTable() {
		return table;
	}

	public UserTableData getData() {
		return data;
	}

	public User getEdtUsr() {
		return edtUsr;
	}

	public int getRowSelIndex() {
		return selRowIndex;
	}

	public void setSelRowIndex(int selIndex) {
		this.selRowIndex = selIndex;
	}

	
}
