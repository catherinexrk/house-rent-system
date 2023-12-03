import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class JTableTest extends JFrame implements ActionListener
{
	
	JTable table;
	JScrollPane panel;//用来放表格的面板
	
	JLabel nameLa;//姓名标签
	JTextField nameTxt;//姓名文本框
	JButton nameBt;//姓名查询按钮
	
	JLabel deptLa;//院系标签
	JComboBox deptCom;//院系下拉框
	JButton deptBt;//院系查询按钮
	
	JLabel minAgeLa;//最小年龄
	JTextField minAgeTxt;//最小年龄文本框
	JLabel maxAgeLa;//最大年龄
	JTextField maxAgeTxt;//最大年龄文本框
	JButton ageBt;//年龄查询按钮
	
	JButton delBt;
	JButton upBt;
	JButton addBt;
	
	public void initControl()
	{
		nameLa=new JLabel("姓名");
		nameLa.setSize(60, 30);
		nameLa.setLocation(30, 30);
		this.add(nameLa);
		nameTxt=new JTextField();
		nameTxt.setSize(120, 30);
		nameTxt.setLocation(100, 30);
		this.add(nameTxt);
		nameBt=new JButton("姓名查询");
		nameBt.setSize(120, 30);
		nameBt.setLocation(250, 30);
		nameBt.addActionListener(this);
		this.add(nameBt);
		
		deptLa=new JLabel("院系");
		deptLa.setSize(60, 30);
		deptLa.setLocation(420, 30);
		this.add(deptLa);
		deptCom=new JComboBox();
		deptCom.setSize(60, 30);
		deptCom.setLocation(480, 30);
		deptCom.addItem("CS");
		deptCom.addItem("IS");
		deptCom.addItem("MA");
		this.add(deptCom);
		deptBt=new JButton("院系查询");
		deptBt.setSize(120, 30);
		deptBt.setLocation(560, 30);
		deptBt.addActionListener(this);
		this.add(deptBt);
		
		minAgeLa=new JLabel("最小年龄");
		minAgeLa.setSize(90,30);
		minAgeLa.setLocation(30, 80);
		this.add(minAgeLa);
		minAgeTxt=new JTextField();
		minAgeTxt.setSize(60, 30);
		minAgeTxt.setLocation(120, 80);
		this.add(minAgeTxt);
		maxAgeLa=new JLabel("最大年龄");
		maxAgeLa.setSize(90,30);
		maxAgeLa.setLocation(190, 80);
		this.add(maxAgeLa);
		maxAgeTxt=new JTextField();
		maxAgeTxt.setSize(60, 30);
		maxAgeTxt.setLocation(300, 80);
		this.add(maxAgeTxt);
		ageBt=new JButton("年龄查询");
		ageBt.setSize(120, 30);
		ageBt.setLocation(380, 80);
		ageBt.addActionListener(this);
		this.add(ageBt);
		
		delBt=new JButton("删除");
		delBt.setSize(60, 30);
		delBt.setLocation(520, 80);
		delBt.addActionListener(this);
		this.add(delBt);
		
		upBt=new JButton("修改");
		upBt.setSize(60, 30);
		upBt.setLocation(600, 80);
		upBt.addActionListener(this);
		this.add(upBt);
		
		addBt=new JButton("增加");
		addBt.setSize(60, 30);
		addBt.setLocation(680, 80);
		addBt.addActionListener(this);
		this.add(addBt);
	}
	
	public JTableTest()
	{
		this.setSize(800, 600);
		this.setTitle("表格显示实例");
		this.setLayout(null);
		StudentDeal deal=new StudentDeal();
		this.initTable(deal.findAllStus());
		this.initControl();
		this.setVisible(true);
	}
	
	public void initTable(ArrayList list)//表格的初始化操作
	{
		if(panel!=null)//第一次面板为空，第二次面板不为空，清除面板
		{
			this.remove(panel);
		}
		String[] titles={"学号","姓名","性别","年龄","院系"};//定义标题数组(表头)
		String[][] values=new String[list.size()][5];//定义值数组
		for(int i=0;i<list.size();i++)
		{
			Student stu=(Student)list.get(i);
			//获取某个元素转换成字符串对象
			//String[] infos=temp.split(",");
			//切割获取数组
			values[i][0]=stu.sno;
			values[i][1]=stu.sname;
			values[i][2]=stu.ssex;
			values[i][3]=String.valueOf(stu.sage);
			values[i][4]=stu.sdept;
		}//通过循环将查询到的学生记录赋给存储值的二维数组
		table=new JTable(values,titles);
		panel=new JScrollPane(table);
		panel.setSize(800, 500);
		panel.setLocation(0, 150);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton bt=(JButton)e.getSource();
		if(bt.getText().equals("姓名查询"))
		{
			StudentDeal deal=new StudentDeal();
			this.initTable(deal.findStusBySname(nameTxt.getText().trim()));
		}
		else
		{
			if(bt.getText().equals("院系查询"))
			{
				StudentDeal deal=new StudentDeal();
				this.initTable(deal.findStusBySdept(deptCom.getSelectedItem().toString()));
			}
			else
			{
				if(bt.getText().equals("年龄查询"))
				{
					StudentDeal deal=new StudentDeal();
					this.initTable(deal.findStusBetweenSage(Integer.parseInt(maxAgeTxt.getText().trim()),Integer.parseInt(minAgeTxt.getText().trim())));
				}
				else
				{
					if(bt.getText().equals("年龄查询"))
					{
						StudentDeal deal=new StudentDeal();
				        this.initTable(deal.findStusBetweenSage(Integer.parseInt(maxAgeTxt.getText().trim()),Integer.parseInt(minAgeTxt.getText().trim())));
					}
					else
					{
						if(bt.getText().equals("删除"))
						{
							StudentDeal deal=new StudentDeal();
							int row=table.getSelectedRow();
							//获取选中行
							if(row==-1)
							{
								JOptionPane.showMessageDialog(this, "请选中要删除的学生");
							}
							else
							{
								String num=table.getValueAt(row, 0).toString();
								deal.deleteStuBySno(num);
								//删除数据后要重新更新表格
								this.initTable(deal.findAllStus());
							}
						}
						else
						{
							if(bt.getText().equals("修改"))
							{
								StudentDeal deal=new StudentDeal();
								int row=table.getSelectedRow();
								//获取选中行
								if(row==-1)
								{
									JOptionPane.showMessageDialog(this, "请选中要修改的学生");
								}
								else
								{
									String num=table.getValueAt(row, 0).toString();
									UpdateFrame updateFrame=new UpdateFrame(num,this);
								}
							}
							else
							{
								AddFrame addFrame=new AddFrame(this);
							}
						}
					}
				}
				
			}
		}
	}
}
