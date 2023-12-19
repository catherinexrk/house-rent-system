package renting.roomgui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import renting.bll.RoomManager;
import renting.bll.entity.Room;
import renting.gui.MainFrame;

public class RoomAddFrame extends JFrame{

	public RoomAddFrame() {
		init();
	}
	void init() {
		JFrame frame = new JFrame("����·���");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("��ӷ���");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
		
        JLabel roomIDLabel = new JLabel("�����:");
        roomIDLabel.setBounds(125, 100, 75, 25);
        frame.add(roomIDLabel);
        
        JTextField roomID = new JTextField("");
        roomID.setBounds(200, 100, 125, 25);
        frame.add(roomID);
        
        JLabel gradeLabel = new JLabel("����:");
        gradeLabel.setBounds(125, 135, 75, 25);
        frame.add(gradeLabel);
        
        JComboBox <String> combox = new JComboBox<String>();
        combox.addItem("����һ��");
        combox.addItem("����һ��");
        combox.addItem("һ��һ��");
        combox.setBounds(200, 135, 125, 25);
        frame.add(combox);
        
        JLabel priceLabel = new JLabel("���:");
        priceLabel.setBounds(125, 170, 75, 25);
        frame.add(priceLabel);
        
        JTextField price = new JTextField();
        price.setBounds(200, 170, 125, 25);
        frame.add(price);
        
        JButton cancel = new JButton("ȡ��");
        cancel.setBounds(150, 210, 75, 25);
        frame.add(cancel);
        
        JButton addRoom = new JButton("���"); 
        addRoom.setBounds(250, 210, 75, 25);
        frame.add(addRoom);
        
        
        cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new MainFrame();
			}
        	
        });
        
        addRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Room room = new Room();
				String id = roomID.getText();
				String prices = price.getText();
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null, "����Ų���Ϊ�գ�", "����Ų���Ϊ��", JOptionPane.ERROR_MESSAGE); 
				} 
				else if(price.equals("")) {
					JOptionPane.showMessageDialog(null, "�۸���Ϊ�գ�", "�۸���Ϊ��", JOptionPane.ERROR_MESSAGE); 
				}
				else {
					room.setId(Integer.parseInt(id));
					room.setPrice(Float.parseFloat(prices));
					room.setGrade(combox.getSelectedItem().toString());
					RoomManager rm = new RoomManager();
					try {
						if(rm.RoomAdd(room)) {
							frame.setVisible(false);
							frame.dispose();
							new MainFrame();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						///e1.printStackTrace();
					}
				}	
			}
        	
        });
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\16.jpg");
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
	public static void main(String []args) {
		new RoomAddFrame();
	}
}
