package renting.bll.entity;

import java.util.Date;

/*
����ʵ����
*/


/**
*
* @author Administrator
*/
public class Tenant {
	private String id;           //�ʺ�
	private String password;  //����
	private String name;     //����
	private String card;     //���֤
	private int room;         //�����
	private int sett;
	private Float money;      //Ѻ��
	private Date time;        //��סʱ��
	private String sex;       //�Ա�
	private String hometown;  //����

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
