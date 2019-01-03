package fuwuqi;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import User.Student;


public class MyClient {
	private static final int MANAGINGCLASSESANDSTUDENTS = 0;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	final int LOGIN = 1001;
	final int LOGIN1 = 100;
	final int LOGIN2 = 10;
	final int REGISTER = 1002;
	final int STUDENTHOME = 1003;
	final int MANAGINGCLASSESANDST = 1004;
	final int EXAMINATIONpapermana = 1005;
	final int MANAGINGCLASSANDSTUDENTS =1006;
	final int OUTOFTESTPAPER = 1007;
    public MyClient() throws UnknownHostException,IOException{
    	String ip ="10.51.161.124";
    	int port=1333;
    	Socket s= new Socket(ip,port);
    	oos=new ObjectOutputStream(s.getOutputStream());
    	ois=new ObjectInputStream(s.getInputStream());
    }
    public Student login(String id,String pwe)throws IOException,ClassNotFoundException{
    	oos.writeInt(LOGIN);
    	oos.flush();
    	oos.writeUTF(id);
    	oos.flush();
    	oos.writeUTF(pwe);
    	oos.flush();
    	Student u=(Student) ois.readObject();
    	return u;
    }
    public Student login1(String id,String pwe)throws IOException,ClassNotFoundException{
    	oos.writeInt(LOGIN1);
    	oos.flush();
    	oos.writeUTF(id);
    	oos.flush();
    	oos.writeUTF(pwe);
    	oos.flush();
    	Student u=(Student) ois.readObject();
    	return u;
    }
    public Student login2(String id,String pwe)throws IOException,ClassNotFoundException{
    	oos.writeInt(LOGIN2);
    	oos.flush();
    	oos.writeUTF(id);
    	oos.flush();
    	oos.writeUTF(pwe);
    	oos.flush();
    	Student u=(Student) ois.readObject();
    	return u;
    }
    public Student register(String name,String pwe,String id,String sclass)throws IOException,ClassNotFoundException{
    	oos.writeInt(REGISTER);
    	oos.flush();
    	oos.writeUTF(name);
    	oos.flush();
    	oos.writeUTF(pwe);
    	oos.flush();
    	oos.writeUTF(id);
    	oos.flush();
    	oos.writeUTF(sclass);
    	oos.flush();
    	return (Student)ois.readObject();
    	}
  
    public String Managingclassesandst(String tname, String tclass) throws IOException {
    	oos.writeInt(MANAGINGCLASSESANDST);
    	oos.flush();
		oos.writeUTF("²éÑ¯");
    	oos.flush();
    	oos.writeUTF("ÐÞ¸Ä");
    	oos.flush();
		oos.writeUTF(tname);
		oos.flush();
		oos.writeUTF(tclass);
		oos.flush();
		return ois.readUTF();
	}
    public String Examinationpapermana(String tname) throws IOException {
    	oos.writeInt(EXAMINATIONpapermana);
    	oos.flush();	
		oos.writeUTF("tname");
		oos.flush();	
		return ois.readUTF();
    }
	public String Examinationpapermana(String tname,String row) throws IOException {
	    	oos.writeInt(EXAMINATIONpapermana);
	    	oos.flush();
	    	oos.writeUTF("row");
			oos.flush();
			oos.writeUTF("tname");
			oos.flush();	
			return ois.readUTF();
	}
	public ArrayList<Wodeshujia> Managingclassesandstudents(String tname)throws IOException, ClassNotFoundException{
		ArrayList<Wodeshujia> list = new ArrayList<Wodeshujia>();
		Wodeshujia wodeshujia;
		 oos.writeInt(MANAGINGCLASSESANDSTUDENTS);
		 oos.flush();
		 oos.writeUTF("tname");
		 oos.flush();
		list = (ArrayList<Wodeshujia>) ois.readObject();
		return list;
	}
	public ArrayList<Wodeshujia> Managingclassesandstudents(String tname,String cname, String cnumber)throws IOException, ClassNotFoundException{
		ArrayList<Wodeshujia> list = new ArrayList<Wodeshujia>();
		Wodeshujia wodeshujia;
		 oos.writeInt(MANAGINGCLASSESANDSTUDENTS);
		 oos.flush();
		 oos.writeUTF(tname);
		 oos.flush();
		 oos.writeUTF(cname);
		 oos.flush();
		 oos.writeUTF(cnumber);
		 oos.flush();
		 list = (ArrayList<Wodeshujia>) ois.readObject();
		 return list;	 
	}
	//public String Outoftestpaper(String a,String b)throws IOException{
	//	oos.writeInt(OUTOFTESTPAPER);
	//	oos.flush();
	//	oos.writeUTF(a);
	//	oos.flush();
	//	oos.writeUTF(b);
	//	oos.flush();
	//	return ois.readUTF();	                                                                                                   
	//}
		
    public static void main(String[] args){
    	try{
    		new MyClient();
    	}catch(UnknownHostException e){
    		e.printStackTrace();
    	}catch (IOException e){
    		e.printStackTrace();
    	}
    }
}
class Wodeshujia {
	String classname;
	String classnumber;

	public Wodeshujia(String classname, String classnumber) {
		this.classname = classname;
		this.classnumber = classnumber;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClassnumber() {
		return classnumber;
	}

	public void setClassnumber(String classnumber) {
		this.classnumber = classnumber;
	}

}
