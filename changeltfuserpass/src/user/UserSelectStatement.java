package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;


public class UserSelectStatement extends SelectSqlStatement{


	List<User> result = new  ArrayList<User>();
	
	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return  " select "+
				" user_id, "+
				" fullname, "+
				" username, "+
				" password "+
 
				" from users  order by username ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
		    User u = new User();
			u.setId(rs.getLong("user_id"));
			u.setFullName(rs.getString("fullname"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			result.add(u);
		}
	}

	public List<User> getResult() {
		return result;
	}


}
