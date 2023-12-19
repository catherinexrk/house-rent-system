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
    	//字体
        Font Typeface=new Font("宋体",Font.TYPE1_FONT,20);
        Font Typeface1=new Font("宋体",Font.TYPE1_FONT,16);
        
        JFrame frame = new JFrame("租房管理系统");
        frame.setLayout(null);
        frame.setBounds(400, 100, 800, 640);
        
        /*JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Hotel Management\\imgs\\image.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);*/
		
		
        //表格
        JTable table = new JTable();
        table.setFont(Typeface1);
        table.setModel(new RoomManager().getMessage());
        table.setBounds(0,50,800,640);
        frame.add(table);
        //table.setOpaque(false);
        
        
        JMenuBar jmenubar = new JMenuBar();
        
        //系统管理
        JMenu Systems = new JMenu("系统管理");
        Systems.setFont(Typeface);
        JMenuItem Refresh = new JMenuItem("刷新");
        Refresh.setFont(Typeface);
        JMenuItem mpassword = new JMenuItem("修改密码");
        mpassword.setFont(Typeface);
        JMenuItem Exit = new JMenuItem("退出系统");
        Exit.setFont(Typeface);
        Systems.add(Refresh);
        Systems.add(mpassword);
        Systems.add(Exit);
        
        //基本管理
        JMenu Administration = new JMenu("基本管理");
        Administration.setFont(Typeface);
        JMenuItem RentingRoom = new JMenuItem("出租房间");
        RentingRoom.setFont(Typeface);
        
        JMenuItem CheckOut = new JMenuItem("结算租金");
        CheckOut.setFont(Typeface);
        
        Administration.add(RentingRoom);
        Administration.add(CheckOut);
        
        //房间管理
        JMenu RoomManage = new JMenu("房间管理");
        RoomManage.setFont(Typeface);
        JMenuItem RoomAdd = new JMenuItem("增加房间");
        RoomAdd.setFont(Typeface);
        JMenuItem RoomSelect = new JMenuItem("查询房间");
        RoomSelect.setFont(Typeface);
        JMenuItem RoomAddMoney = new JMenuItem("增加租金");
        RoomAddMoney.setFont(Typeface);
        RoomManage.add(RoomAdd);
        RoomManage.add(RoomSelect);
        RoomManage.add(RoomAddMoney);
        
        //房客管理
        JMenu TenantMange = new JMenu("房客管理");
        TenantMange.setFont(Typeface);
        
        JMenu QueryTenant = new JMenu("查询房客");
        JMenuItem AsCard = new JMenuItem("按身份证号查询");
        JMenuItem AsRoomID = new JMenuItem("按房间号查询");
        JMenuItem AsID = new JMenuItem("按账号查询");
        QueryTenant.add(AsCard);
        QueryTenant.add(AsRoomID);
        QueryTenant.add(AsID);
        QueryTenant.setFont(Typeface);
        AsCard.setFont(Typeface);
        AsRoomID.setFont(Typeface);
        AsID.setFont(Typeface);
        
        JMenuItem AddMoney = new JMenuItem("增加租金");
        AddMoney.setFont(Typeface);
        
        TenantMange.add(AddMoney);
        TenantMange.add(QueryTenant);
        
        //缴费记录
        JMenu HistoryManager = new JMenu("缴费管理");
        HistoryManager.setFont(Typeface);
        JMenuItem History = new JMenuItem("缴费记录");
        JMenuItem Message = new JMenuItem("缴费申请");
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
        //刷新
        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("!!!");
            	table.setModel(new RoomManager().getMessage());
                table.setBounds(0,50,800,640);
            }
            
        }); 
        //退出
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        
        //增加房间
        RoomAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RoomAddFrame raf = new RoomAddFrame();
			}
        });
        
        //住宿登记
        RentingRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new RentingRoomFrame();
			}
        });
        
        //结算租金
        CheckOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new QueryRoomFrame(3);
				
			}

        });
        
        //查询房间
        RoomSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new QueryRoomFrame(1);
			}
        	
        });
        
        //按账号查询用户
        AsID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new QueryPeopleAsId();
			}
        	
        });
        
        //按身份证号查询用户
        AsCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new QueryPeopleAsCard();
			}
        	
        });
        //按房间号查询用户
        AsRoomID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				frame.setVisible(false);
				new QueryPeopleAsRoomId();
			}
        	
        });
        
        //修改密码
        mpassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new RevisePwdFrame(0);
			}
        	
        });
        
        //对房客增加租金
        AddMoney.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new SaddMoneyFrame();
			}
        	
        });
        
        //对房间增加租金
        RoomAddMoney.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				new QueryRoomFrame(2);
			}
        	
        });
        
        //缴费记录
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
						JOptionPane.showMessageDialog(null, "当前没有申请需要处理！", "当前没有申请需要处理", JOptionPane.INFORMATION_MESSAGE); 
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "当前没有申请需要处理！", "当前没有申请需要处理", JOptionPane.INFORMATION_MESSAGE); 
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

