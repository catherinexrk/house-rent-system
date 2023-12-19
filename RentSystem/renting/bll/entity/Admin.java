package renting.bll.entity;

/*
管理员实体类
*/

/**
*
* @author Administrator
*/
public class Admin {
	private String id;                 //编号
	private String name;           //姓名
	private String password;      //密码
	private String extend;         //权限
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
