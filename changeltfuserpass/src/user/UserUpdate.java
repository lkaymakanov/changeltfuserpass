package user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.is_bg.ltf.db.common.UpdateSqlStatement;


public class UserUpdate extends UpdateSqlStatement{
	
	User u;
	public UserUpdate(User u) {
		// TODO Auto-generated constructor stub
		this.u = u;
	}

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " update  users "+
			    " set password = ? ,  "+
			    " faultcounter = 0 " +
			 	" where user_id = ?";
	}

	
	@Override
	protected void setParameters(PreparedStatement prStmt) throws SQLException {
		// TODO Auto-generated method stub
		bindVarData.setString(u.getPassword());
		bindVarData.setLong(u.getId());
		
		bindVarData.setParameters(prStmt);
	}
	
	
}
