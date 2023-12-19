package renting.gui.usergui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import renting.bll.MessageManager;
import renting.bll.RoomManager;
import renting.bll.TenantManager;
import renting.bll.entity.Room;
import renting.bll.entity.Tenant;
import renting.gui.RevisePwdFrame;
import renting.gui.SaddMoneyFrame;
import renting.peoplegui.*;
import renting.roomgui.*;


public class UserMainFrame extends JFrame{
    
    public UserMainFrame(Tenant tenant) throws SQLException {
        init(tenant);
    }
    
    
    void init(Tenant tenant) throws SQLException {
    	//����
    	
    	Tenant tenant1 = new TenantManager().GetPeopleAsId(tenant.getId());
        Font Typeface=new Font("����",Font.TYPE1_FONT,20);
        Font Typeface1=new Font("����",Font.TYPE1_FONT,16);
        
        JFrame frame = new JFrame("����");
        frame.setLayout(null);
        frame.setBounds(400, 100, 800, 640);
        
        /*JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Hotel Management\\imgs\\image.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);*/
		
		
        //���
        JTable table = new JTable();
        table.setFont(Typeface1);
        table.setModel(new RoomManager().getMessage());
        table.setBounds(0,300,800,640);
        frame.add(table);
        //table.setOpaque(false);
        
        
        JMenuBar jmenubar = new JMenuBar();
        
        //ϵͳ����
        JMenu Systems = new JMenu("ϵͳ����");
        Systems.setFont(Typeface);
        JMenuItem Refresh = new JMenuItem("ˢ��");
        Refresh.setFont(Typeface);
        JMenuItem mpassword = new JMenuItem("�޸�����");
        mpassword.setFont(Typeface);
        JMenuItem Exit = new JMenuItem("�˳�ϵͳ");
        Exit.setFont(Typeface);
        Systems.add(Refresh);
        Systems.add(mpassword);
        Systems.add(Exit);
           
        jmenubar.add(Systems);
        jmenubar.setBounds(0, 0, 800, 50);
        frame.add(jmenubar);
        
        
        JLabel label = new JLabel("��ӭ");
        label.setBounds(100, 100, 125, 25);
        label.setFont(Typeface);
        frame.add(label);
        
        JLabel name = new JLabel(tenant.getName());
        name.setBounds(100, 150, 125, 25);
        name.setFont(Typeface);
        frame.add(name);
        
        
        
        if(new RoomManager().JudgeRoomID(tenant.getRoom())) {
	        JLabel Label = new JLabel("��ķ���:");
			Label.setBounds(400, 70, 200, 25);
			Label.setFont(Typeface);
			frame.add(Label);
        
        	Room room = new RoomManager().FindRoomAsID(tenant.getRoom());
	        JLabel roomIdLabel = new JLabel("�����:");
			roomIdLabel.setBounds(360, 120, 100, 25);
			roomIdLabel.setFont(Typeface);
			frame.add(roomIdLabel);
	        
			JLabel roomId = new JLabel(String.valueOf(room.getId()));
			roomId.setBounds(450, 120, 100, 25);
			roomId.setFont(Typeface);
			frame.add(roomId);
			
			JLabel GradeLabel = new JLabel("������:");
			GradeLabel.setBounds(360, 155, 100, 25);
			GradeLabel.setFont(Typeface);
			frame.add(GradeLabel);
	        
			JLabel Grade = new JLabel(room.getGrade());
			Grade.setBounds(450, 155, 100, 25);
			Grade.setFont(Typeface);
			frame.add(Grade);
			
			JLabel PriceLabel = new JLabel("�������:");
			PriceLabel.setBounds(360, 190, 100, 25);
			PriceLabel.setFont(Typeface);
			frame.add(PriceLabel);
	        
			JLabel Price = new JLabel(String.valueOf(room.getPrice()));
			Price.setBounds(450, 190, 100, 25);
			Price.setFont(Typeface);
			frame.add(Price);
			
			JButton statement = new JButton("�������");
			statement.setFont(Typeface);
			statement.setBounds(470, 225, 125, 25);
			frame.add(statement);
			statement.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					try {
						new MessageManager().AddMeaasge(tenant.getId(), "1", tenant.getRoom());
						JOptionPane.showMessageDialog(null, "�������Ա����������ȴ�ȷ��", "�������", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
        }
        else {
        	JLabel Label = new JLabel("��û�з���");
			Label.setBounds(420, 120, 200, 25);
			Label.setFont(Typeface);
			frame.add(Label);
			
			JButton rent = new JButton("ȥ�ⷿ");
			rent.setFont(Typeface);
			rent.setBounds(420, 155, 125, 25);
			frame.add(rent);
			
			rent.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					frame.setVisible(false);
					frame.dispose();
					new UserRentingRoom(tenant);
				}
				
			});
        }
        
        
       
      //ˢ��
        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("!!!");
            	table.setModel(new RoomManager().getMessage());
                table.setBounds(0,50,800,640);
            }
            
        }); 
        //�˳�
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        
      //�޸�����
        mpassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new RevisePwdFrame(tenant);
			}
        	
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    /*public static void main(String []args) {
        UserMainFrame frame  = new UserMainFrame();
    }*/
}


