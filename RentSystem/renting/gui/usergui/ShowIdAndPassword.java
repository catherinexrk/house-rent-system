package renting.gui.usergui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import renting.bll.entity.Tenant;
import renting.gui.MainFrame;

public class ShowIdAndPassword extends Frame{
	public ShowIdAndPassword(Tenant tenant) {
		init(tenant);
	}
	void init(Tenant tenant) {
		JFrame frame = new JFrame("房主信息");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 500);
		
		Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,40);
		Font font=new Font("华文楷体",Font.TYPE1_FONT,18);
        JLabel title = new JLabel("自动生成账号密码");
        title.setFont(Typeface);
        title.setBounds(50, 0, 600, 100);
        frame.add(title);
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\7.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        
        JLabel idLabel = new JLabel("账号：");
        idLabel.setBounds(120, 100, 75, 25);
        idLabel.setFont(font);
        frame.add(idLabel);
        
        JLabel id = new JLabel(tenant.getId());
        id.setBounds(210, 100, 125, 25);
        id.setFont(font);
        frame.add(id);
        
        JLabel passwdLabel = new JLabel("密码：");
        passwdLabel.setBounds(120, 135, 75, 25);
        passwdLabel.setFont(font);
        frame.add(passwdLabel);
        
        JLabel passwd = new JLabel(tenant.getPassword());
        passwd.setBounds(210, 135, 125, 25);
        passwd.setFont(font);
        frame.add(passwd);
        
        
        JButton cancel = new JButton("返回");
        cancel.setBounds(130, 190, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("确定");
        confirm.setBounds(240, 190, 75, 25);
        frame.add(confirm);
        
        frame.add(panel1);
        
        cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new MainFrame();
			}
        	
        });
        
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new confirmUser(tenant);
			}
        	
        	
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
}
