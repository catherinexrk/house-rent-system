package renting.bll;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import renting.dal.DBConnecter;

public class Register {
    String name;
    String ID;
    String password;
    String confirmpassword;
    
    public void setName(String name) {
        this.name = name;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setconfirmpasswd(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    
    private PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return new DBConnecter().getConnection().prepareStatement(sql);
	}
    
    //判断注册的账号是否符合规则
    public boolean JudgeRegister() throws SQLException {
        
        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "用户名", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "账号不能为空！", "账号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!this.password.equals(this.confirmpassword)) {
            JOptionPane.showMessageDialog(null, "两次输入的密码不一致!", "密码不一致", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        TenantManager am = new TenantManager();
        if(am.JudgeTenantID(this.ID)) {
        	 JOptionPane.showMessageDialog(null, "账号已存在", "账号已存在", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        //符合规则，弹出注册成功的窗口，并将账号添加数据库
        JOptionPane.showMessageDialog(null, "注册成功");
        addTenant();
        return true;
    }
    
    //向数据库添加Tenant账户
    void addTenant() throws SQLException {
    	String sql = "insert into tenant (id, password, name) values(?,?,?)";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setString(1, this.ID);
		ps.setString(2, this.password);
		ps.setString(3, this.name);
		ps.executeUpdate();
    }
}

