package renting.bll.entity;

/*
�ͷ�ʵ��
*/

/**
*
* @author Administrator
*/
public class Room {
	private int id;               //���
	private String grade ;      //����
	private float price;        //�۸�
	private int state;           //״̬
	private String remarks;    //��ע

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
