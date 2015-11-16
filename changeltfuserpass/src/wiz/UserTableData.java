package wiz;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;





import user.AbstractModel;
import user.User;

public class UserTableData extends  DefaultTableModel{
	

	private static final long serialVersionUID = 8676549379469968622L;

	private List<User> users = new ArrayList<User>();
	
	public static final int INDEX_USER = 0;
    public static final int INDEX_PASS = 1;
  
    public UserTableData() {
		// TODO Auto-generated constructor stub
	}
	 
    public UserTableData(List<User> users) {
        this.users = users;
    }
 
    public AbstractModel getDisplayMode(int r) {
        return users.get(r);
    }
 

    public boolean isCellEditable(int r, int c) {
        return false;
    }
 
    public int getRowCount() {
        if (users == null) {
            return 0;
        }
        return users.size();
    }
 
    public String getColumnName(int c) {
        return UserTable.COLUMN_NAMES[c];
    }
 
    public int getColumnCount() {
        return UserTable.COLUMN_WIDTHS.length;
    }
 
  
    
    public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
    public Object getValueAt(int rowIndex, int colIndex) {
    	User u = (User)users.get(rowIndex);
    	
    	 switch (colIndex) {
         	case INDEX_USER :
              return u.getUsername();
         	case INDEX_PASS :
              return u.getPassword();
    	 }
    	 return new String("");
    }
	
	
	
}
