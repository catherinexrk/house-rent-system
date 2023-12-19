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
            JOptionPane.showMessageDialog(null, "账号不能为空！", "账号不能为空", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(this.admin.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码不能为空", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(this.modifypwd.equals("")) {
            JOptionPane.showMessageDialog(null, "修改密码不能为空！", "修改密码不能为空", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(!this.modifypwd.equals(this.confrimpwd)) {
            JOptionPane.showMessageDialog(null, "两次输入的密码不一致！", "两次输入的密码不一致", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "修改成功！", "修改成功",JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "账号或密码错误！", "账号或密码错误", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		}
		
		
	}
	
	public boolean UpdateTenant() throws SQLException {
		if(this.tenant.getId().equals("")) {
            JOptionPane.showMessageDialog(null, "账号不能为空！", "账号不能为空", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(this.tenant.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码不能为空", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(this.modifypwd.equals("")) {
            JOptionPane.showMessageDialog(null, "修改密码不能为空！", "修改密码不能为空", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		else if(!this.modifypwd.equals(this.confrimpwd)) {
            JOptionPane.showMessageDialog(null, "两次输入的密码不一致！", "两次输入的密码不一致", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "修改成功！", "修改成功",JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "账号或密码错误！", "账号或密码错误", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		}
	}
}
