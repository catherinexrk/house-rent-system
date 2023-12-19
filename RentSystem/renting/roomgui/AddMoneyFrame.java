package renting.roomgui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import renting.bll.RoomManager;
import renting.bll.TenantManager;
import renting.bll.entity.Room;
import renting.gui.MainFrame;

public class AddMoneyFrame extends JFrame{

	AddMoneyFrame(Room room) {
		init(room);
	}
	
	void init(Room room) {
		JFrame frame = new JFrame("�������");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 500);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
		Font font=new Font("���Ŀ���",Font.TYPE1_FONT,18);
        JLabel title = new JLabel("�������");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\13.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        
        JLabel idLabel = new JLabel("����ţ�");
        idLabel.setBounds(120, 100, 125, 25);
        idLabel.setFont(font);
        frame.add(idLabel);
        
        JLabel id = new JLabel(String.valueOf(room.getId()));
        id.setBounds(230, 100, 125, 25);
        id.setFont(font);
        frame.add(id);
        
        JLabel PriceLabel = new JLabel("ԭ���");
        PriceLabel.setBounds(120, 135, 125, 25);
        PriceLabel.setFont(font);
        frame.add(PriceLabel);
        
        JLabel Price = new JLabel(String.valueOf(room.getPrice()));
        Price.setBounds(230, 135, 125, 25);
        Price.setFont(font);
        frame.add(Price);
        
        JLabel newPriceLabel = new JLabel("�����");
        newPriceLabel.setBounds(120, 170, 120, 25);
        newPriceLabel.setFont(font);
        frame.add(newPriceLabel);
        
        JTextField newPrice = new JTextField();
        newPrice.setBounds(230, 170, 125, 25);
        newPrice.setFont(font);
        frame.add(newPrice);
        
        JButton cancel = new JButton("����");
        cancel.setBounds(120, 400, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("ȷ��");
        confirm.setBounds(240, 400, 75, 25);
        frame.add(confirm);
        
        frame.add(panel1);
        //ȡ��������ҳ��
        cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new MainFrame();
			}
        	
        });
        
        //ȷ���������ݿ⣬�����ɹ����ڣ�������ҳ��
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Float price = Float.parseFloat(newPrice.getText());
				room.setPrice(price);
				RoomManager rm = new RoomManager();
				try {
					rm.UpdateRoom(room);
					new MainFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
				frame.dispose();
				
			}
        	
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
        
	}
	
}
