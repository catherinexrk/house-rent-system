package renting.bll.entity;

/*
历史记录实体
历史记录实体是小区房间的缴费记录,方便统计与查账使用
*/
import java.util.Date;

/**
*
* @author Administrator
*/
public class History {
	private int id;
	private String name;
	private int room;
	private Date registerTime;
	private Date exitTime;
	private float money;
	private String remarks;

	public History() {}
    public History(int id, String name, int room, Date registerTime, Date exitTime, float money, String remarks) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.registerTime = registerTime;
        this.exitTime = exitTime;
        this.money = money;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRoom() {
        return room;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public float getMoney() {
        return money;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
        
}
