package renting.bll;

/*
 * 房间业务处理类
 * 
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import renting.bll.entity.Room;
import renting.bll.entity.Tenant;
import renting.dal.DBConnecter;

public class RoomManager {
	private PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return new DBConnecter().getConnection().prepareStatement(sql);
	}
	
	
	class MyDefaultTableModel extends DefaultTableModel {
		
		public MyDefaultTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
		
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			
			return false;
		}
	}
	
	private DefaultTableModel toDefaultTableModel(ArrayList<Room> al) {
		int row = al.size();
		Object [][] o = new Object[row+1][5];
		Room room = null;
		o[0][0]="房间号";
		o[0][1]="级别";
		o[0][2]="租金";
		o[0][3]="状态";
		o[0][4]="备注";
		for(int i=0; i<row; i++) {
			room = al.get(i);
			for(int j=0; j<5; j++) {
				if(j==0) {
					o[i+1][j] = Integer.valueOf(room.getId());
				} else if(j==1) {
					o[i+1][j] = room.getGrade();
				} else if(j==2) {
					o[i+1][j] = Float.valueOf(room.getPrice());
				} else if(j==3) {
					o[i+1][j] = room.getState()==1 ? "已租出" : "未租出";
				} else if(j==4) {
					o[i+1][j] = room.getRemarks();
				}
				
			}
		}
		String col[]= {"房间号", "级别", "价格", "状态", "备注"};
		return new MyDefaultTableModel(o, col);
	}
	
	private ArrayList<Room> toArrayList(ResultSet rs) {
		try {
			ArrayList<Room> al = new ArrayList<>();
			Room room = new Room();
			while (rs.next()) {
				room = new Room();
				room.setId(rs.getInt("id"));
				room.setGrade(rs.getString("grade"));
				room.setPrice(rs.getFloat("price"));
				room.setState(rs.getInt("state"));
				room.setRemarks(rs.getString("remarks"));
				al.add(room);
			}
			rs.close();
			return al;
		} catch(SQLException ex) {
			return null;
		}
	}
	
	//查询所有房间
	private ResultSet getCustomer() throws SQLException{
		String sql = "select * from room";
		PreparedStatement ps = getPreparedStatement(sql);
		return ps.executeQuery();
	}
	
	public DefaultTableModel getMessage() {
		
		try {
			return toDefaultTableModel(toArrayList(getCustomer()));
		}catch (SQLException ex) {
			return null;
		}
	}
	
	//判断RoomID是否存在
	public boolean JudgeRoomID(int ID) throws SQLException {
		String sql = "select * from room where id = ?";
		PreparedStatement ps = getPreparedStatement(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			return true;
		return false;
	}
	
	public boolean RoomAdd(Room room) throws SQLException {
		
		try {
			String sql = "insert into room (id, price, grade, state) values (?,?,?,?)";
			PreparedStatement ps = getPreparedStatement(sql);
			ps.setInt(1, room.getId());
			ps.setFloat(2, room.getPrice());
			ps.setString(3, room.getGrade());
			ps.setInt(4,  0);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "添加房间成功！", "添加房间成功", JOptionPane.INFORMATION_MESSAGE); 
			return true;
		}catch(SQLException ex) {
			return false;
		}
		
	}
	
	public Room FindRoomAsID(int ID) throws SQLException {
		String sql = "select * from room where id = ?";
		PreparedStatement ps = getPreparedStatement(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		
		Room room = new Room();
		if(rs.next()) {
			room.setId(rs.getInt("id"));
			room.setPrice(rs.getFloat("price"));
			room.setGrade(rs.getString("grade"));
			room.setRemarks(rs.getString("remarks"));
			room.setState(rs.getInt("state"));
		}	
		return room;
	}
	
	//更新租金
	public void UpdateRoom(Room room) throws SQLException {
		 String sql = "update room set price=? where id=?";
		 PreparedStatement ps = getPreparedStatement(sql);
		 ps.setFloat(1, room.getPrice());
		 ps.setInt(2, room.getId());
		 ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "修改租金成功！", "修改租金成功", JOptionPane.INFORMATION_MESSAGE); 
	}
	
	//房客租房时判断是否有人租用
	public boolean JudgeRoomHasTenantAsID(int ID) throws SQLException {
		String sql = "select * from tenant where room = ?";
		PreparedStatement ps = getPreparedStatement(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			JOptionPane.showMessageDialog(null, "已有人租用该房间！", "已有人租用该房间", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}	
		return true;
	}
	
	public void UpdateRoomAndTenant(Tenant tenant, int roomId) throws SQLException {
		String sql = "update tenant set room=? where id=?";
		PreparedStatement ps = getPreparedStatement(sql);
		ps.setInt(1, roomId);
		ps.setString(2, tenant.getId());
		ps.executeUpdate();
		
		sql = "update room set state=1 where id=?";
		ps = getPreparedStatement(sql);
		ps.setInt(1, roomId);
		ps.executeUpdate();
	}
}

