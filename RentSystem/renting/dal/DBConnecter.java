package renting.dal;

/*
���ݿ�����
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
* @author Administrator
*/
public class DBConnecter {
	/*
		�������ݿ�
	*/
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/renting?serverTimezone=UTC&characterEncoding=utf-8";
	private String user = "root";
	private String password = "111111";
	
	public Connection getConnection() throws SQLException {
	    try {
	        Class.forName(driver);
	    } catch (java.lang.ClassNotFoundException cnfe) {
	        cnfe.printStackTrace();
	        System.out.println("����ʧ��");
	    }
	    Connection conn = null;
	    //conn=DriverManager.getConnection(URL, "root", "12481632");
	    try {
	    	conn = DriverManager.getConnection(url, user, password);
	    	
	    }catch(SQLException ex) {
	    	System.out.println("���ݿ��¼ʧ��!");
	    } 
	    return conn;
	}
/*

*/
}
