package renting.gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import renting.bll.MessageManager;
import renting.bll.RoomManager;
import renting.historygui.ShowHistory;
import renting.peoplegui.*;
import renting.roomgui.*;


public class MainFrame extends JFrame{
    
    public MainFrame() {
        init();
    }
    
    
    void init() {
    	//����
        Font Typeface=new Font("����",Font.TYPE1_FONT,20);
        Font Typeface1=new Font("����",Font.TYPE1_FONT,16);
        
        JFrame frame = new JFrame("�ⷿ����ϵͳ");
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
        table.setBounds(0,50,800,640);
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
        
        //��������
        JMenu Administration = new JMenu("��������");
        Administration.setFont(Typeface);
        JMenuItem RentingRoom = new JMenuItem("���ⷿ��");
        RentingRoom.setFont(Typeface);
        
        JMenuItem CheckOut = new JMenuItem("�������");
        CheckOut.setFont(Typeface);
        
        Administration.add(RentingRoom);
        Administration.add(CheckOut);
        
        //�������
        JMenu RoomManage = new JMenu("�������");
        RoomManage.setFont(Typeface);
        JMenuItem RoomAdd = new JMenuItem("���ӷ���");
        RoomAdd.setFont(Typeface);
        JMenuItem RoomSelect = new JMenuItem("��ѯ����");
        RoomSelect.setFont(Typeface);
        JMenuItem RoomAddMoney = new JMenuItem("�������");
        RoomAddMoney.setFont(Typeface);
        RoomManage.add(RoomAdd);
        RoomManage.add(RoomSelect);
        RoomManage.add(RoomAddMoney);
        
        //���͹���
        JMenu TenantMange = new JMenu("���͹���");
        TenantMange.setFont(Typeface);
        
        JMenu QueryTenant = new JMenu("��ѯ����");
        JMenuItem AsCard = new JMenuItem("�����֤�Ų�ѯ");
        JMenuItem AsRoomID = new JMenuItem("������Ų�ѯ");
        JMenuItem AsID = new JMenuItem("���˺Ų�ѯ");
        QueryTenant.add(AsCard);
        QueryTenant.add(AsRoomID);
        QueryTenant.add(AsID);
        QueryTenant.setFont(Typeface);
        AsCard.setFont(Typeface);
        AsRoomID.setFont(Typeface);
        AsID.setFont(Typeface);
        
        JMenuItem AddMoney = new JMenuItem("�������");
        AddMoney.setFont(Typeface);
        
        TenantMange.add(AddMoney);
        TenantMange.add(QueryTenant);
        
        //�ɷѼ�¼
        JMenu HistoryManager = new JMenu("�ɷѹ���");
        HistoryManager.setFont(Typeface);
        JMenuItem History = new JMenuItem("�ɷѼ�¼");
        JMenuItem Message = new JMenuItem("�ɷ�����");
        History.setFont(Typeface);
        Message.setFont(Typeface);
        HistoryManager.add(History);
        HistoryManager.add(Message);
        
        //
        jmenubar.add(Systems);
        jmenubar.add(Administration);
        jmenubar.add(RoomManage);
        jmenubar.add(TenantMange);
        jmenubar.add(HistoryManager);
        jmenubar.setBounds(0, 0, 800, 50);
        
        
        frame.add(jmenubar);
       // frame.add(panel1);
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
        
        //���ӷ���
        RoomAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RoomAddFrame raf = new RoomAddFrame();
			}
        });
        
        //ס�޵Ǽ�
        RentingRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new RentingRoomFrame();
			}
        });
        
        //�������
        CheckOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new QueryRoomFrame(3);
				
			}

        });
        
        //��ѯ����
        RoomSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new QueryRoomFrame(1);
			}
        	
        });
        
        //���˺Ų�ѯ�û�
        AsID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new QueryPeopleAsId();
			}
        	
        });
        
        //�����֤�Ų�ѯ�û�
        AsCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new QueryPeopleAsCard();
			}
        	
        });
        //������Ų�ѯ�û�
        AsRoomID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new QueryPeopleAsRoomId();
			}
        	
        });
        
        //�޸�����
        mpassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new RevisePwdFrame(0);
			}
        	
        });
        
        //�Է����������
        AddMoney.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new SaddMoneyFrame();
			}
        	
        });
        
        //�Է����������
        RoomAddMoney.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new QueryRoomFrame(2);
			}
        	
        });
        
        //�ɷѼ�¼
        History.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				try {
					
					new ShowHistory();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	
        });
        
        Message.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(new MessageManager().SelectMessage()) {
						new MessageFrame();
					}
					else {
						JOptionPane.showMessageDialog(null, "��ǰû��������Ҫ����", "��ǰû��������Ҫ����", JOptionPane.INFORMATION_MESSAGE); 
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "��ǰû��������Ҫ����", "��ǰû��������Ҫ����", JOptionPane.INFORMATION_MESSAGE); 
				}
			}
        	
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String []args) {
        MainFrame frame  = new MainFrame();
    }
}

