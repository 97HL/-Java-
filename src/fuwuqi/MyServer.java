package fuwuqi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Shujuku.Shujukulianjie;
import User.Student;
public class MyServer implements Runnable  {
   
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
    Socket s;
    
    public MyServer()throws IOException, ClassNotFoundException, SQLException{
    	int port=1333;
    	ServerSocket ss=new ServerSocket(port); 
    	final int LOGIN = 1001;
    	final int LOGIN1 = 100;
    	final int LOGIN2 = 10;
    	final int REGISTERED = 1002;
    	final int STUDENTHOME = 1003;
    	final int MANAGINGCLASSESANDS = 1004;
    	final int EXAMINATIONpapermana = 1005;
    	final int MANAGINGCLASSANDSTUDENTS = 1006;
    	final int OUTOFTESTPAPER = 1007;
    	JOptionPane.showMessageDialog(null, this, "服务开启", OUTOFTESTPAPER);
    	System.out.println("服务区创建中");
    	 while(true){
   		  s=ss.accept();
   		  ois=new ObjectInputStream(s.getInputStream());
   		  oos=new ObjectOutputStream(s.getOutputStream());
    	int command=ois.readInt();
    	if(command == LOGIN){
    	    login();		
    	} 
    	if(command == LOGIN1){
    	    login1();		
    	} 
    	if(command == LOGIN2){
    	    login2();		
    	} 
    	if(command == REGISTERED){
    	    register();		
    	} 
    	
    	if(command == MANAGINGCLASSESANDS){
    	    Managingclassesands();		
    	} 
    	 }
    	
    }
    private void login() throws IOException  {
    	Student u=null;
    	String sid = ois.readUTF();
    	String spw=ois.readUTF();
    	Shujukulianjie a;
		try {
			a = new Shujukulianjie();
			Statement stmt;
	    	stmt= a.conn.createStatement();
	    	String sql = "select * from studentlist where sid='"+sid+"'and spw='"+spw+"'";
	    	System.out.println(sid);
	    	ResultSet rs =stmt.executeQuery(sql);
	  		   u=new Student(rs.getString(2),rs.getString(1),rs.getString(3));
	    		   oos.writeObject(u);
	    		   oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 u=null;
  		   oos.writeObject(u);
  		   oos.flush();
		}
  
    	
    }
    private void login1() throws IOException, ClassNotFoundException, SQLException{
    	Student u=null;
    	String sid = ois.readUTF();
    	String spw=ois.readUTF();
    	Shujukulianjie a=new Shujukulianjie();
    	Statement stmt;
    	stmt= a.conn.createStatement();
    	String sql = "select * from teacherlist where tid='"+sid+"'and tpw='"+spw+"'";
    	ResultSet rs =stmt.executeQuery(sql);
    	while(rs.next()){
    	if(rs.getString(1)==null||rs.getString(3)==null){
			   u=null;
    		   oos.writeObject(u);
    		   oos.flush();
		}else {
  		   u=new Student(rs.getString(2),rs.getString(1),rs.getString(3));
    		   oos.writeObject(u);
    		   oos.flush();
  	   }
    	}
    }
    private void login2() throws IOException, ClassNotFoundException, SQLException{
    	Student u=null;
    	String sid = ois.readUTF();
    	String spw=ois.readUTF();
    	Shujukulianjie a=new Shujukulianjie();
    	Statement stmt;
    	stmt= a.conn.createStatement();
    	String sql = "select * from administratorlist where Aid='"+sid+"'and Apw='"+spw+"'";
    	ResultSet rs =stmt.executeQuery(sql);
    	while(rs.next()){
    	if(rs.getString(1)==null||rs.getString(2)==null){
			   u=null;
    		   oos.writeObject(u);
    		   oos.flush();
		}else {
  		   u=new Student(rs.getString(3),rs.getString(1),rs.getString(2));
    		   oos.writeObject(u);
    		   oos.flush();
  	   }
    	}
    }
    public void register()throws IOException, ClassNotFoundException, SQLException{
    	String name = ois.readUTF();
    	String pwe = ois.readUTF();
    	String id = ois.readUTF();
    	String sclass=ois.readUTF();
    	Shujukulianjie a=new Shujukulianjie();
    	Statement stmt;
    	String sql = "insert into studentlist(sid,Sname,spw,class) values('"+id+"','"+name+"','"+pwe+"','"+sclass+"')";
    	try{
    		stmt=a.conn.createStatement();
    		stmt.executeUpdate(sql);
    		oos.writeObject(new Student(name,pwe,id,sclass));
    		oos.flush();
    	}catch(Exception e){
    		oos.writeObject(null);
    		oos.flush();
    		e.printStackTrace();
    	}}
  
