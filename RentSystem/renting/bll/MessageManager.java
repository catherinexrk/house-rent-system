package renting.bll;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import renting.bll.entity.Message;
import renting.dal.DBConnecter;

public class MessageManager {
	
	private PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return new DBConnecter().getConnection().prepareStatement(sql);
	}
	
	//插入信息
	public void AddMeaasge(String from, String to, int room) throws SQLException {
		String sql = "insert into message (fromid, toid, room) values(?,?,?)";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setString(1, from);
		ps.setString(2, to);
		ps.setInt(3, room);
		ps.executeUpdate();
	}
	
	//查询是否有消息需要处理
	public boolean SelectMessage() throws SQLException {
		String sql = "select * from message";
		PreparedStatement ps = getPreparedStatement(sql); 
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return true;
		return false;	
	}
	
	//获取消息
	public Message getMessage() throws SQLException {
		String sql = "select * from message";
		PreparedStatement ps = getPreparedStatement(sql); 
		ResultSet rs = ps.executeQuery();
		Message me = new Message();
		if(rs.next()) {
			me.setFrom(rs.getString("fromid"));
			me.setTo(rs.getString("toid"));
			me.setRoom(rs.getInt("room"));
			
			return me;
		}
		return me;
			
	}
	
	//删除信息
	public void DeleteMessage(Message me) throws SQLException {
		String sql = "delete from message where fromid=? and toid=? and room =?";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setString(1, me.getFrom());
		ps.setString(2, me.getTo());
		ps.setInt(3, me.getRoom());
		ps.executeUpdate();
		
	}
}
