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
		JFrame frame = new JFrame("查找房间");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("查询房间");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JLabel label = new JLabel("房间号:");
        frame.add(label);
        label.setBounds(130, 120, 75, 25);
        
        JTextField QueryID = new JTextField();
        QueryID.setBounds(180, 120, 150, 25);
        frame.add(QueryID);
        
        JButton cancel = new JButton("取消");
        cancel.setBounds(150, 180, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("确定");
        confirm.setBounds(250, 180, 75, 25);
        frame.add(confirm);
        
        //取消查询
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
        //确定查询
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
						JOptionPane.showMessageDialog(null, "不存在此房间号", "不存在此房间号", JOptionPane.ERROR_MESSAGE);
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
		JFrame frame = new JFrame("增加租金");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("增加租金");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        
        JLabel label = new JLabel("房间号:");
        frame.add(label);
        label.setBounds(130, 120, 75, 25);
        
        JTextField QueryID = new JTextField();
        QueryID.setBounds(180, 120, 150, 25);
        frame.add(QueryID);
        
        JButton cancel = new JButton("取消");
        cancel.setBounds(150, 180, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("确定");
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
        
        
        //取消查询
        cancel.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		frame.dispose();
        		new MainFrame();
        	}
        });
        
        //确定查询
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
						JOptionPane.showMessageDialog(null, "不存在此房间号", "不存在此房间号", JOptionPane.ERROR_MESSAGE);
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
		JFrame frame = new JFrame("结算租金");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("结算租金");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        
        
        JLabel label = new JLabel("房间号:");
        frame.add(label);
        label.setBounds(130, 120, 75, 25);
        
        JTextField QueryID = new JTextField();
        QueryID.setBounds(180, 120, 150, 25);
        frame.add(QueryID);
        
        JButton cancel = new JButton("取消");
        cancel.setBounds(150, 180, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("确定");
        confirm.setBounds(250, 180, 75, 25);
        frame.add(confirm);
        
        //取消查询
        cancel.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		frame.dispose();
        		new MainFrame();
        	}
        });
        
        //确定查询
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
						JOptionPane.showMessageDialog(null, "不存在此房间号", "不存在此房间号", JOptionPane.ERROR_MESSAGE);
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

