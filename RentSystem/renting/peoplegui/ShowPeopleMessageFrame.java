package renting.peoplegui;

/*
 * 显示房客信息窗口
 * 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import renting.bll.entity.Tenant;
import renting.gui.MainFrame;

public class ShowPeopleMessageFrame extends Frame{
	private Tenant tenant = new Tenant();
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public ShowPeopleMessageFrame(Tenant tenant){
		init(tenant);
	}
	
	void init(Tenant tenant) {
		JFrame frame = new JFrame("房主信息");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 500);
		
		Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,40);
		Font font=new Font("华文楷体",Font.TYPE1_FONT,18);
        JLabel title = new JLabel("房主信息");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\12.jpg");
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
        id.setBounds(210, 100, 75, 25);
        id.setFont(font);
        frame.add(id);
        
        JLabel passwdLabel = new JLabel("密码：");
        passwdLabel.setBounds(120, 135, 75, 25);
        passwdLabel.setFont(font);
        frame.add(passwdLabel);
        
        JLabel passwd = new JLabel(tenant.getPassword());
        passwd.setBounds(210, 135, 75, 25);
        passwd.setFont(font);
        frame.add(passwd);
        
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(120, 170, 75, 25);
        nameLabel.setFont(font);
        frame.add(nameLabel);
        
        JLabel name = new JLabel(tenant.getName());
        name.setBounds(210, 170, 75, 25);
        name.setFont(font);
        frame.add(name);
        
        JLabel cardLabel = new JLabel("身份证号：");
        cardLabel.setBounds(120, 205, 100, 25);
        cardLabel.setFont(font);
        frame.add(cardLabel);
        
        JLabel card = new JLabel(tenant.getCard());
        card.setBounds(210, 205, 100, 25);
        card.setFont(font);
        frame.add(card);
        
        JLabel roomLabel = new JLabel("房间号：");
        roomLabel.setBounds(120, 240, 100, 25);
        roomLabel.setFont(font);
        frame.add(roomLabel);
        
        JLabel room = new JLabel(String.valueOf((tenant.getRoom())));
        room.setBounds(210, 240, 75, 25);
        room.setFont(font);
        frame.add(room);
        
        JLabel timeLabel = new JLabel("租房时间：");
        timeLabel.setBounds(120, 275, 100, 25);
        timeLabel.setFont(font);
        frame.add(timeLabel);
        
        Date date = tenant.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        JLabel time = new JLabel(dateStr);
        time.setBounds(210, 275, 200, 25);
        time.setFont(font);
        frame.add(time);
        
        JLabel sexLabel = new JLabel("性别：");
        sexLabel.setBounds(120, 310, 75, 25);
        sexLabel.setFont(font);
        frame.add(sexLabel);
        
        JLabel sex = new JLabel(tenant.getSex());
        sex.setBounds(210, 310, 75, 25);
        sex.setFont(font);
        frame.add(sex);
        
        JLabel htLabel = new JLabel("籍贯：");
        htLabel.setBounds(120, 340, 100, 25);
        htLabel.setFont(font);
        frame.add(htLabel);
        
        JLabel ht = new JLabel(tenant.getHometown());
        ht.setBounds(210, 340, 100, 25);
        ht.setFont(font);
        frame.add(ht);
        
        JButton cancel = new JButton("返回");
        cancel.setBounds(190, 400, 75, 25);
        frame.add(cancel);
        
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
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	/*public static void main(String []args) {
		Tenant tenant1 = new Tenant("123", "123", "123", "123", 101, (float) 110,(2019-12-10), "20", "2010");
		new ShowPeopleMessageFrame(tenant1);
	}*/
	
}
