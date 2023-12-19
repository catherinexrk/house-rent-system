package renting.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import renting.bll.RevisePwd;
import renting.bll.TenantManager;
import renting.bll.entity.Admin;
import renting.bll.entity.Tenant;
import renting.gui.usergui.UserMainFrame;

public class RevisePwdFrame extends Frame{

	public RevisePwdFrame(int i) {
		init(i);
	}
	
	public RevisePwdFrame(Tenant tenant) {
		init(tenant);
	}
	
	void init(Tenant tenant) {
		
		JFrame frame = new JFrame("�޸�����");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("�޸�����");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\4.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        
        JLabel label = new JLabel("�˺�����:");
        frame.add(label);
        label.setBounds(120, 120, 75, 25);
        
        JComboBox <String> combox = new JComboBox<String>();
        combox.addItem("����Ա�˺�");
        combox.addItem("��ͨ�˺�");
        combox.setBounds(180, 120, 150, 25);
        frame.add(combox);
        
        JLabel idlabel = new JLabel("�˺�:");
        frame.add(idlabel);
        idlabel.setBounds(120, 155, 75, 25);
        
        JTextField ID = new JTextField();
        ID.setBounds(180, 155, 150, 25);
        frame.add(ID);
        
        JLabel pwdlabel = new JLabel("����:");
        frame.add(pwdlabel);
        pwdlabel.setBounds(120, 190, 75, 25);
        
        JTextField pwd = new JTextField();
        pwd.setBounds(180, 190, 150, 25);
        frame.add(pwd);
        
        JLabel rpwdlabel = new JLabel("�޸�����:");
        frame.add(rpwdlabel);
        rpwdlabel.setBounds(120, 225, 75, 25);
        
        JPasswordField rpwd = new JPasswordField();
        rpwd.setBounds(180, 225, 150, 25);
        frame.add(rpwd);
        
        JLabel confirmpwdlabel = new JLabel("ȷ������:");
        frame.add(confirmpwdlabel);
        confirmpwdlabel.setBounds(120, 260, 75, 25);
        
        JPasswordField confirmpwd = new JPasswordField();
        confirmpwd.setBounds(180, 260, 150, 25);
        frame.add(confirmpwd);
        
        JButton cancel = new JButton("ȡ��");
        cancel.setBounds(150, 305, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("ȷ��");
        confirm.setBounds(250, 305, 75, 25);
        frame.add(confirm);
        
        frame.add(panel1);
        
        //ȡ��
        cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
			
				try {
					new UserMainFrame(tenant);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
        	
        });
        
        //ȷ���޸�
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��ȡ�˺�����
				String type = combox.getSelectedItem().toString();
				//System.out.println(type);
				if(type.equals("����Ա�˺�")) {
					System.out.println("!!");
					Admin admin = new Admin();
					admin.setId(ID.getText());
					admin.setPassword(pwd.getText());
					RevisePwd rp = new RevisePwd(admin);
					rp.setModifpwd(String.valueOf(rpwd.getPassword()));
					rp.setConfrimpwd(String.valueOf(confirmpwd.getPassword()));
					try {
						if(rp.UpdateAdmin()) {
							frame.dispose();
							frame.setVisible(false);
							new RentingFrame();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					Tenant tenant = new Tenant();
					tenant.setId(ID.getText());
					tenant.setPassword(pwd.getText());
					RevisePwd rp = new RevisePwd(tenant);
					rp.setModifpwd(String.valueOf(rpwd.getPassword()));
					rp.setConfrimpwd(String.valueOf(confirmpwd.getPassword()));
					try {
						if(rp.UpdateTenant()) {
							frame.dispose();
							frame.setVisible(false);
							new RentingFrame();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
        	
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void init(int i) {
		JFrame frame = new JFrame("�޸�����");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("�޸�����");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JPanel panel1 = new JPanel();
		Icon s = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\4.jpg");
		JLabel jLabel = new JLabel(s);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        
        JLabel label = new JLabel("�˺�����:");
        frame.add(label);
        label.setBounds(120, 120, 75, 25);
        
        JComboBox <String> combox = new JComboBox<String>();
        combox.addItem("����Ա�˺�");
        combox.addItem("��ͨ�˺�");
        combox.setBounds(180, 120, 150, 25);
        frame.add(combox);
        
        JLabel idlabel = new JLabel("�˺�:");
        frame.add(idlabel);
        idlabel.setBounds(120, 155, 75, 25);
        
        JTextField ID = new JTextField();
        ID.setBounds(180, 155, 150, 25);
        frame.add(ID);
        
        JLabel pwdlabel = new JLabel("����:");
        frame.add(pwdlabel);
        pwdlabel.setBounds(120, 190, 75, 25);
        
        JTextField pwd = new JTextField();
        pwd.setBounds(180, 190, 150, 25);
        frame.add(pwd);
        
        JLabel rpwdlabel = new JLabel("�޸�����:");
        frame.add(rpwdlabel);
        rpwdlabel.setBounds(120, 225, 75, 25);
        
        JPasswordField rpwd = new JPasswordField();
        rpwd.setBounds(180, 225, 150, 25);
        frame.add(rpwd);
        
        JLabel confirmpwdlabel = new JLabel("ȷ������:");
        frame.add(confirmpwdlabel);
        confirmpwdlabel.setBounds(120, 260, 75, 25);
        
        JPasswordField confirmpwd = new JPasswordField();
        confirmpwd.setBounds(180, 260, 150, 25);
        frame.add(confirmpwd);
        
        JButton cancel = new JButton("ȡ��");
        cancel.setBounds(150, 305, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("ȷ��");
        confirm.setBounds(250, 305, 75, 25);
        frame.add(confirm);
        
        frame.add(panel1);
        
        //ȡ��
        cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
			
				new MainFrame();
				
			}
        	
        });
        
        //ȷ���޸�
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��ȡ�˺�����
				String type = combox.getSelectedItem().toString();
				//System.out.println(type);
				if(type.equals("����Ա�˺�")) {
					Admin admin = new Admin();
					admin.setId(ID.getText());
					admin.setPassword(pwd.getText());
					RevisePwd rp = new RevisePwd(admin);
					rp.setModifpwd(String.valueOf(rpwd.getPassword()));
					rp.setConfrimpwd(String.valueOf(confirmpwd.getPassword()));
					try {
						if(rp.UpdateAdmin()) {
							frame.dispose();
							frame.setVisible(false);
							new RentingFrame();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					Tenant tenant = new Tenant();
					tenant.setId(ID.getText());
					tenant.setPassword(pwd.getText());
					RevisePwd rp = new RevisePwd(tenant);
					rp.setModifpwd(String.valueOf(rpwd.getPassword()));
					rp.setConfrimpwd(String.valueOf(confirmpwd.getPassword()));
					try {
						if(rp.UpdateTenant()) {
							frame.dispose();
							frame.setVisible(false);
							new RentingFrame();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
        	
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String []args) {
		new RevisePwdFrame(1);
	}
}
