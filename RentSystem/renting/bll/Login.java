package renting.bll;

import renting.bll.entity.Admin;
import renting.bll.entity.Tenant;

/*
处理用户登录
*/

/**
*
* @author Administrator
*/
public class Login {
	
	Admin admin;
	
	Tenant tenant;
	
	public void setAdmin(Admin admin) {
		this.admin=admin;
		//System.out.println(this.admin.getPassword()+"   " + this.admin.getID());
	}
	public void setTenant(Tenant tenant) {
		this.tenant=tenant;
		
	}
	/*
	 * JudgeAdmin()方法
	 * 判断Admin的ID和密码是否正确，如果正确，显示登录成功
	 * 如果错误，弹出一个窗口，显示账号或密码错误
	 */
	public int JudgeAdmin() {
		 AdminManager am = new AdminManager();
		    try {
		        if(am.login(this.admin)) {
		        	System.out.println("登录成功");
		        	return 1;
		        }else {
		            return 0;
		        }
		    }catch(Exception e) {
		        //e.printStackTrace();
		    	//System.out.println("!!!!!!!!!");
		    }
		return 0;
	}	
	/*
	 * 
	 * 判断普通用户是否正确
	 */
	public int JudgeTenant() {
		 TenantManager tm = new TenantManager();
		    try {
		        if(tm.login(this.tenant)) {
		        	System.out.println("登录成功");
		        	return 1;
		        }else {
		            return 0;
		        }
		    }catch(Exception e) {
		        //e.printStackTrace();
		    	//System.out.println("!!!!!!!!!");
		    }
		return 0;
	}	
}
