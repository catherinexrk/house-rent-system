package renting.bll.entity;

/*
����Աʵ����
*/

/**
*
* @author Administrator
*/
public class Admin {
	private String id;                 //���
	private String name;           //����
	private String password;      //����
	private String extend;         //Ȩ��
	public Admin() {}
	public Admin(String id, String name, String password, String extend) {
	        this.id = id;
	        this.name = name;
	        this.password = password;
	        this.extend = extend;
	}
	public String getId() {
	    return id;
	}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getExtend() {
        return extend;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
   

}
