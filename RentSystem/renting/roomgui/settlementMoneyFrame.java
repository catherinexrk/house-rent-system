package renting.roomgui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import renting.bll.RoomManager;
import renting.bll.TenantManager;
import renting.bll.entity.Room;
import renting.bll.entity.Tenant;
import renting.gui.MainFrame;

public class settlementMoneyFrame {

	settlementMoneyFrame(int id) throws SQLException {
		init(id);
	}
	void init(int Id) throws SQLException {
		JFrame frame = new JFrame("�������");
		frame.setLayout(null);
		frame.setBounds(500, 200, 800, 500);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
		Font font=new Font("���Ŀ���",Font.TYPE1_FONT,18);
        JLabel title = new JLabel("������Ϣ");
        title.setFont(Typeface);
        title.setBounds(100, 0, 600, 100);
        frame.add(title);
		
        JLabel title2 = new JLabel("������Ϣ");
        title2.setFont(Typeface);
        title2.setBounds(500, 0, 600, 100);
        frame.add(title2);
		
        RoomManager rm = new RoomManager();
        Room room = new Room();
		room = rm.FindRoomAsID(Id);
     
		JLabel roomIdLabel = new JLabel("�����:");
		roomIdLabel.setBounds(80, 120, 100, 25);
		roomIdLabel.setFont(font);
		frame.add(roomIdLabel);
        
		JLabel roomId = new JLabel(String.valueOf(room.getId()));
		roomId.setBounds(170, 120, 100, 25);
		roomId.setFont(font);
		frame.add(roomId);
		
		JLabel GradeLabel = new JLabel("������:");
		GradeLabel.setBounds(80, 155, 100, 25);
		GradeLabel.setFont(font);
		frame.add(GradeLabel);
        
		JLabel Grade = new JLabel(room.getGrade());
		Grade.setBounds(170, 155, 100, 25);
		Grade.setFont(font);
		frame.add(Grade);
		
		JLabel PriceLabel = new JLabel("�������:");
		PriceLabel.setBounds(80, 190, 100, 25);
		PriceLabel.setFont(font);
		frame.add(PriceLabel);
        
		JLabel Price = new JLabel(String.valueOf(room.getPrice()));
		Price.setBounds(170, 190, 100, 25);
		Price.setFont(font);
		frame.add(Price);
		
		JLabel StateLabel = new JLabel("״̬:");
		StateLabel.setBounds(80, 225, 100, 25);
		StateLabel.setFont(font);
		frame.add(StateLabel);
        
		JLabel State = new JLabel(room.getState()==1?"�����":"δ���");
		State.setBounds(170, 225, 100, 25);
		State.setFont(font);
		frame.add(State);
		
		JLabel RemarksLabel = new JLabel("��ע:");
		RemarksLabel.setBounds(80, 260, 100, 25);
		RemarksLabel.setFont(font);
		frame.add(RemarksLabel);
        
		JLabel Remarks = new JLabel(room.getRemarks());
		Remarks.setBounds(170, 260, 100, 25);
		Remarks.setFont(font);
		frame.add(Remarks);
		
		TenantManager tm = new TenantManager();
		Tenant tenant = tm.GetPeopleAsRoomId(Id);
		
		if(tenant.getCard().equals("")) {
			JLabel noPeople = new JLabel("��û������÷���");
			noPeople.setBounds(500, 150, 175, 25);
			noPeople.setFont(font);
			frame.add(noPeople);
		}
		else {
			JLabel idLabel = new JLabel("�˺ţ�");
	        idLabel.setBounds(470, 100, 75, 25);
	        idLabel.setFont(font);
	        frame.add(idLabel);
	        
	        JLabel id = new JLabel(tenant.getId());
	        id.setBounds(560, 100, 75, 25);
	        id.setFont(font);
	        frame.add(id);
	        
	        JLabel passwdLabel = new JLabel("���룺");
	        passwdLabel.setBounds(470, 135, 75, 25);
	        passwdLabel.setFont(font);
	        frame.add(passwdLabel);
	        
	        JLabel passwd = new JLabel(tenant.getPassword());
	        passwd.setBounds(560, 135, 75, 25);
	        passwd.setFont(font);
	        frame.add(passwd);
	        
	        JLabel nameLabel = new JLabel("������");
	        nameLabel.setBounds(470, 170, 75, 25);
	        nameLabel.setFont(font);
	        frame.add(nameLabel);
	        
	        JLabel name = new JLabel(tenant.getName());
	        name.setBounds(560, 170, 75, 25);
	        name.setFont(font);
	        frame.add(name);
	        
	        JLabel cardLabel = new JLabel("���֤�ţ�");
	        cardLabel.setBounds(470, 205, 100, 25);
	        cardLabel.setFont(font);
	        frame.add(cardLabel);
	        
	        JLabel card = new JLabel(tenant.getCard());
	        card.setBounds(560, 205, 100, 25);
	        card.setFont(font);
	        frame.add(card);
	        
	        JLabel roomLabel = new JLabel("����ţ�");
	        roomLabel.setBounds(470, 240, 100, 25);
	        roomLabel.setFont(font);
	        frame.add(roomLabel);
	        
	        JLabel rooms = new JLabel(String.valueOf((tenant.getRoom())));
	        rooms.setBounds(560, 240, 75, 25);
	        rooms.setFont(font);
	        frame.add(rooms);
	        
	        JLabel timeLabel = new JLabel("�ⷿʱ�䣺");
	        timeLabel.setBounds(470, 275, 100, 25);
	        timeLabel.setFont(font);
	        frame.add(timeLabel);
	        
	        Date date = tenant.getTime();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String dateStr = sdf.format(date);
	        JLabel time = new JLabel(dateStr);
	        time.setBounds(560, 275, 200, 25);
	        time.setFont(font);
	        frame.add(time);
	        
	        JLabel sexLabel = new JLabel("�Ա�");
	        sexLabel.setBounds(470, 310, 75, 25);
	        sexLabel.setFont(font);
	        frame.add(sexLabel);
	        
	        JLabel sex = new JLabel(tenant.getSex());
	        sex.setBounds(560, 310, 75, 25);
	        sex.setFont(font);
	        frame.add(sex);
	        
	        JLabel htLabel = new JLabel("���᣺");
	        htLabel.setBounds(470, 340, 100, 25);
	        htLabel.setFont(font);
	        frame.add(htLabel);
	        
	        JLabel ht = new JLabel(tenant.getHometown());
	        ht.setBounds(560, 340, 100, 25);
	        ht.setFont(font);
	        frame.add(ht);
	        
		    JButton confirm = new JButton("ȷ��");
			confirm.setBounds(450,  380,  100,  25);
			confirm.setFont(font);
			frame.add(confirm);
			
			confirm.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						new TenantManager().TestingSett(tenant.getId());
						frame.setVisible(false);
						frame.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
		}
		
		/*JButton cancel = new JButton("����");
		cancel.setBounds(300, 380, 100, 25);
		cancel.setFont(font);
		frame.add(cancel);*/
		
		JButton cancel = new JButton("����");
		cancel.setBounds(200, 380, 100, 25);
		cancel.setFont(font);
		frame.add(cancel);
		
		
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new MainFrame();
			}
			
		});
		
		
		JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\117.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        frame.add(panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public static void main(String []args) throws SQLException {
		new settlementMoneyFrame(101);
	}
}
