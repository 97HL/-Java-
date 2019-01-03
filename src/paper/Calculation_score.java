package paper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Shujuku.Shujukulianjie;

public class Calculation_score extends JFrame{//¼ÆËã·ÖÊý
	JLabel timu;
	JRadioButton A;
	JRadioButton B;
	JRadioButton C;
	JRadioButton D;
	ButtonGroup q;
	double score;
	int lenght;
	public double Calculation_score() throws ClassNotFoundException, SQLException{
		q.add(A);
		q.add(B);
		q.add(C);
		q.add(D);
		for(int i=0;i<=lenght;i++){
		String a=A.getText();
		String b=B.getText();
		String c=C.getText();
		String d=D.getText();
		Shujukulianjie shu=new Shujukulianjie();
		Statement stmt;
		String answer = null;
		String sql="select*from papername where timu='"+timu+"'";
		stmt=shu.conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			answer=rs.getString(7);
		}
		if(A.isSelected()&&answer.equals(a)){
			score++;
			
		}else if(B.isSelected()&&answer.equals(b)){
			score++;
		}else if(C.isSelected()&&answer.equals(c)){
			score++;
		}else if(D.isSelected()&&answer.equals(d)){
			score++;
		}
        
		}
		return score;
	}
}
