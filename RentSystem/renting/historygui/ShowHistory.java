package renting.historygui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.TableModel;

import renting.bll.HistoryManager;
import renting.gui.MainFrame;

public class ShowHistory extends JFrame{

	public ShowHistory() throws SQLException {
		init();
	}
	void init() throws SQLException {
		 Font Typeface=new Font("����",Font.TYPE1_FONT,20);
	        Font Typeface1=new Font("����",Font.TYPE1_FONT,16);
	        
	        JFrame frame = new JFrame("��ʷ��¼");
	        frame.setLayout(null);
	        frame.setBounds(400, 100, 800, 640);
	        //���
	        JTable table = new JTable();
	        table.setFont(Typeface1);
	        table.setModel(new HistoryManager().getMessage());
	        table.setBounds(0,5,800,480);
	        frame.add(table);
	        
	        JButton cancel = new JButton("����");
	        cancel.setBounds(310, 550, 90, 30);
	        frame.add(cancel);
	        cancel.setFont(Typeface);
	        cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					frame.setVisible(false);
	        		frame.dispose();
	        		new MainFrame();
				}
	        	
	        });
	        //table.setOpaque(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	
	/*public void main(String []args) throws SQLException {
		new ShowHistory();
	}*/
}
