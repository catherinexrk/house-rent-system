package renting.bll.entity;

import java.util.Date;

/*
房客实体类
*/


/**
*
* @author Administrator
*/
public class Tenant {
	private String id;           //帐号
	private String password;  //密码
	private String name;     //姓名
	private String card;     //身份证
	private int room;         //房间号
	private int sett;
	private Float money;      //押金
	private Date time;        //入住时间
	private String sex;       //性别
	private String hometown;  //籍贯

	public Tenant() {}
	
    public Tenant(String id, String password, String name, String card, int room, Float money,  Date time, String sex, String hometown) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.card = card;
        this.room = room;
        this.money = money;
        this.time = time;
        this.sex = sex;
        this.hometown = hometown;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getSett() {
        return sett;
    }
    
    public void setSett(int sett) {
        this.sett = sett;
    }
    
    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
	
}
