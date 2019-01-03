package paper;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Shujuku.Shujukulianjie;

class Simple { 
	 String tihao; 
	 String timu; 
	 String A; 
	 String B; 
	 String C; 
	 String D; 
	 String answer; 
	} 
public class addQuestion {
	 
	 // 插入数据 
public static void insert(Simple simple) throws ClassNotFoundException, SQLException { 
	  Shujukulianjie a=new Shujukulianjie();
	  String sql = "INSERT INTO test(tihao,timu,A,B,C,D,answer) VALUES(?,?,?,?,?,?,?)"; 
	  PreparedStatement sm = null; 
	  try { 
	   sm =a.conn.prepareStatement(sql); 
	   sm.setString(1, simple.tihao); 
	   sm.setString(2, simple.timu); 
	   sm.setString(3, simple.A); 
	   sm.setString(4, simple.B); 
	   sm.setString(5, simple.C); 
	   sm.setString(6, simple.D); 
	   sm.setString(7, simple.answer); 
	   sm.execute(); 
	  } catch (Exception e) { 
	   e.printStackTrace(); 
	  } 
	 } 
public static List<Simple> getText(String filePath) { 
	  List<Simple> simples = new ArrayList<Simple>(); 
	  try { 
	   FileReader reader = new FileReader(filePath); 
	   BufferedReader bfReader = new BufferedReader(reader); 
	   String text = null; 
	   while ((text = bfReader.readLine()) != null) { 
	    String[] texts = text.split(" "); 
	    Simple simple = new Simple(); 
	    simple.tihao = texts[0]; 
	    simple.timu = texts[1]; 
	    simple.A = texts[2]; 
	    simple.B = texts[3];
	    simple.C = texts[4];
	    simple.D = texts[5];
	    simple.answer = texts[6];
	    simples.add(simple); 
	   } 
	  } catch (Exception e) { 
	   e.printStackTrace(); 
	  } 
	  return simples; 
	 } 
     
    public static void main(String argv[]){
        String filePath = "C:\\Users\\Shinelon\\Desktop\\123.txt";
     // 获取文本内容 
        List<Simple> simples = getText(filePath); 
        // 插入数据库 
        for (Simple simple : simples) { 
         try {
			insert(simple);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        }
    }
     
     
 
}

