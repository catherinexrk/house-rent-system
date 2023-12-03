import java.sql.*;
import java.util.*;

/**
 * �������ݿ��е�ѧ����
 * @author lenovo
 *
 */
public class StudentDeal 
{
	private Connection con;
	private PreparedStatement ps;
	private Statement st;
	
	public StudentDeal()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//��������
			String conStr="jdbc:sqlserver://localhost:1433; DatabaseName=student_course";
			String user="sa";//��������Ա�û�,ӵ�ж����������ݶ�������в���Ȩ��
			String password="sa123";
			con=DriverManager.getConnection(conStr,user,password);
			//������������ķ������������ݿ����Ӷ���
		}
		catch(ClassNotFoundException ex)//��׽��������δ�ҵ��쳣
		{
			
		}
		catch(SQLException ex)//��׽������SQL�쳣(�������ݿ����Ӷ����ʱ�����ִ��SQL����ʱ��)
		{
			System.out.println(ex.toString());
		}
	}
	
	//����ѧ����¼�ķ���
	public void addNewStu(Student stu)
	{
		try
		{
			ps=con.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setString(1, stu.sno);
			ps.setString(2, stu.sname);
			ps.setString(3, stu.ssex);
			ps.setInt(4, stu.sage);
			ps.setString(5, stu.sdept);
			ps.execute();
		}
		catch(SQLException ex)//��׽������SQL�쳣(�������ݿ����Ӷ����ʱ�����ִ��SQL����ʱ��)
		{
			System.out.println(ex.toString());
		}
	}
	
	//ɾ����¼�ķ���
	public void deleteStuBySno(String sno)
	{
		try
		{
			ps=con.prepareStatement("delete from student where sno=?");
			ps.setString(1,sno);
			ps.execute();
		}
		catch(SQLException ex)//��׽������SQL�쳣(�������ݿ����Ӷ����ʱ�����ִ��SQL����ʱ��)
		{
			System.out.println(ex.toString());
		}
	}
	
	public void updateStu(Student stu)
	{
		try
		{
			ps=con.prepareStatement("update student set sname=?,ssex=?,sage=?,sdept=? where sno=?");
			ps.setString(1,stu.sname);
			ps.setString(2,stu.ssex);
			ps.setInt(3, stu.sage);
			ps.setString(4, stu.sdept);
			ps.setString(5, stu.sno);
			//ps.setString(1,sno);
			ps.execute();
		}
		catch(SQLException ex)//��׽������SQL�쳣(�������ݿ����Ӷ����ʱ�����ִ��SQL����ʱ��)
		{
			System.out.println(ex.toString());
		}
	}
	
	//ͨ��ѧ�Ų�ѯѧ����¼
	public Student findBySno(String sno)
	{
		Student stu=null;
		try
		{
			st=con.createStatement();
			//����һ��ִ��SQL����Statement����
			ResultSet rs=st.executeQuery("select * from student where sno='"+sno+"'");
			//ִ�в�ѯ��䣬��������ص������������
			if(rs.next())
			{
				stu=new Student(sno,rs.getString(2),rs.getString(3),rs.getShort(4),rs.getString(5));
			}
		}
		catch(SQLException ex)
		{
			
		}
		return stu;
	}
	
	//ͨ����������ѯ
	public ArrayList<Student> findStusBySname(String sname)
	{
		ArrayList<Student> result=new ArrayList<Student>();
		try
		{
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student where sname like '%"+sname+"%'");
			while(rs.next())
			{
				Student stu=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getShort(4),rs.getString(5));
				result.add(stu);
			}
		}
		catch(SQLException ex)
		{
			
		}
		return result;
	}
	
	//ͨ��Ժϵ����ѯ
	public ArrayList<Student> findStusBySdept(String sdept)
	{
		ArrayList<Student> result=new ArrayList<Student>();
		try
		{
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student where sdept='"+sdept+"'");
			while(rs.next())
			{
				Student stu=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getShort(4),sdept);
				result.add(stu);
			}
		}
		catch(SQLException ex)
		{
			
		}
		return result;
	}
	
	//��ѯ������ĳ����Χ��ѧ����¼
	public ArrayList<Student> findStusBetweenSage(int maxAge,int minAge)
	{
		ArrayList<Student> result=new ArrayList<Student>();
		try
		{
			st=con.createStatement();
			//System.out.println("select * from student where sage between "+minAge+" and "+maxAge+" ");
			ResultSet rs=st.executeQuery("select * from student where sage between "+minAge+" and "+maxAge+" ");	
			while(rs.next())
			{
				Student stu=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getShort(4),rs.getString(5));
				result.add(stu);
			}
		}
		catch(SQLException ex)
		{
			
		}
		return result;
	} 
	
	public ArrayList<Student> findAllStus()
	{
		ArrayList<Student> result=new ArrayList<Student>();
		try
		{
			st=con.createStatement();
			//System.out.println("select * from student where sage between "+minAge+" and "+maxAge+" ");
			ResultSet rs=st.executeQuery("select * from student ");	
			while(rs.next())
			{
				Student stu=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getShort(4),rs.getString(5));
				result.add(stu);
			}
		}
		catch(SQLException ex)
		{
			
		}
		return result;
	}
	
}
