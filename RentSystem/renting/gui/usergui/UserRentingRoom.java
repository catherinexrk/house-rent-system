package renting.gui.usergui;

import java.awt.Font;
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
import javax.swing.JTextField;

import renting.bll.RoomManager;
import renting.bll.entity.Tenant;
import renting.gui.MainFrame;
import renting.roomgui.ShowRoomMessageFrame;

public class UserRentingRoom {

	UserRentingRoom(Tenant tenant) {
		init(tenant);
	}
	void init(Tenant tenant) {
		JFrame frame = new JFrame("选择房间");
		frame.setLayout(null);
		frame.setBounds(500, 200, 500, 400);
		
		Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,40);
        JLabel title = new JLabel("选择房间");
        title.setFont(Typeface);
        title.setBounds(150, 0, 600, 100);
        frame.add(title);
        
        JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\8.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
        
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
        frame.add(panel1);
        
        //取消选择
        cancel.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
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
        
        //确定选择
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RoomManager rm = new RoomManager();
				int ID = Integer.parseInt(QueryID.getText());
				try {
					if(rm.JudgeRoomID(ID)) {
						if(rm.JudgeRoomHasTenantAsID(ID)) {
							JOptionPane.showMessageDialog(null, "租房成功！", "租房成功", JOptionPane.INFORMATION_MESSAGE);
							rm.UpdateRoomAndTenant(tenant, ID);
						}
						else {
							JOptionPane.showMessageDialog(null, "此房间已有人租", "此房间已有人租", JOptionPane.ERROR_MESSAGE);
						}
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
}
