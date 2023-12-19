package renting.roomgui;

/*
 * 
 * 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import renting.bll.RoomManager;
import renting.bll.TenantManager;
import renting.bll.entity.Room;
import renting.bll.entity.Tenant;
import renting.gui.MainFrame;

public class QueryRoomFrame extends Frame{
	
	public QueryRoomFrame(int i) {
		if(i==1) {
			init1();
		}
		if(i==2) {
			init2();
		}
		if(i==3)
			init3();
	}
	void init1() {
		JFrame frame = new JFrame("���ҷ���");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("��ѯ����");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JLabel label = new JLabel("�����:");
        frame.add(label);
        label.setBounds(130, 120, 75, 25);
        
        JTextField QueryID = new JTextField();
        QueryID.setBounds(180, 120, 150, 25);
        frame.add(QueryID);
        
        JButton cancel = new JButton("ȡ��");
        cancel.setBounds(150, 180, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("ȷ��");
        confirm.setBounds(250, 180, 75, 25);
        frame.add(confirm);
        
        //ȡ����ѯ
        cancel.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		frame.dispose();
        		new MainFrame();
        	}
        });
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\14.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        frame.add(panel1);
        //ȷ����ѯ
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RoomManager rm = new RoomManager();
				int ID = Integer.parseInt(QueryID.getText());
				try {
					if(rm.JudgeRoomID(ID)) {
						frame.setVisible(false);
						new ShowRoomMessageFrame(ID);
					}
					else {
						JOptionPane.showMessageDialog(null, "�����ڴ˷����", "�����ڴ˷����", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
        	
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	void init2() {
		JFrame frame = new JFrame("�������");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("�������");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        
        JLabel label = new JLabel("�����:");
        frame.add(label);
        label.setBounds(130, 120, 75, 25);
        
        JTextField QueryID = new JTextField();
        QueryID.setBounds(180, 120, 150, 25);
        frame.add(QueryID);
        
        JButton cancel = new JButton("ȡ��");
        cancel.setBounds(150, 180, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("ȷ��");
        confirm.setBounds(250, 180, 75, 25);
        frame.add(confirm);
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\14.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        frame.add(panel1);
        
        
        //ȡ����ѯ
        cancel.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		frame.dispose();
        		new MainFrame();
        	}
        });
        
        //ȷ����ѯ
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RoomManager rm = new RoomManager();
				int ID = Integer.parseInt(QueryID.getText());
				try {
					if(rm.JudgeRoomID(ID)) {
						frame.setVisible(false);
						TenantManager tm = new TenantManager();
						Tenant tenant = tm.GetPeopleAsRoomId(ID);
						
						new ShowRoomMessageFrame(tenant);
					}
					else {
						JOptionPane.showMessageDialog(null, "�����ڴ˷����", "�����ڴ˷����", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
        	
        });
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	void init3() {
		JFrame frame = new JFrame("�������");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("�������");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        
        
        JLabel label = new JLabel("�����:");
        frame.add(label);
        label.setBounds(130, 120, 75, 25);
        
        JTextField QueryID = new JTextField();
        QueryID.setBounds(180, 120, 150, 25);
        frame.add(QueryID);
        
        JButton cancel = new JButton("ȡ��");
        cancel.setBounds(150, 180, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("ȷ��");
        confirm.setBounds(250, 180, 75, 25);
        frame.add(confirm);
        
        //ȡ����ѯ
        cancel.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		frame.dispose();
        		new MainFrame();
        	}
        });
        
        //ȷ����ѯ
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RoomManager rm = new RoomManager();
				int ID = Integer.parseInt(QueryID.getText());
				try {
					if(rm.JudgeRoomID(ID)) {
						frame.setVisible(false);
						new settlementMoneyFrame(ID);
					}
					else {
						JOptionPane.showMessageDialog(null, "�����ڴ˷����", "�����ڴ˷����", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
        	
        });
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\14.jpg");
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
		new QueryRoomFrame(1);
	}
}

