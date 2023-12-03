import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class JTableTest extends JFrame implements ActionListener
{
	
	JTable table;
	JScrollPane panel;//�����ű������
	
	JLabel nameLa;//������ǩ
	JTextField nameTxt;//�����ı���
	JButton nameBt;//������ѯ��ť
	
	JLabel deptLa;//Ժϵ��ǩ
	JComboBox deptCom;//Ժϵ������
	JButton deptBt;//Ժϵ��ѯ��ť
	
	JLabel minAgeLa;//��С����
	JTextField minAgeTxt;//��С�����ı���
	JLabel maxAgeLa;//�������
	JTextField maxAgeTxt;//��������ı���
	JButton ageBt;//�����ѯ��ť
	
	JButton delBt;
	JButton upBt;
	JButton addBt;
	
	public void initControl()
	{
		nameLa=new JLabel("����");
		nameLa.setSize(60, 30);
		nameLa.setLocation(30, 30);
		this.add(nameLa);
		nameTxt=new JTextField();
		nameTxt.setSize(120, 30);
		nameTxt.setLocation(100, 30);
		this.add(nameTxt);
		nameBt=new JButton("������ѯ");
		nameBt.setSize(120, 30);
		nameBt.setLocation(250, 30);
		nameBt.addActionListener(this);
		this.add(nameBt);
		
		deptLa=new JLabel("Ժϵ");
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
		deptBt=new JButton("Ժϵ��ѯ");
		deptBt.setSize(120, 30);
		deptBt.setLocation(560, 30);
		deptBt.addActionListener(this);
		this.add(deptBt);
		
		minAgeLa=new JLabel("��С����");
		minAgeLa.setSize(90,30);
		minAgeLa.setLocation(30, 80);
		this.add(minAgeLa);
		minAgeTxt=new JTextField();
		minAgeTxt.setSize(60, 30);
		minAgeTxt.setLocation(120, 80);
		this.add(minAgeTxt);
		maxAgeLa=new JLabel("�������");
		maxAgeLa.setSize(90,30);
		maxAgeLa.setLocation(190, 80);
		this.add(maxAgeLa);
		maxAgeTxt=new JTextField();
		maxAgeTxt.setSize(60, 30);
		maxAgeTxt.setLocation(300, 80);
		this.add(maxAgeTxt);
		ageBt=new JButton("�����ѯ");
		ageBt.setSize(120, 30);
		ageBt.setLocation(380, 80);
		ageBt.addActionListener(this);
		this.add(ageBt);
		
		delBt=new JButton("ɾ��");
		delBt.setSize(60, 30);
		delBt.setLocation(520, 80);
		delBt.addActionListener(this);
		this.add(delBt);
		
		upBt=new JButton("�޸�");
		upBt.setSize(60, 30);
		upBt.setLocation(600, 80);
		upBt.addActionListener(this);
		this.add(upBt);
		
		addBt=new JButton("����");
		addBt.setSize(60, 30);
		addBt.setLocation(680, 80);
		addBt.addActionListener(this);
		this.add(addBt);
	}
	
	public JTableTest()
	{
		this.setSize(800, 600);
		this.setTitle("�����ʾʵ��");
		this.setLayout(null);
		StudentDeal deal=new StudentDeal();
		this.initTable(deal.findAllStus());
		this.initControl();
		this.setVisible(true);
	}
	
	public void initTable(ArrayList list)//���ĳ�ʼ������
	{
		if(panel!=null)//��һ�����Ϊ�գ��ڶ�����岻Ϊ�գ�������
		{
			this.remove(panel);
		}
		String[] titles={"ѧ��","����","�Ա�","����","Ժϵ"};//�����������(��ͷ)
		String[][] values=new String[list.size()][5];//����ֵ����
		for(int i=0;i<list.size();i++)
		{
			Student stu=(Student)list.get(i);
			//��ȡĳ��Ԫ��ת�����ַ�������
			//String[] infos=temp.split(",");
			//�и��ȡ����
			values[i][0]=stu.sno;
			values[i][1]=stu.sname;
			values[i][2]=stu.ssex;
			values[i][3]=String.valueOf(stu.sage);
			values[i][4]=stu.sdept;
		}//ͨ��ѭ������ѯ����ѧ����¼�����洢ֵ�Ķ�ά����
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
		if(bt.getText().equals("������ѯ"))
		{
			StudentDeal deal=new StudentDeal();
			this.initTable(deal.findStusBySname(nameTxt.getText().trim()));
		}
		else
		{
			if(bt.getText().equals("Ժϵ��ѯ"))
			{
				StudentDeal deal=new StudentDeal();
				this.initTable(deal.findStusBySdept(deptCom.getSelectedItem().toString()));
			}
			else
			{
				if(bt.getText().equals("�����ѯ"))
				{
					StudentDeal deal=new StudentDeal();
					this.initTable(deal.findStusBetweenSage(Integer.parseInt(maxAgeTxt.getText().trim()),Integer.parseInt(minAgeTxt.getText().trim())));
				}
				else
				{
					if(bt.getText().equals("�����ѯ"))
					{
						StudentDeal deal=new StudentDeal();
				        this.initTable(deal.findStusBetweenSage(Integer.parseInt(maxAgeTxt.getText().trim()),Integer.parseInt(minAgeTxt.getText().trim())));
					}
					else
					{
						if(bt.getText().equals("ɾ��"))
						{
							StudentDeal deal=new StudentDeal();
							int row=table.getSelectedRow();
							//��ȡѡ����
							if(row==-1)
							{
								JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ����ѧ��");
							}
							else
							{
								String num=table.getValueAt(row, 0).toString();
								deal.deleteStuBySno(num);
								//ɾ�����ݺ�Ҫ���¸��±��
								this.initTable(deal.findAllStus());
							}
						}
						else
						{
							if(bt.getText().equals("�޸�"))
							{
								StudentDeal deal=new StudentDeal();
								int row=table.getSelectedRow();
								//��ȡѡ����
								if(row==-1)
								{
									JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ�ѧ��");
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
