package renting.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import renting.bll.MessageManager;
import renting.bll.TenantManager;
import renting.bll.entity.Message;
import renting.bll.entity.Tenant;

public class MessageFrame extends Frame{
	
	MessageFrame() throws SQLException {
		init();
	}
	void init() throws SQLException {
		JFrame frame = new JFrame("请求");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 500);
		

        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\3.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
		
		Message me = new MessageManager().getMessage();
		
		Tenant tenant = new TenantManager().GetPeopleAsId(me.getFrom());	
		
		Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,40);
		Font font=new Font("华文楷体",Font.TYPE1_FONT,18);
        JLabel title = new JLabel("缴费请求");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(120, 170, 75, 25);
        nameLabel.setFont(font);
        frame.add(nameLabel);
        
        JLabel name = new JLabel(tenant.getName());
        name.setBounds(210, 170, 75, 25);
        name.setFont(font);
        frame.add(name);
      
        
        JLabel roomLabel = new JLabel("房间号：");
        roomLabel.setBounds(120, 240, 100, 25);
        roomLabel.setFont(font);
        frame.add(roomLabel);
        
        JLabel room = new JLabel(String.valueOf((tenant.getRoom())));
        room.setBounds(210, 240, 75, 25);
        room.setFont(font);
        frame.add(room);
        
        JButton cancel = new JButton("返回");
        cancel.setBounds(100, 400, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("确定");
        confirm.setBounds(300, 400, 75, 25);
        frame.add(confirm);
        
        JButton no = new JButton("拒绝");
        no.setBounds(200, 400, 75, 25);
        frame.add(no);
        
        frame.add(panel1);
        
        cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				
			}
        	
        });
        
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "成功缴费！", "成功缴费", JOptionPane.INFORMATION_MESSAGE); 
				try {
					new MessageManager().DeleteMessage(me);
					new TenantManager().UpdateSett(tenant.getId());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
			}
        	
        });
        
        no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "已拒绝！", "已拒绝", JOptionPane.INFORMATION_MESSAGE); 
				try {
					new MessageManager().DeleteMessage(me);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
        	
        });
        
        frame.setVisible(true);
	}
	
	public static void main(String []args) throws SQLException {
		new MessageFrame();
	}
}
