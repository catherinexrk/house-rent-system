package renting.bll;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import renting.bll.entity.Admin;
import renting.bll.entity.Tenant;
import renting.dal.DBConnecter;

/*
 * 客户业务处理类
 * 
 */
public class TenantManager {

	private Tenant tenant = new Tenant();
	public Tenant getTenant() {
		return this.tenant;
	}
	private String sql = null;
	//获取PreparedStatement对象
	private PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return new DBConnecter().getConnection().prepareStatement(sql);
	}
	
	public boolean login(Tenant tenant) throws SQLException {
		String sql="select * from tenant where id=? and password=?";
	    PreparedStatement ps = getPreparedStatement(sql);
	    ps.setString(1, tenant.getId());
	    ps.setString(2, tenant.getPassword());
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
	
	
	public boolean JudgeTenantID(String ID) throws SQLException {
		String sql = "select * from tenant where id = ?";
		PreparedStatement ps = getPreparedStatement(sql);
		ps.setString(1, ID);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return true;
		return false;
	}
	/*
	 * 按身份证号查询房客
	 */
	public boolean QueryPeopleAsCard(String Card) throws SQLException {
		sql = "select * from tenant where card=?";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setString(1, Card);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			this.tenant.setId(rs.getString("id"));
			this.tenant.setPassword(rs.getString("password"));
			this.tenant.setName(rs.getString("name"));
			this.tenant.setSex(rs.getString("sex"));
			this.tenant.setRoom(rs.getInt("room"));
			this.tenant.setHometown(rs.getString("hometown"));
			this.tenant.setTime(rs.getDate("time"));
			this.tenant.setCard(rs.getString("card"));
			
			return true;
		}
		return false;
		
	}
	/*
	 * 按房间号查询
	 */
	public boolean QueryPeopleAsRoomId(int Roomid) throws SQLException {
		sql = "select * from tenant where room=?";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setInt(1, Roomid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			this.tenant.setId(rs.getString("id"));
			this.tenant.setPassword(rs.getString("password"));
			this.tenant.setName(rs.getString("name"));
			this.tenant.setSex(rs.getString("sex"));
			this.tenant.setRoom(rs.getInt("room"));
			this.tenant.setHometown(rs.getString("hometown"));
			this.tenant.setTime(rs.getDate("time"));
			this.tenant.setCard(rs.getString("card"));
			return true;
		}
		return false;
		
	}
	/*
	 * 
	 * 按账号查询
	 */
	public boolean QueryPeopleId(int id) throws SQLException {
		sql = "select * from tenant where id=?";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			this.tenant.setId(rs.getString("id"));
			this.tenant.setPassword(rs.getString("password"));
			this.tenant.setName(rs.getString("name"));
			this.tenant.setSex(rs.getString("sex"));
			this.tenant.setRoom(rs.getInt("room"));
			this.tenant.setHometown(rs.getString("hometown"));
			this.tenant.setTime(rs.getDate("time"));
			this.tenant.setCard(rs.getString("card"));
			return true;
		}
		return false;
	}
	
	//由房间号获得人物信息
	public Tenant GetPeopleAsRoomId(int Roomid) throws SQLException {
		sql = "select * from tenant where room=?";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setInt(1, Roomid);
		ResultSet rs = ps.executeQuery();
		Tenant tenant = new Tenant();
		tenant.setCard("");
		if(rs.next()) {
			tenant.setId(rs.getString("id"));
			tenant.setPassword(rs.getString("password"));
			tenant.setName(rs.getString("name"));
			tenant.setSex(rs.getString("sex"));
			tenant.setRoom(rs.getInt("room"));
			tenant.setHometown(rs.getString("hometown"));
			tenant.setTime(rs.getDate("time"));
			tenant.setCard(rs.getString("card"));
		}
		return tenant;
	}
	
	//插入房客信息
	public boolean insertTenant(Tenant tenant) throws SQLException {
		sql = "insert into tenant (id, password, name, card, room, time, sex, hometown) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setString(1, tenant.getId());
		ps.setString(2, tenant.getPassword());
		ps.setString(3, tenant.getName());
		ps.setString(4, tenant.getCard());
		ps.setInt(5, tenant.getRoom());
		ps.setDate(6, (Date) tenant.getTime());
		ps.setString(7, tenant.getSex());
		ps.setString(8, tenant.getHometown());
		
		ps.executeUpdate();
		return true;
		
	}
	
	//由账号获得人物信息
		public Tenant GetPeopleAsId(String id) throws SQLException {
			sql = "select * from tenant where id=?";
			PreparedStatement ps = getPreparedStatement(sql); 
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			Tenant tenant = new Tenant();
			tenant.setCard("");
			if(rs.next()) {
				tenant.setId(rs.getString("id"));
				tenant.setPassword(rs.getString("password"));
				tenant.setName(rs.getString("name"));
				tenant.setSex(rs.getString("sex"));
				tenant.setRoom(rs.getInt("room"));
				tenant.setHometown(rs.getString("hometown"));
				tenant.setTime(rs.getDate("time"));
				tenant.setCard(rs.getString("card"));
			}
			return tenant;
		}
		
	//检测是否交过押金
	public void TestingSett (String id) throws SQLException {
		sql = "select * from tenant where id=?";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Tenant tenant = new Tenant();
		tenant.setCard("");
		if(rs.next()) {
			tenant.setId(rs.getString("id"));
			tenant.setPassword(rs.getString("password"));
			tenant.setName(rs.getString("name"));
			tenant.setSex(rs.getString("sex"));
			tenant.setRoom(rs.getInt("room"));
			tenant.setHometown(rs.getString("hometown"));
			tenant.setTime(rs.getDate("time"));
			tenant.setCard(rs.getString("card"));
			tenant.setSett(rs.getInt("sett"));
		}
		if(tenant.getSett()==1) {
			JOptionPane.showMessageDialog(null, "该用户已缴纳租金！", "该用户已缴纳租金", JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "缴纳租金成功！", "缴纳租金成功", JOptionPane.INFORMATION_MESSAGE);
			sql = "update tenant set sett=1 where id=?";
			ps = getPreparedStatement(sql); 
			ps.setString(1, id);
			ps.executeUpdate();
		}
	}
	
	//检测是否交过押金
		public void UpdateSett (String id) throws SQLException {
			
			PreparedStatement ps = getPreparedStatement(sql); 
		
			sql = "update tenant set sett=1 where id=?";
			ps = getPreparedStatement(sql); 
			ps.setString(1, id);
			ps.executeUpdate();
			
		}
}
