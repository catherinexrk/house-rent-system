package renting.bll;

import renting.bll.entity.Admin;
import renting.bll.entity.Tenant;

/*
�����û���¼
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
	 * JudgeAdmin()����
	 * �ж�Admin��ID�������Ƿ���ȷ�������ȷ����ʾ��¼�ɹ�
	 * ������󣬵���һ�����ڣ���ʾ�˺Ż��������
	 */
	public int JudgeAdmin() {
		 AdminManager am = new AdminManager();
		    try {
		        if(am.login(this.admin)) {
		        	System.out.println("��¼�ɹ�");
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
	 * �ж���ͨ�û��Ƿ���ȷ
	 */
	public int JudgeTenant() {
		 TenantManager tm = new TenantManager();
		    try {
		        if(tm.login(this.tenant)) {
		        	System.out.println("��¼�ɹ�");
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
