package User;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Shujuku.Shujukulianjie;


public class Student implements Serializable {
	String id;
	String passwd;
	String name;
	String score;
	String sclass;
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public Student(String name, String id, String passwd) {
		super();
		this.name = name;
		this.id = id;
		this.passwd = passwd;
	}
	public Student(String name, String id, String passwd,String sclass) {
		super();
		this.name = name;
		this.id = id;
		this.passwd = passwd;
	}
	public Student(String name, String score) {
		super();
		this.name = name;
		this.score=score;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasword() {
		return passwd;
	}
	public void setPasword(String pasword) {
		passwd = pasword;
	}
	public String getNams() {
		return name;
	}
	public void setNams(String name) {
		this.name = name;
	}
int addStudent(Student u) throws ClassNotFoundException, SQLException{//添加学生
	Shujukulianjie a=new Shujukulianjie();
	String sql="insert into yonghuxinxi values('"+u.getNams()+"','"+u.getId()+"','"+u.getPasword()+"');";
	Statement stmt;
	stmt=a.conn.createStatement();
	int q=stmt.executeUpdate(sql);
	return q;
	
}

void delStudent(String id) throws ClassNotFoundException, SQLException{//删除学生
	Shujukulianjie a=new Shujukulianjie();
	String sql="select * from yonghuxinxi where id='" + id + "'";
	String sql1="DELETE FROM yonghuxinxi where id = '" + id + "'";
	Statement stmt;
	stmt=a.conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	if(rs.getString(2)==null){
		  JOptionPane.showInputDialog(this,"不存在账号");
	}else {
		  stmt.executeUpdate(sql1);
		  JOptionPane.showInputDialog(this,"删除成功");
 	   }
	
} 

public static ArrayList<Student> select_stu() throws ClassNotFoundException {//查询学生存放在一个容器里
	ArrayList<Student> list=new ArrayList<Student>();
	String sql = null;
	Student stu = null;
	Shujukulianjie a;
	Statement stmt;
	String id;
	String passwd;
	String name;
	try {
		a=new Shujukulianjie();
		stmt=a.conn.createStatement();
		sql = "select * from yonghuxinxi where id='" + stu.getId() + "'";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			id=rs.getString("id");
			passwd=rs.getString("passwd");
			name=rs.getString("name");
			stu=new Student(id,passwd,name);
			list.add(stu);
		}
	} catch (SQLException sqle) {
		System.err.println("[mydb172017278]错误: " + sqle.getMessage());
	}
	return list;
}
JTable j1=new JTable();//表格
public void set() throws ClassNotFoundException{//显示全部学生信息
	ArrayList<Student> list=select_stu();
	for(int i=0;i<list.size();i++) {
		j1.setValueAt(list.get(i).getId(), i, 0);
		j1.setValueAt(list.get(i).getNams(), i, 1);
	}
}
}
