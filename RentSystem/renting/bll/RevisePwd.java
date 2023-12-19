package renting.bll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import renting.bll.entity.Admin;
import renting.bll.entity.Tenant;
import renting.dal.DBConnecter;

public class RevisePwd {
	private Admin admin = new Admin();
	private Tenant tenant = new Tenant();
	private String modifypwd = "";
	private String confrimpwd = "";
	
	public RevisePwd(Admin admin) {
		this.admin = admin;
	}
	public RevisePwd(Tenant tenant) {
		this.tenant = tenant;
	}
	
	public void setConfrimpwd(String confrimpwd) {
		this.confrimpwd = confrimpwd;
	}
	
	public void setModifpwd(String modifypwd) {
		this.modifypwd = modifypwd;
	}
	
	private PreparedStatement getPreparedStatement(String sql) throws SQLException {
	    return new DBConnecter().getConnection().prepareStatement(sql);
	}
	
	public boolean UpdateAdmin() throws SQLException {
		if(this.admin.getId().equals("")) {
            JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�", "�˺Ų���Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(this.admin.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "���벻��Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(this.modifypwd.equals("")) {
            JOptionPane.showMessageDialog(null, "�޸����벻��Ϊ�գ�", "�޸����벻��Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(!this.modifypwd.equals(this.confrimpwd)) {
            JOptionPane.showMessageDialog(null, "������������벻һ�£�", "������������벻һ��", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		else {
			String sql = "select * from admin where id=? and password=?";
			PreparedStatement ps = getPreparedStatement(sql);
			ps.setString(1, admin.getId());
			ps.setString(2, admin.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				sql = "update admin set password=? where id=?";
				ps = getPreparedStatement(sql);
				ps.setString(1, this.confrimpwd);
				ps.setString(2, admin.getId());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "�޸ĳɹ�",JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "�˺Ż��������", "�˺Ż��������", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		}
		
		
	}
	
	public boolean UpdateTenant() throws SQLException {
		if(this.tenant.getId().equals("")) {
            JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�", "�˺Ų���Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(this.tenant.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "���벻��Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(this.modifypwd.equals("")) {
            JOptionPane.showMessageDialog(null, "�޸����벻��Ϊ�գ�", "�޸����벻��Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(!this.modifypwd.equals(this.confrimpwd)) {
            JOptionPane.showMessageDialog(null, "������������벻һ�£�", "������������벻һ��", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		else {
			String sql = "select * from tenant where id=? and password=?";
			PreparedStatement ps = getPreparedStatement(sql);
			ps.setString(1, tenant.getId());
			ps.setString(2, tenant.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				sql = "update tenant set password=? where id=?";
				ps = getPreparedStatement(sql);
				ps.setString(1, this.confrimpwd);
				ps.setString(2, tenant.getId());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "�޸ĳɹ�",JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "�˺Ż��������", "�˺Ż��������", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		}
	}
}
