package renting.bll.entity;

/*
客房实体
*/

/**
*
* @author Administrator
*/
public class Room {
	private int id;               //编号
	private String grade ;      //级别
	private float price;        //价格
	private int state;           //状态
	private String remarks;    //备注

	public Room() {}
    public Room(int id, String grade, float price, int state, String remarks) {
        this.id = id;
        this.grade = grade;
        this.price = price;
        this.state = state;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
	

}
