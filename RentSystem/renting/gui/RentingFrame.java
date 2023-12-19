package renting.gui;
/*


*/
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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

import renting.bll.Login;
import renting.bll.TenantManager;
import renting.bll.entity.Admin;
import renting.bll.entity.Tenant;
import renting.gui.usergui.UserMainFrame;


public class RentingFrame extends JFrame{    
	
	
	public RentingFrame() {
		init();
	}
	//��¼�����ʼ��
	public void init() {
	JFrame frame = new JFrame("��¼");
        frame.setLayout(null);
        
        Font Typeface=new Font("���Ŀ���",Font.TYPE1_FONT,80);
        JLabel title = new JLabel("�ⷿ����ϵͳ");
        title.setFont(Typeface);
        title.setBounds(120, 20, 600, 200);
        frame.add(title);
        
		JPanel panel1 = new JPanel();
		Icon i = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\RentingSystem\\src\\renting\\imgs\\2.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 800, 640);
		panel1.add(jLabel);
		//frame.add(jLabel);
		panel1.setBounds(0, 0, 800, 640);
		panel1.setOpaque(false);
		
		JLabel label = new JLabel("�˺�����:");
        frame.add(label);
        label.setBounds(250, 200, 75, 25);
        
		JComboBox <String> combox = new JComboBox<String>();
        combox.addItem("����Ա�˺�");
        combox.addItem("��ͨ�˺�");
        combox.setBounds(310, 200, 150, 25);
        frame.add(combox);
		
        JLabel nameStr = new JLabel("�˺�:");
        nameStr.setBounds(250, 250, 100, 25);
        frame.add(nameStr);
        
        JLabel passwordStr = new JLabel("����:");
        passwordStr.setBounds(250, 300, 100, 25);
        frame.add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setBounds(310, 250, 150, 25);
        frame.add(userID);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(310, 300, 150, 25);
        frame.add(password);
        
        JButton buttonlogin = new JButton("��¼");
        buttonlogin.setBounds(275, 350, 70, 25);
        frame.add(buttonlogin);
        
        JButton buttonregister = new JButton("ע��");
        buttonregister.setBounds(375, 350, 70, 25);
        frame.add(buttonregister);  
        
        frame.add(panel1);
        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //Ϊ��¼��ť��Ӽ�����
         buttonlogin.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                
                String type = combox.getSelectedItem().toString();
                //���ֲ�ͬ���˺ŵ�¼
                if(type.equals("����Ա�˺�")) {
	                //����һ��Admin�û�����������е��û�������������
	                Admin admin = new Admin();
	                admin.setId(ID);
	                admin.setPassword(passwd);
	                
	                //��¼
	                Login login = new Login();
	                login.setAdmin(admin);
	          
	                if(login.JudgeAdmin()==0) {
	                	//�����˺Ż��������Ĵ���
	                	JOptionPane.showMessageDialog(null, "�˺Ż��������", "�˺Ż��������", JOptionPane.WARNING_MESSAGE);
	                	//���������е���Ϣ
	                	password.setText("");
	                	//����˺ſ��е���Ϣ
	                	userID.setText("");
	                	
	                	//System.out.println("��½ʧ��");
	                } else {
	                	//������¼�ɹ��Ĵ���
	                	JOptionPane.showMessageDialog(null, "��½�ɹ�", "��½�ɹ�", JOptionPane.NO_OPTION);
	                	//���ȷ�������ת��������
	                	frame.setVisible(false);
	                    MainFrame MF = new MainFrame();
	                        
	                }
                }
                else  {
                	//����һ��Tenant�û�����������е��û�������������
                	Tenant tenant = new Tenant();
                	tenant.setId(ID);
                	tenant.setPassword(passwd);
                	
	                //��¼
	                Login login = new Login();
	                login.setTenant(tenant);
	          
	                if(login.JudgeTenant()==0) {
	                	//�����˺Ż��������Ĵ���
	                	JOptionPane.showMessageDialog(null, "�˺Ż��������", "�˺Ż��������", JOptionPane.WARNING_MESSAGE);
	                	//���������е���Ϣ
	                	password.setText("");
	                	//����˺ſ��е���Ϣ
	                	userID.setText("");
	                	
	                	//System.out.println("��½ʧ��");
	                } else {
	                	//������¼�ɹ��Ĵ���
	                	JOptionPane.showMessageDialog(null, "��½�ɹ�", "��½�ɹ�", JOptionPane.NO_OPTION);
	                	//���ȷ�������ת��������
	                	frame.setVisible(false);
	                	try {
							tenant = new TenantManager().GetPeopleAsId(ID);
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
	                    try {
							UserMainFrame UMF = new UserMainFrame(tenant);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                        
	                }
                }
            }
        });
         
         //Ϊע�ᰴť��Ӽ�����
         buttonregister.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 //ע��ҳ��
                 frame.setVisible(false);
        		 RegisterFrame ar = new RegisterFrame(); 
        	 }
         });
	}
	
    public static void main(String []args) { 
       //������
       //��¼����
        RentingFrame renting = new RentingFrame();
    }
}


