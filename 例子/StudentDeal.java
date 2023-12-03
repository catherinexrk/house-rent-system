import java.sql.*;
import java.util.*;

/**
 * 操作数据库中的学生表
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
			//加载驱动
			String conStr="jdbc:sqlserver://localhost:1433; DatabaseName=student_course";
			String user="sa";//超级管理员用户,拥有对于所有数据对象的所有操作权限
			String password="sa123";
			con=DriverManager.getConnection(conStr,user,password);
			//用驱动管理类的方法来创建数据库连接对象
		}
		catch(ClassNotFoundException ex)//捕捉并处理类未找到异常
		{
			
		}
		catch(SQLException ex)//捕捉并处理SQL异常(创建数据库连接对象的时候或者执行SQL语句的时候)
		{
			System.out.println(ex.toString());
		}
	}
	
	//增加学生记录的方法
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
		catch(SQLException ex)//捕捉并处理SQL异常(创建数据库连接对象的时候或者执行SQL语句的时候)
		{
			System.out.println(ex.toString());
		}
	}
	
	//删除记录的方法
	public void deleteStuBySno(String sno)
	{
		try
		{
			ps=con.prepareStatement("delete from student where sno=?");
			ps.setString(1,sno);
			ps.execute();
		}
		catch(SQLException ex)//捕捉并处理SQL异常(创建数据库连接对象的时候或者执行SQL语句的时候)
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
		catch(SQLException ex)//捕捉并处理SQL异常(创建数据库连接对象的时候或者执行SQL语句的时候)
		{
			System.out.println(ex.toString());
		}
	}
	
	//通过学号查询学生记录
	public Student findBySno(String sno)
	{
		Student stu=null;
		try
		{
			st=con.createStatement();
			//创建一个执行SQL语句的Statement对象
			ResultSet rs=st.executeQuery("select * from student where sno='"+sno+"'");
			//执行查询语句，将结果返回到结果集对象中
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
	
	//通过姓名来查询
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
	
	//通过院系来查询
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
	
	//查询年龄在某个范围的学生记录
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
