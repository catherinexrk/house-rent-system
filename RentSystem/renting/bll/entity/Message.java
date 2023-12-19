package renting.bll.entity;

public class Message {
	private String from;
	private String to;
	private int room;
	
	public Message(String from, String to, int room) {
        this.from = from;
        this.to = to;
        this.room = room;
    }
	public Message() {
    
    }
	
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getRoom() {
        return room;
    }

   
	

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setRoom(int room) {
        this.room = room;
    }
	
}
