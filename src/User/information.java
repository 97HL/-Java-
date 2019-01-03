package User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Shujuku.Shujukulianjie;

public class information {
	String id;
	String Examination ;
	int ranking;
	public information(String id, String Examination, int rankingint) {
		super();
		this.id = id;
		this.Examination=Examination;
		this.ranking=rankingint;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExamination() {
		return Examination;
	}
	public void setExamination(String examination) {
		Examination = examination;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
public static  ArrayList<information> information(String Examination){//查询考试列表
	ArrayList<information> list=new ArrayList<information>();
	information inf = null;
	String sql="select * from question where exam='" + Examination + "'";
	Statement stmt;
	try {
		Shujukulianjie a=new Shujukulianjie();
		stmt=a.conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			//看数据库建的表
			list.add(inf);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return list;
	
}

}

