package paper;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Shujuku.Shujukulianjie;

public class delQuestion {
     String papername;
	public delQuestion(String papername) throws ClassNotFoundException, SQLException{
		Shujukulianjie a=new Shujukulianjie();
		Statement stmt;
		stmt=a.conn.createStatement();
		String sql="DROP TABLE '"+papername+"'";
		int i=stmt.executeUpdate(sql);
		if(i==1){
			JOptionPane.showInputDialog(this, "ɾ���ɹ�");
		}else {
			JOptionPane.showInputDialog(this, "���Ծ�����");
		}
		
	}
}
