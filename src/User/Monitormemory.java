package User;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.swing.JOptionPane;

public class Monitormemory {//�ڴ���������Ƿ�������
	private static final int FAULTLENGTH = 10;
	 private static final int CPUTIME = 500;
	 private static final int PERCENT = 100;
	private static long[] readCpu(final Process proc) {
		  long[] retn = new long[2];
		  try {
		   proc.getOutputStream().close();
		   InputStreamReader ir = new InputStreamReader(proc.getInputStream());
		   LineNumberReader input = new LineNumberReader(ir);
		   String line = input.readLine();
		   if (line == null || line.length() < FAULTLENGTH) {
		    return null;
		   }
		   int capidx = line.indexOf("Caption");
		   int cmdidx = line.indexOf("CommandLine");
		   int rocidx = line.indexOf("ReadOperationCount");
		   int umtidx = line.indexOf("UserModeTime");
		   int kmtidx = line.indexOf("KernelModeTime");
		   int wocidx = line.indexOf("WriteOperationCount");
		   long idletime = 0;
		   long kneltime = 0;
		   long usertime = 0;
		   while ((line = input.readLine()) != null) {
		    if (line.length() < wocidx) {
		     continue;
		    }
		    // �ֶγ���˳��Caption,CommandLine,KernelModeTime,ReadOperationCount,
		    // ThreadCount,UserModeTime,WriteOperation
		    String caption = substring(line, capidx, cmdidx - 1).trim();
		    String cmd = substring(line, cmdidx, kmtidx - 1).trim();
		    if (cmd.indexOf("wmic.exe") >= 0) {
		     continue;
		    }
		    String s1 = substring(line, kmtidx, rocidx - 1).trim();
		    String s2 = substring(line, umtidx, wocidx - 1).trim();
		    if (caption.equals("System Idle Process")
		      || caption.equals("System")) {
		     if (s1.length() > 0)
		      idletime += Long.valueOf(s1).longValue();
		     if (s2.length() > 0)
		      idletime += Long.valueOf(s2).longValue();
		     continue;
		    }
		    if (s1.length() > 0)
		     kneltime += Long.valueOf(s1).longValue();
		    if (s2.length() > 0)
		     usertime += Long.valueOf(s2).longValue();
		   }
		   retn[0] = idletime;
		   retn[1] = kneltime + usertime;
		   return retn;
		  } catch (Exception ex) {
		   ex.printStackTrace();
		  } finally {
		   try {
		    proc.getInputStream().close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		  return null;
		 }
	private static String substring(String src, int start_idx, int end_idx) {
		  byte[] b = src.getBytes();
		  String tgt = "";
		  for (int i = start_idx; i <= end_idx; i++) {
		   tgt += (char) b[i];
		  }
		  return tgt;
		 }
		
	public static String getCpuRatioForWindows() {
		  try {
		   String procCmd = System.getenv("windir")
		     + "//system32//wbem//wmic.exe process get Caption,CommandLine,KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";
		   // ȡ������Ϣ
		   long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));
		   Thread.sleep(CPUTIME);
		   long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));
		   if (c0 != null && c1 != null) {
		    long idletime = c1[0] - c0[0];
		    long busytime = c1[1] - c0[1];
		    int a=Double.valueOf(PERCENT * (busytime) * 1.0/ (busytime + idletime)).intValue();
		    if(a>10){
		    return "no";
		    }else {
		     return "ok";
		    }
		   } else {
		    return "CPUʹ����:" + 0 + "%";
		   }
		  } catch (Exception ex) {
		   ex.printStackTrace();
		   return "CPUʹ����:" + 0 + "%";
		  }
		 }
	public Monitormemory(){
		while(true){
		if(getCpuRatioForWindows().equals("no")){
			  JOptionPane.showInputDialog(this,"�����������������Զ�����");
		  }else if(getCpuRatioForWindows().equals("ok")){
			  JOptionPane.showInputDialog(this,"û��");
		  }
		}
	}
	public static void main(String[] args) {
	    new Monitormemory();
		  
		 }
}
