package renting.bll.people;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

import renting.bll.entity.Tenant;
import renting.dal.DBConnecter;
import renting.gui.usergui.ShowIdAndPassword;

public class TenantAdd {
	private Tenant tenant = new Tenant();
	
	public TenantAdd(Tenant tenant) {
		this.tenant = tenant;
	}
	
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	public Tenant getTenant() {
		return this.tenant;
	}
	
	private PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return new DBConnecter().getConnection().prepareStatement(sql);
	}
	
	public int add() {
		if(this.tenant.getCard().equals("")) {
            JOptionPane.showMessageDialog(null, "身份证号不能为空！", "身份证号不能为空", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
		
		if(this.tenant.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "姓名不能为空！", "姓名不能为空", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

		try {
			String sql = "select * from tenant where card = ?";
			PreparedStatement ps = getPreparedStatement(sql);
			ps.setString(1, this.tenant.getCard());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				this.tenant.setId(rs.getString("id"));
				this.tenant.setPassword(rs.getString("password"));
				return 1;
			}
			else {
	            Random rand = new Random();
				String a = String.valueOf(rand.nextInt(99999999));
				String b = String.valueOf(rand.nextInt(99999999));
				this.tenant.setId(a);
				this.tenant.setPassword(b);
				return 2;
				//new ShowIdAndPassword(this.tenant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return 0;
	}
}
