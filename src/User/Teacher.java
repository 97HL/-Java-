package User;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Shujuku.Shujukulianjie;

@SuppressWarnings("serial")
public class Teacher implements Serializable {
	private String name;
	private String id;
	private String passwd;

	public Teacher(String name, String id, String passwd) {
		super();
		this.name = name;
		this.id = id;
		this.passwd = passwd;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPasswd() {
		return passwd;
	}
	int addTeacher(Teacher u) throws ClassNotFoundException, SQLException{//��ʦ�Ĺ���
		Shujukulianjie a=new Shujukulianjie();
		String sql="insert into yonghuxinxi values('"+u.getName()+"','"+u.getId()+"','"+u.getPasword()+"');";
		Statement stmt;
		stmt=a.conn.createStatement();
		int q=stmt.executeUpdate(sql);
		return q;
		
	}

	private String getPasword() {
		// TODO Auto-generated method stub
		return null;
	}

	void delTeacher(String id) throws ClassNotFoundException, SQLException{//ɾ��ѧ��
		Shujukulianjie a=new Shujukulianjie();
		String sql="select * from yonghuxinxi where id='" + id + "'";
		String sql1="DELETE FROM yonghuxinxi where id = '" + id + "'";
		Statement stmt;
		stmt=a.conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.getString(2)==null){
			  JOptionPane.showInputDialog(this,"�������˺�");
		}else {
			  stmt.executeUpdate(sql1);
			  JOptionPane.showInputDialog(this,"ɾ���ɹ�");
	 	   }
		
	} 
	public String checkpaper(String id) throws ClassNotFoundException, SQLException{//�鿴�Լ����Ծ�
		Shujukulianjie a=new Shujukulianjie();
		String sql="select * from paper where id='" + id + "'";
		String papername = null;//�Ծ���
		Statement stmt;
		stmt=a.conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			papername=rs.getString(1);
		}
		return papername;
	}
	public static ArrayList<Question> select_stu() throws ClassNotFoundException {//��ѯ���Ծ����Ŀ�ŵ�������
		ArrayList<Question> list=new ArrayList<Question>();
		String sql = null;
		Question stu = null;
		Shujukulianjie a;
		Teacher b = null;
		Statement stmt;
	    String title;// ���
		String answerA;
		String answerB;
		String answerC;
		String answerD;
	    String answer = null;// ��ȷ��
		try {
			a=new Shujukulianjie();
			stmt=a.conn.createStatement();
			sql = "select * from '"+b.checkpaper(b.getId())+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				title=rs.getString("title");
				answerA=rs.getString("answerA");
				answerB=rs.getString("answerB");
				answerB=rs.getString("answerB");
				answerC=rs.getString("answerC");
			    answerD=rs.getString("answerD");
				stu=new Question(title,answerA,answerB,answerC,answerD,answer);
				list.add(stu);
			}
		} catch (SQLException sqle) {
			System.err.println("[mydb172017278]����: " + sqle.getMessage());
		}
		return list;
	}
	JTable j1=new JTable();//���
	public void set() throws ClassNotFoundException{//��ʾȫ��ѧ����Ϣ
		ArrayList<Question> list=select_stu();
		for(int i=0;i<list.size();i++) {
			//���ݽ�������ʾ��Ŀ
		}
	}
}