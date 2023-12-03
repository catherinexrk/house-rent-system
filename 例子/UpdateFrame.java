import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateFrame extends JFrame implements ActionListener
{
	JLabel nameLa,numLa,sexLa,ageLa,deptLa;
	JTextField nameTxt,numTxt,ageTxt;
	JComboBox sexCom,deptCom;
	JButton bt;
	
	JTableTest main;
	
	public UpdateFrame(String num,JTableTest main)
	{
		this.setSize(300, 370);
		this.setTitle("修改学生数据");
		this.setLayout(null);
		this.init(num);
		this.setVisible(true);
		this.main=main;
	}
	
	private void init(String num)
	{
		StudentDeal deal=new StudentDeal();
		Student stu=deal.findBySno(num);
		numLa=new JLabel("学号");
		numLa.setSize(60, 30);
		numLa.setLocation(30,30);
		this.add(numLa);
		numTxt=new JTextField();
		numTxt.setSize(120, 30);
		numTxt.setLocation(100,30);
		numTxt.setEnabled(false);
		numTxt.setText(stu.sno);
		this.add(numTxt);
		
		nameLa=new JLabel("姓名");
		nameLa.setSize(60, 30);
		nameLa.setLocation(30,80);
		this.add(nameLa);
		nameTxt=new JTextField();
		nameTxt.setSize(120, 30);
		nameTxt.setLocation(100,80);
		nameTxt.setText(stu.sname);
		this.add(nameTxt);
		
		sexLa=new JLabel("性别");
		sexLa.setSize(60, 30);
		sexLa.setLocation(30,130);
		this.add(sexLa);
		sexCom=new JComboBox();
		sexCom.setSize(120, 30);
		sexCom.setLocation(100,130);
		sexCom.addItem("男");
		sexCom.addItem("女");
		sexCom.setSelectedItem(stu.ssex);
		this.add(sexCom);
		
		ageLa=new JLabel("年龄");
		ageLa.setSize(60, 30);
		ageLa.setLocation(30,180);
		this.add(ageLa);
		ageTxt=new JTextField();
		ageTxt.setSize(120, 30);
		ageTxt.setLocation(100,180);
		ageTxt.setText(String.valueOf(stu.sage));
		this.add(ageTxt);
		
		deptLa=new JLabel("院系");
		deptLa.setSize(60, 30);
		deptLa.setLocation(30,230);
		this.add(deptLa);
		deptCom=new JComboBox();
		deptCom.setSize(120, 30);
		deptCom.setLocation(100,230);
		deptCom.addItem("CS");
		deptCom.addItem("IS");
		deptCom.addItem("MA");
		deptCom.setSelectedItem(stu.sdept);
		this.add(deptCom);
		
		bt=new JButton("修改");
		bt.setSize(60, 30);
		bt.setLocation(160,280);
		bt.addActionListener(this);
		this.add(bt);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		StudentDeal deal=new StudentDeal();
		String num=numTxt.getText().trim();
		String name=nameTxt.getText().trim();
		String sex=sexCom.getSelectedItem().toString();
		short age=Short.parseShort(ageTxt.getText().trim());
		String dept=deptCom.getSelectedItem().toString();
		Student stu=new Student(num,name,sex,age,dept);
		deal.updateStu(stu);
		main.initTable(deal.findAllStus());
		this.dispose();
	}
}
