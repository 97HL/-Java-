package User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Shujuku.Shujukulianjie;

public class Rankingachievements {//成绩排名

	public static ArrayList<Student> select_rank() throws ClassNotFoundException {//查询学生存放在一个容器里
		ArrayList<Student> list=new ArrayList<Student>();
		String sql = null;
		Student stu = null;
		Shujukulianjie a;
		Statement stmt;
		String name;
		String score;
		try {
			a=new Shujukulianjie();
			stmt=a.conn.createStatement();
			sql = "select * from javascore ";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				name=rs.getString("name");
				score=rs.getString("score");
				stu=new Student(name,score);
				list.add(stu);
			}
		} catch (SQLException sqle) {
			System.err.println("[mydb172017278]错误: " + sqle.getMessage());
		}
		return list;
	}
	public static void xianshi() throws ClassNotFoundException{
		ArrayList<Student> list=select_rank();
		Collections.sort(list,new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				int i=Integer.valueOf(o2.getScore()).intValue() - Integer.valueOf(o1.getScore()).intValue();
				if(i==0){
					return Integer.valueOf(o2.getNams()).intValue() - Integer.valueOf(o1.getNams()).intValue();
				}
				return i;

			}
			
		});
        for(Student stu: list){
        	System.out.println("score:" + stu.getScore() + ":name" + stu.getNams());
        }
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Rankingachievements a=new Rankingachievements();
		a.select_rank();
		a.xianshi();
	}

}