    public void Managingclassesands()throws IOException,ClassNotFoundException,SQLException{
    	String tname = ois.readUTF();
    	String tclass = ois.readUTF();
    	Shujukulianjie a=new Shujukulianjie();
    	Statement stmt;
    	String sql = "insert into  values('"+tname+"','"+tclass+"')";
    	try{
    		stmt =a.conn.createStatement();
    		oos.writeObject(new Student(tname,tclass));
    		oos.flush();
    	}catch(Exception e){
    		oos.writeObject(null);
    		oos.flush();
    	}
    }
    public void Examinationpapermana()throws IOException,ClassNotFoundException,SQLException{
    	String tname = ois.readUTF();
    	String row = ois.readUTF();
    	Shujukulianjie a=new Shujukulianjie();
    	Statement stmt;
    	String sql = "insert into  values('"+tname+"','"+row+"')";
    	try{
    		stmt =a.conn.createStatement();
    		oos.writeObject(new Student(tname, row));
    		oos.flush();
    	}catch(Exception e){
    		oos.writeObject(null);
    		oos.flush();
    	}
    }
    public void  Managingclassesandstudents()throws IOException,ClassNotFoundException,SQLException{
    	String tname = ois.readUTF();
    	
    	Shujukulianjie a=new Shujukulianjie();
    	Statement stmt;
    	ArrayList<Wodeshujia> list = new ArrayList<Wodeshujia>();
		Wodeshujia wodeshujia;
    	String sql = "insert into  values('"+tname+"')";
    	
    	try{
    		
    		stmt =a.conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		while (rs.next()) {
				String classname = rs.getString("classname");
				String classnumber = rs.getString("classnumber");
				wodeshujia = new Wodeshujia(classname, classnumber);
				list.add(wodeshujia);
			}
    		oos.writeObject(list);
    		oos.flush();
    	}catch(Exception e){
    		oos.writeObject(null);
    		oos.flush();
    	}
    }
    public void Managingclassesandstudents1()throws IOException,ClassNotFoundException,SQLException{
    	String tname = ois.readUTF();
    	String cname = ois.readUTF();
    	String cnumber = ois.readUTF();
    	Shujukulianjie a=new Shujukulianjie();
    	Statement stmt;
    	ArrayList<Wodeshujia> list = new ArrayList<Wodeshujia>();
		Wodeshujia wodeshujia;
    	String sql = "insert into  values('"+tname+"','"+cname+"','"+cnumber+"')";
    	
    	try{
    		
    		stmt =a.conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		while (rs.next()) {
				String classname = rs.getString("cname");
				String classnumber = rs.getString("cnumber");
				wodeshujia = new Wodeshujia(cname, cnumber);
				list.add(wodeshujia);
			}
    		oos.writeObject(list);
    		oos.flush();
    	}catch(Exception e){
    		oos.writeObject(null);
    		oos.flush();
    	}
    }
   
    	
    	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        try{
        	new MyServer();
        	Thread t = new Thread();
			t.start();
        }catch (IOException e){
        	e.printStackTrace();
        	
        }
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			login();
			login1();
			login2();	
			register();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}




