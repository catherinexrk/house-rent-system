package renting.bll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import renting.bll.RoomManager.MyDefaultTableModel;
import renting.bll.entity.History;
import renting.bll.entity.Room;
import renting.dal.DBConnecter;

public class HistoryManager {
	
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
	
	private DefaultTableModel toDefaultTableModel(ArrayList<History> al) {
		int row = al.size();
		Object [][] o = new Object[row+1][7];
		History hs = null;
		o[0][0]="ס�ޱ��";
		o[0][1]="�ÿ�����";
		o[0][2]="�����";
		o[0][3]="�ⷿʱ��";
		o[0][4]="����ʱ��";
		o[0][5]="���";
		o[0][6]="��ע";
		for(int i=0; i<row; i++) {
			hs = al.get(i);
			for(int j=0; j<7; j++) {
				if(j==0) {
					o[i+1][j] = Integer.valueOf(hs.getId());
				} else if(j==1) {
					o[i+1][j] = hs.getName();
				} else if(j==2) {
					o[i+1][j] = Integer.valueOf(hs.getRoom());
				} else if(j==3) {
					o[i+1][j] = hs.getRegisterTime();
				} else if(j==4) {
					o[i+1][j] = hs.getExitTime();
				}else if(j==5) {
					o[i+1][j] = Float.valueOf(hs.getMoney());
				}else {
					o[i+1][j] = hs.getRemarks();
				}
				
			}
		}
		String col[]= {"ס�ޱ��", "�ÿ�����", "�����", "�ⷿʱ��", "����ʱ��", "���", "��ע"};
		return new MyDefaultTableModel(o, col);
	}
	
	private ArrayList<History> toArrayList(ResultSet rs) {
		try {
			ArrayList<History> al = new ArrayList<>();
			History hs = new History();
			while (rs.next()) {
				hs = new History();
				hs.setId(rs.getInt("id"));
				hs.setRoom((rs.getInt("room")));
				hs.setMoney((rs.getFloat("money")));
				hs.setName(rs.getString("name"));
				hs.setRemarks(rs.getString("remarks"));
				hs.setRegisterTime(rs.getDate("registertime"));
				hs.setExitTime(rs.getDate("exittime"));
				
				al.add(hs);
			}
			rs.close();
			return al;
		} catch(SQLException ex) {
			return null;
		}
	}
	
	//��ѯ������ʷ��¼
	public ResultSet getHistory() throws SQLException{
		String sql = "select * from history";
		PreparedStatement ps = getPreparedStatement(sql);
		return ps.executeQuery();
	}
	
	public DefaultTableModel getMessage() {
		
		try {
			return toDefaultTableModel(toArrayList(getHistory()));
		}catch (SQLException ex) {
			return null;
		}
	}
}
