package renting.peoplegui;

/*
 * �����֤���ҷ���ͼ�λ�����
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import renting.bll.RoomManager;
import renting.bll.TenantManager;
import renting.gui.MainFrame;


public class QueryPeopleAsCard extends Frame{
	
	public QueryPeopleAsCard() {
		init();
	}
	void init() {
		JFrame frame = new JFrame("�����֤����");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("��ѯ����");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\9.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        
        JLabel label = new JLabel("���֤��:");
        frame.add(label);
        label.setBounds(120, 120, 75, 25);
        
        JTextField QueryID = new JTextField();
        QueryID.setBounds(180, 120, 150, 25);
        frame.add(QueryID);
        
        JButton cancel = new JButton("ȡ��");
        cancel.setBounds(150, 180, 75, 25);
        frame.add(cancel);
        
        JButton confirm = new JButton("ȷ��");
        confirm.setBounds(250, 180, 75, 25);
        frame.add(confirm);
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
				TenantManager tm = new TenantManager();
				String ID = QueryID.getText();
				if(!ID.equals("")) {
					try {
						if(tm.QueryPeopleAsCard(ID)) {
							frame.setVisible(false);
							frame.dispose();
							new ShowPeopleMessageFrame(tm.getTenant());
						}
						else {
							JOptionPane.showMessageDialog(null, "�����ڴ���", "�����ڴ���", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
				}
				
			}
        	
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String []args) {
		new QueryPeopleAsCard();
	}
}

