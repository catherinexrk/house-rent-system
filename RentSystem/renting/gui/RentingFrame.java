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
	//登录界面初始化
	public void init() {
	JFrame frame = new JFrame("登录");
        frame.setLayout(null);
        
        Font Typeface=new Font("华文楷体",Font.TYPE1_FONT,80);
        JLabel title = new JLabel("租房管理系统");
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
		
		JLabel label = new JLabel("账号类型:");
        frame.add(label);
        label.setBounds(250, 200, 75, 25);
        
		JComboBox <String> combox = new JComboBox<String>();
        combox.addItem("管理员账号");
        combox.addItem("普通账号");
        combox.setBounds(310, 200, 150, 25);
        frame.add(combox);
		
        JLabel nameStr = new JLabel("账号:");
        nameStr.setBounds(250, 250, 100, 25);
        frame.add(nameStr);
        
        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(250, 300, 100, 25);
        frame.add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setBounds(310, 250, 150, 25);
        frame.add(userID);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(310, 300, 150, 25);
        frame.add(password);
        
        JButton buttonlogin = new JButton("登录");
        buttonlogin.setBounds(275, 350, 70, 25);
        frame.add(buttonlogin);
        
        JButton buttonregister = new JButton("注册");
        buttonregister.setBounds(375, 350, 70, 25);
        frame.add(buttonregister);  
        
        frame.add(panel1);
        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //为登录按钮添加监听器
         buttonlogin.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                
                String type = combox.getSelectedItem().toString();
                //区分不同的账号登录
                if(type.equals("管理员账号")) {
	                //创建一个Admin用户，把输入框中的用户名密码和提出来
	                Admin admin = new Admin();
	                admin.setId(ID);
	                admin.setPassword(passwd);
	                
	                //登录
	                Login login = new Login();
	                login.setAdmin(admin);
	          
	                if(login.JudgeAdmin()==0) {
	                	//弹出账号或密码错误的窗口
	                	JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
	                	//清除密码框中的信息
	                	password.setText("");
	                	//清除账号框中的信息
	                	userID.setText("");
	                	
	                	//System.out.println("登陆失败");
	                } else {
	                	//弹出登录成功的窗口
	                	JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
	                	//点击确定后会跳转到主窗口
	                	frame.setVisible(false);
	                    MainFrame MF = new MainFrame();
	                        
	                }
                }
                else  {
                	//创建一个Tenant用户，把输入框中的用户名密码和提出来
                	Tenant tenant = new Tenant();
                	tenant.setId(ID);
                	tenant.setPassword(passwd);
                	
	                //登录
	                Login login = new Login();
	                login.setTenant(tenant);
	          
	                if(login.JudgeTenant()==0) {
	                	//弹出账号或密码错误的窗口
	                	JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
	                	//清除密码框中的信息
	                	password.setText("");
	                	//清除账号框中的信息
	                	userID.setText("");
	                	
	                	//System.out.println("登陆失败");
	                } else {
	                	//弹出登录成功的窗口
	                	JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
	                	//点击确定后会跳转到主窗口
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
         
         //为注册按钮添加监听器
         buttonregister.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 //注册页面
                 frame.setVisible(false);
        		 RegisterFrame ar = new RegisterFrame(); 
        	 }
         });
	}
	
    public static void main(String []args) { 
       //主程序
       //登录窗口
        RentingFrame renting = new RentingFrame();
    }
}


