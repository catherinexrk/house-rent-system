package renting.bll;

/*
管理员业务处理类
*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import renting.bll.entity.Admin;
import renting.dal.DBConnecter;
/**
*
* @author Administrator
*/
public class AdminManager {
	private PreparedStatement getPreparedStatement(String sql) throws SQLException {
	    return new DBConnecter().getConnection().prepareStatement(sql);
	}
	/*
	 * AdminManager login方法，用于判断数据库中是否有对应的账号
	 * */
	public boolean login(Admin admin) throws SQLException {
		String sql="select * from admin where id=? and password=?";
	    PreparedStatement ps = getPreparedStatement(sql);
	    ps.setString(1, admin.getId());
	    ps.setString(2, admin.getPassword());
	    ResultSet rs = ps.executeQuery();
	    int ans = 0;
	    if(rs.next()) {
	    	ans = 1;
	    }    
	    rs.close();
	    ps.close();
	    if(ans == 1) {
	    	return true;
	    }
	    else return false;
	}
	
	//判断账号是否存在
	public boolean JudgeAdminID(String ID) throws SQLException {
		String sql = "select * from Admin where id = ?";
		PreparedStatement ps = getPreparedStatement(sql);
		ps.setString(1, ID);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return true;
		return false;
	}
}

