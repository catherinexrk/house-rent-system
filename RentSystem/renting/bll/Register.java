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
    
    //�ж�ע����˺��Ƿ���Ϲ���
    public boolean JudgeRegister() throws SQLException {
        
        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�", "�û���", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�", "�˺�Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!this.password.equals(this.confirmpassword)) {
            JOptionPane.showMessageDialog(null, "������������벻һ��!", "���벻һ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        TenantManager am = new TenantManager();
        if(am.JudgeTenantID(this.ID)) {
        	 JOptionPane.showMessageDialog(null, "�˺��Ѵ���", "�˺��Ѵ���", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        //���Ϲ��򣬵���ע��ɹ��Ĵ��ڣ������˺�������ݿ�
        JOptionPane.showMessageDialog(null, "ע��ɹ�");
        addTenant();
        return true;
    }
    
    //�����ݿ����Tenant�˻�
    void addTenant() throws SQLException {
    	String sql = "insert into tenant (id, password, name) values(?,?,?)";
		PreparedStatement ps = getPreparedStatement(sql); 
		ps.setString(1, this.ID);
		ps.setString(2, this.password);
		ps.setString(3, this.name);
		ps.executeUpdate();
    }
}

