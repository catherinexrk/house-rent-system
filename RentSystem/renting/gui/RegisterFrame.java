package renting.gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import renting.bll.Register;

/*
 * ����Աע�����
 * 
 */
public class RegisterFrame extends JFrame{
	RegisterFrame () {
		init();
	}
	void init() {
            JFrame frame = new JFrame("ע���˺�");
            frame.setLayout(null);
            
            Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,40);
            JLabel title = new JLabel("ע���˺�");
            title.setFont(Typeface);
            title.setBounds(270, 20, 600, 100);
            frame.add(title);
            
            JPanel panel1 = new JPanel();
    		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\1.jpg");
    		JLabel jLabel = new JLabel(i);
    		jLabel.setBounds(0, 0, 800, 640);
    		panel1.add(jLabel);
    		//frame.add(jLabel);
    		panel1.setBounds(0, 0, 800, 640);
    		panel1.setOpaque(false);
            
            JLabel nameStr = new JLabel("�û���:");
            nameStr.setBounds(250, 150, 100, 25);
            frame.add(nameStr);
        
            JLabel IDStr = new JLabel("�˺�:");
            IDStr.setBounds(250, 200, 100, 25);
            frame.add(IDStr);

            JLabel passwordStr = new JLabel("����:");
            passwordStr.setBounds(250, 250, 100, 25);
            frame.add(passwordStr);  
               
            JLabel confrimStr = new JLabel("ȷ������:");
            confrimStr.setBounds(250, 300, 100, 30);
            frame.add(confrimStr);
            
            JTextField userName = new JTextField();
            userName.setBounds(320, 150, 150, 25);
            frame.add(userName);

            JTextField userID = new JTextField();
            userID.setBounds(320, 200, 150, 25);
            frame.add(userID);

            JPasswordField password = new JPasswordField();
            password.setBounds(320, 250, 150, 25);
            frame.add(password);

            JPasswordField confrimPassword = new JPasswordField();
            confrimPassword.setBounds(320, 300, 150, 25);
            frame.add(confrimPassword);
            
            JButton cancel = new JButton("ȡ��");
            cancel.setBounds(280, 350, 70, 25);
            frame.add(cancel);
            
            JButton buttonregister = new JButton("ע��");
            buttonregister.setBounds(400, 350, 70, 25);
            frame.add(buttonregister);
            

            frame.add(panel1);
            frame.setBounds(400, 100, 800, 640);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					RentingFrame rentingframe = new RentingFrame();
					
				}
            	
            });
          //Ϊע�ᰴť���Ӽ�����
            buttonregister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = userName.getText();
                    String ID = userID.getText();
                    String passwd = new String (password.getPassword());
                    String confrimpasswd = new String (confrimPassword.getPassword());
                    
                    //����Register��
                    Register register = new Register();
                    register.setID(ID);
                    register.setName(name);
                    register.setPassword(passwd);
                    register.setconfirmpasswd(confrimpasswd);
                    
                    //���ע��ɹ������ص�¼����
                    try {
						if(register.JudgeRegister()) {

						    frame.setVisible(false);
						    RentingFrame rentingframe = new RentingFrame();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}

                }
                
            });
	}
	public static void main(String []args) {
		new RegisterFrame();
	}
}

