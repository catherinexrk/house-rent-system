package renting.roomgui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import renting.bll.entity.Tenant;
import renting.bll.people.TenantAdd;
import renting.gui.MainFrame;
import renting.gui.usergui.ShowIdAndPassword;
import renting.gui.usergui.confirmUser;

public class RentingRoomFrame extends Frame{
	public RentingRoomFrame() {
		init();
	}
	void init() {
		JFrame frame = new JFrame("出租房间");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 500);
		
		Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,40);
		Font font=new Font("华文楷体",Font.TYPE1_FONT,18);
        JLabel title = new JLabel("出租房间");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JLabel cardLabel = new JLabel("身份证号：");
        cardLabel.setBounds(120, 100, 100, 25);
        cardLabel.setFont(font);
        frame.add(cardLabel);
        
        JTextField card = new JTextField();
        card.setBounds(210, 100, 120, 25);
        card.setFont(font);
        frame.add(card);
        
        JLabel RoomIdLabel = new JLabel("房间号：");
        RoomIdLabel.setBounds(120, 135, 100, 25);
        RoomIdLabel.setFont(font);
        frame.add(RoomIdLabel);
        
        JTextField RoomId = new JTextField();
        RoomId.setBounds(210, 135, 120, 25);
        RoomId.setFont(font);
        frame.add(RoomId);
        
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(120, 170, 75, 25);
        nameLabel.setFont(font);
        frame.add(nameLabel);
        
        JTextField name = new JTextField();
        name.setBounds(210, 170, 120, 25);
        name.setFont(font);
        frame.add(name);
        
        JLabel sexLabel = new JLabel("性别：");
        sexLabel.setBounds(120, 205, 75, 25);
        sexLabel.setFont(font);
        frame.add(sexLabel);
        
        JComboBox <String> combox = new JComboBox<String>();
        combox.addItem("男");
        combox.addItem("女");
        combox.setBounds(210, 205, 120, 25);
        frame.add(combox);
        combox.setFont(font);
        
        JLabel htLabel = new JLabel("籍贯：");
        htLabel.setBounds(120, 240, 100, 25);
        htLabel.setFont(font);
        frame.add(htLabel);
        
       
  
        JComboBox <String> combox1 = new JComboBox<String>();
        String []args={"北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古自治区", "广西壮族自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区"};
        for(int i=0; i<34; i++)
        	combox1.addItem(args[i]);
        combox1.setBounds(210, 240, 120, 25);
        frame.add(combox1);
        combox1.setFont(font);
        
        JButton cancel = new JButton("返回");
        cancel.setBounds(130, 275, 75, 25);
        frame.add(cancel);
        
        JButton confrim = new JButton("确定");
        confrim.setBounds(230, 275, 75, 25);
        frame.add(confrim);
        
        cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new MainFrame();
			}
        	
        });
        
        //确定
        confrim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Tenant tenant = new Tenant();
				tenant.setCard(card.getText());
				tenant.setName(name.getText());
				tenant.setRoom(Integer.parseInt(RoomId.getText()));
				tenant.setHometown(combox1.getSelectedItem().toString());
				tenant.setSex(combox.getSelectedItem().toString());
				
				TenantAdd ta = new TenantAdd(tenant);
				
				if(ta.add()==1) {
					frame.setVisible(false);
					frame.dispose();
					new confirmUser(ta.getTenant());
				}
				else if(ta.add()==2) {
					frame.setVisible(false);
					frame.dispose();
					new ShowIdAndPassword(ta.getTenant());
				}
			}
        	
        });
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\15.jpg");
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
	
	public static void mian(String []args) {
		new RentingRoomFrame();
	}
}
