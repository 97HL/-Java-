/*
 * Examination.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import Shujuku.Shujukulianjie;

/**
 *
 * @author  __USER__
 */
public class Examination extends javax.swing.JFrame {
	static int tempcount = 0, total = 0;// 单选题号,成绩
	static int tempcount1 = 0, total1 = 0;// 多选题号,成绩
	static int tempcount2 = 0, total2 = 0;// 判断题题号,成绩
	static int tempcount3 = 0, total3 = 0;// 填空题题号,成绩
	static int[] result = new int[10];// 考生单选题答案
	static int[] result1 = new int[5];// 考生多选题答案
	static int[] result2 = new int[5];// 考生判断答案
	static int[] result3 = new int[5];// 考生填空题答案
	static ArrayList<String> arraylist1, arraylist2, arraylist3;// 单选题目编号,答案,标准答案
	static ArrayList<String> arraylist4, arraylist5, arraylist6;// 多选题目编号,答案,标准答案
	static ArrayList<String> arraylist7, arraylist8, arraylist9;// 判断题目编号,答案,标准答案
	static ArrayList<String> arraylist10, arraylist11, arraylist12;// 填空题目编号,答案,标准答案

	/** Creates new form Examination */
	public Examination(String a) {
		initComponents();
		jLabel2.setText(a);
		new EndTime().start();
	}

	public void setname(String a) {
		jLabel17.setText(a);
	}

	class EndTime extends Thread {//考试时间提示
		public void run() {
			String time[] = { "90", "0" };
			int m = Integer.valueOf(time[0]);
			int s = Integer.valueOf(time[1]);
			while (true) {
				jLabel5.setText("考试时间：" + String.valueOf(m) + " 分"
						+ String.valueOf(s) + " 秒");
				if (s > 0 && s < 60) {
					s--;
				}
				if (s == 0 && m > 0) {
					s = 59;
					m--;
				}
				if (s == 0 && m == 0) {
					JOptionPane.showMessageDialog(null, "时间到!");
					dispose();
					
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setdanxuan(String a) throws ClassNotFoundException,
			SQLException {//单选题设置
		arraylist1 = new ArrayList<String>();
		arraylist2 = new ArrayList<String>();
		arraylist3 = new ArrayList<String>();
		Shujukulianjie b = new Shujukulianjie();
		Statement stmt;
		try {
			String sql = "select * from " + a + "danxuan";
			stmt = b.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tempid = rs.getString(1);
				String tempAbcd = rs.getString(3) + rs.getString(4)
						+ rs.getString(5) + rs.getString(6);
				String tempda = rs.getString(7);
				arraylist1.add(tempid);
				arraylist2.add(tempAbcd);
				arraylist3.add(tempda);
			}
			addAbcd();// 加入选项
			goStart(a);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void goStart(String a) {//设置上下题到顶变色开关和显示单选题目
		if (tempcount == 0) {
			jButton1.setEnabled(false);
		} else {
			jButton1.setEnabled(true);
		}
		if (tempcount == 1) {
			jButton2.setEnabled(false);
		} else {
			jButton2.setEnabled(true);
		}
		/**
		 * 
		 */
		Shujukulianjie b;
		Statement stmt;
		PreparedStatement psmt;
		try {
			b = new Shujukulianjie();
			String sql = "select * from " + a + "danxuan where tihao=?";
			stmt = b.conn.createStatement();
			psmt = b.conn.prepareStatement(sql);
			psmt.setString(1, arraylist1.get(tempcount));
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				jLabel7.setText(rs.getString(2));
				jTextArea2.setText(arraylist2.get(tempcount));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class choiseAction implements ActionListener {//选择单选题答案事件
		public void actionPerformed(ActionEvent e) {
			if (jRadioButton1.isSelected()) {
				result[tempcount] = 1;
			}
			if (jRadioButton2.isSelected()) {
				result[tempcount] = 2;
			}
			if (jRadioButton3.isSelected()) {
				result[tempcount] = 3;
			}
			if (jRadioButton4.isSelected()) {
				result[tempcount] = 4;
			}
		}
	}

	public void addAbcd() {
		jRadioButton1.addActionListener(new choiseAction());
		jRadioButton2.addActionListener(new choiseAction());
		jRadioButton3.addActionListener(new choiseAction());
		jRadioButton4.addActionListener(new choiseAction());

	}

	public void tempResult() {//临时单选存放答案
		switch (result[tempcount]) {
		case 0:
			buttonGroup1.clearSelection();
			break;
		case 1:
			jRadioButton1.setSelected(true);
			break;
		case 2:
			jRadioButton2.setSelected(true);
			break;
		case 3:
			jRadioButton3.setSelected(true);
			break;
		case 4:
			jRadioButton4.setSelected(true);
			break;
		}
	}

	public void goEnd() {//交题方法
		int tempComplete = JOptionPane.showConfirmDialog(null, "是否确认交卷", "提示",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (tempComplete == 0) {
			for (int i = 0; i < result1.length; i++) {
				if (arraylist3.get(i).equals(String.valueOf(result[i]))) {
					total += 1;
				}
				if (arraylist6.get(i).equals(String.valueOf(result1[i]))) {
					total1 += 1;
				}
				if (arraylist9.get(i).equals(String.valueOf(result2[i]))) {
					total2 += 1;
				}
				if (arraylist12.get(i).equals(jTextArea1.getText())) {
					total3 += 1;
				}
			}
			int a = total + total1 + total2 + total3;

			JOptionPane.showMessageDialog(null, "你的分数为:" + a + "分", "提示",
					JOptionPane.PLAIN_MESSAGE);
			try {
				Shujukulianjie b = new Shujukulianjie();
				Statement stmt;
				String score = "" + a;
				stmt = b.conn.createStatement();
				String papername = jLabel2.getText();
				String name = jLabel17.getText();
				String sql = "insert into " + papername
						+ "score(name,score) values('" + name + "','" + score
						+ "')";
				String sql1 = "insert into studentscore(papername,score,name) values('"
						+ papername + "','" + score + "','" + name + "')";
				stmt.executeUpdate(sql);
				new Studenthome(jLabel17.getText()).setVisible(true);
				this.dispose();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();// 退出
		}
	}

	public void setduoxuan(String a) throws ClassNotFoundException,
			SQLException {//多选题设置
		arraylist4 = new ArrayList<String>();
		arraylist5 = new ArrayList<String>();
		arraylist6 = new ArrayList<String>();
		Shujukulianjie b = new Shujukulianjie();
		Statement stmt;
		try {
			String sql = "select * from " + a + "duoxuan";
			stmt = b.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tempid = rs.getString(1);
				String tempAbcd = rs.getString(3) + rs.getString(4)
						+ rs.getString(5) + rs.getString(6);
				String tempda = rs.getString(7);
				arraylist4.add(tempid);
				arraylist5.add(tempAbcd);
				arraylist6.add(tempda);
			}
			addAbcd1();// 加入选项
			goStart1(a);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void goStart1(String a) {//设置上下题到顶变色开关和显示多选题目
		if (tempcount1 == 0) {
			jButton3.setEnabled(false);
		} else {
			jButton3.setEnabled(true);
		}
		if (tempcount1 == 1) {
			jButton4.setEnabled(false);
		} else {
			jButton4.setEnabled(true);
		}
		/**
		 * 
		 */
		Shujukulianjie b;
		Statement stmt;
		PreparedStatement psmt;
		try {
			b = new Shujukulianjie();
			String sql = "select * from " + a + "duoxuan where tihao=?";
			stmt = b.conn.createStatement();
			psmt = b.conn.prepareStatement(sql);
			psmt.setString(1, arraylist4.get(tempcount1));
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				jLabel16.setText(rs.getString(2));
				jTextArea4.setText(arraylist5.get(tempcount1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class choiseAction1 implements ActionListener {//选择多选题答案事件
		public void actionPerformed(ActionEvent e) {
			if (jRadioButton5.isSelected()) {
				result1[tempcount1] = 1;
			}
			if (jRadioButton6.isSelected()) {
				result1[tempcount1] = 2;
			}
			if (jRadioButton7.isSelected()) {
				result1[tempcount1] = 3;
			}
			if (jRadioButton8.isSelected()) {
				result1[tempcount1] = 4;
			}
			if (jRadioButton5.isSelected() && jRadioButton6.isSelected()) {
				result1[tempcount1] = 12;
			}
			if (jRadioButton5.isSelected() && jRadioButton7.isSelected()) {
				result1[tempcount1] = 13;
			}
			if (jRadioButton5.isSelected() && jRadioButton8.isSelected()) {
				result1[tempcount1] = 14;
			}
			if (jRadioButton5.isSelected() && jRadioButton6.isSelected()
					&& jRadioButton7.isSelected()) {
				result1[tempcount1] = 123;
			}
			if (jRadioButton5.isSelected() && jRadioButton6.isSelected()
					&& jRadioButton8.isSelected()) {
				result1[tempcount1] = 124;
			}
			if (jRadioButton6.isSelected() && jRadioButton7.isSelected()
					&& jRadioButton8.isSelected()) {
				result1[tempcount1] = 234;
			}
			if (jRadioButton5.isSelected() && jRadioButton6.isSelected()
					&& jRadioButton7.isSelected() && jRadioButton8.isSelected()) {
				result1[tempcount1] = 1234;
			}
			if (jRadioButton6.isSelected() && jRadioButton7.isSelected()) {
				result1[tempcount1] = 23;
			}
			if (jRadioButton6.isSelected() && jRadioButton8.isSelected()) {
				result1[tempcount1] = 24;
			}
			if (jRadioButton7.isSelected() && jRadioButton8.isSelected()) {
				result1[tempcount1] = 34;
			}
		}
	}

	public void addAbcd1() {
		jRadioButton5.addActionListener(new choiseAction1());
		jRadioButton6.addActionListener(new choiseAction1());
		jRadioButton7.addActionListener(new choiseAction1());
		jRadioButton8.addActionListener(new choiseAction1());

	}

	public void setpanduan(String a) throws ClassNotFoundException,
			SQLException {//判断题设置
		arraylist7 = new ArrayList<String>();
		arraylist8 = new ArrayList<String>();
		arraylist9 = new ArrayList<String>();
		Shujukulianjie b = new Shujukulianjie();
		Statement stmt;
		try {
			String sql = "select * from " + a + "panduan";
			stmt = b.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tempid = rs.getString(1);
				String tempda = rs.getString(3);
				arraylist7.add(tempid);
				arraylist9.add(tempda);
			}
			addAbcd2();// 加入选项
			goStart2(a);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void goStart2(String a) {//设置上下题到顶变色开关和显示判断题目
		if (tempcount2 == 0) {
			jButton5.setEnabled(false);
		} else {
			jButton5.setEnabled(true);
		}
		if (tempcount2 == 1) {
			jButton6.setEnabled(false);
		} else {
			jButton6.setEnabled(true);
		}
		/**
		 * 
		 */
		Shujukulianjie b;
		Statement stmt;
		PreparedStatement psmt;
		try {
			b = new Shujukulianjie();
			String sql = "select * from " + a + "panduan where tihao=?";
			stmt = b.conn.createStatement();
			psmt = b.conn.prepareStatement(sql);
			psmt.setString(1, arraylist7.get(tempcount2));
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				jLabel10.setText(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class choiseAction2 implements ActionListener {//选择判断题答案事件
		public void actionPerformed(ActionEvent e) {
			if (jRadioButton9.isSelected()) {
				result2[tempcount2] = 1;
			}
			if (jRadioButton10.isSelected()) {
				result2[tempcount2] = 2;
			}
		}
	}

	public void addAbcd2() {
		jRadioButton9.addActionListener(new choiseAction2());
		jRadioButton10.addActionListener(new choiseAction2());

	}

	public void settiankong(String a) throws ClassNotFoundException,
			SQLException {//填空题设置
		arraylist10 = new ArrayList<String>();
		arraylist11 = new ArrayList<String>();
		arraylist12 = new ArrayList<String>();
		Shujukulianjie b = new Shujukulianjie();
		Statement stmt;
		try {
			String sql = "select * from " + a + "tiankong";
			stmt = b.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tempid = rs.getString(1);
				String tempda = rs.getString(3);
				arraylist10.add(tempid);
				arraylist12.add(tempda);
			}
			goStart3(a);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void goStart3(String a) {//设置上下题到顶变色开关和显示填空题目
		if (tempcount3 == 0) {
			jButton7.setEnabled(false);
		} else {
			jButton7.setEnabled(true);
		}
		if (tempcount3 == 1) {
			jButton8.setEnabled(false);
		} else {
			jButton8.setEnabled(true);
		}
		/**
		 * 
		 */
		Shujukulianjie b;
		Statement stmt;
		PreparedStatement psmt;
		try {
			b = new Shujukulianjie();
			String sql = "select * from " + a + "tiankong where tihao=?";
			stmt = b.conn.createStatement();
			psmt = b.conn.prepareStatement(sql);
			psmt.setString(1, arraylist10.get(tempcount3));
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				jLabel13.setText(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();  
	    this.setLocation((scrSize.width)/2, (scrSize.height)/2);
	    this.setResizable(false);
		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton4 = new javax.swing.JRadioButton();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		jRadioButton5 = new javax.swing.JRadioButton();
		jLabel9 = new javax.swing.JLabel();
		jRadioButton6 = new javax.swing.JRadioButton();
		jRadioButton7 = new javax.swing.JRadioButton();
		jRadioButton8 = new javax.swing.JRadioButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jRadioButton9 = new javax.swing.JRadioButton();
		jRadioButton10 = new javax.swing.JRadioButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		jLabel13 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTextArea4 = new javax.swing.JTextArea();
		jLabel10 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel1.setText("\u5f00\u59cb\u8003\u8bd5\uff1a");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel2.setText("jLabel2");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel3.setText("\u5355\u9009\u9898");

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel4.setText("\u5269\u4f59\u65f6\u95f4\uff1a");

		jLabel5.setText("jLabel5");

		jLabel6.setText("\u9898\u76ee\uff1a");

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setText("A");
		jRadioButton1.setOpaque(false);

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setText("B");
		jRadioButton2.setOpaque(false);

		buttonGroup1.add(jRadioButton3);
		jRadioButton3.setText("C");
		jRadioButton3.setOpaque(false);

		buttonGroup1.add(jRadioButton4);
		jRadioButton4.setText("D");
		jRadioButton4.setOpaque(false);

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/上一题.png"))); // NOI18N
		jButton1.setPreferredSize(new java.awt.Dimension(267, 75));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/下一题.png"))); // NOI18N
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel8.setText("\u591a\u9009\u9898");

		jRadioButton5.setText("A");
		jRadioButton5.setOpaque(false);

		jLabel9.setText("\u9898\u76ee\uff1a");

		jRadioButton6.setText("B");
		jRadioButton6.setOpaque(false);

		jRadioButton7.setText("C");
		jRadioButton7.setOpaque(false);

		jRadioButton8.setText("D");
		jRadioButton8.setOpaque(false);

		jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/上一题.png"))); // NOI18N
		jButton3.setPreferredSize(new java.awt.Dimension(267, 75));
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/下一题.png"))); // NOI18N
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel11.setText("\u5224\u65ad\u9898");

		jLabel12.setText("\u9898\u76ee\uff1a");

		buttonGroup2.add(jRadioButton9);
		jRadioButton9.setText("\u221a");
		jRadioButton9.setOpaque(false);

		buttonGroup2.add(jRadioButton10);
		jRadioButton10.setText("\u00d7");
		jRadioButton10.setOpaque(false);

		jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/上一题.png"))); // NOI18N
		jButton5.setPreferredSize(new java.awt.Dimension(267, 75));
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/下一题.png"))); // NOI18N
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel14.setText("\u586b\u7a7a\u9898");

		jLabel15.setText("\u9898\u76ee\uff1a");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/上一题.png"))); // NOI18N
		jButton7.setPreferredSize(new java.awt.Dimension(267, 75));
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/下一题.png"))); // NOI18N
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jButton9.setBackground(new java.awt.Color(255, 0, 51));
		jButton9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jButton9.setForeground(new java.awt.Color(255, 255, 255));
		jButton9.setText("\u4ea4\u5377");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jScrollPane2.setViewportView(jTextArea2);

		jTextArea4.setColumns(20);
		jTextArea4.setRows(5);
		jScrollPane4.setViewportView(jTextArea4);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				168,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				166,
																				Short.MAX_VALUE)
																		.addGap(
																				143,
																				143,
																				143)
																		.addComponent(
																				jLabel4,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				168,
																				Short.MAX_VALUE)
																		.addGap(
																				12,
																				12,
																				12))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								jLabel3,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addGroup(
																																				jPanel1Layout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addGroup(
																																								jPanel1Layout
																																										.createSequentialGroup()
																																										.addComponent(
																																												jRadioButton1,
																																												javax.swing.GroupLayout.PREFERRED_SIZE,
																																												115,
																																												javax.swing.GroupLayout.PREFERRED_SIZE)
																																										.addPreferredGap(
																																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																										.addComponent(
																																												jRadioButton2,
																																												javax.swing.GroupLayout.PREFERRED_SIZE,
																																												134,
																																												javax.swing.GroupLayout.PREFERRED_SIZE))
																																						.addGroup(
																																								jPanel1Layout
																																										.createSequentialGroup()
																																										.addGap(
																																												37,
																																												37,
																																												37)
																																										.addComponent(
																																												jButton1,
																																												javax.swing.GroupLayout.PREFERRED_SIZE,
																																												100,
																																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addGroup(
																																				jPanel1Layout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addGroup(
																																								jPanel1Layout
																																										.createSequentialGroup()
																																										.addComponent(
																																												jRadioButton3,
																																												javax.swing.GroupLayout.PREFERRED_SIZE,
																																												117,
																																												javax.swing.GroupLayout.PREFERRED_SIZE)
																																										.addPreferredGap(
																																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																										.addComponent(
																																												jRadioButton4,
																																												javax.swing.GroupLayout.PREFERRED_SIZE,
																																												120,
																																												javax.swing.GroupLayout.PREFERRED_SIZE))
																																						.addComponent(
																																								jButton2,
																																								javax.swing.GroupLayout.PREFERRED_SIZE,
																																								100,
																																								javax.swing.GroupLayout.PREFERRED_SIZE)))
																														.addGroup(
																																jPanel1Layout
																																		.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.TRAILING,
																																				false)
																																		.addGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				jPanel1Layout
																																						.createSequentialGroup()
																																						.addComponent(
																																								jLabel6)
																																						.addPreferredGap(
																																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																						.addComponent(
																																								jLabel7,
																																								javax.swing.GroupLayout.DEFAULT_SIZE,
																																								javax.swing.GroupLayout.DEFAULT_SIZE,
																																								Short.MAX_VALUE))
																																		.addGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				jPanel1Layout
																																						.createSequentialGroup()
																																						.addGap(
																																								10,
																																								10,
																																								10)
																																						.addComponent(
																																								jScrollPane2,
																																								javax.swing.GroupLayout.PREFERRED_SIZE,
																																								505,
																																								javax.swing.GroupLayout.PREFERRED_SIZE))))))
																		.addGap(
																				56,
																				56,
																				56)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel9)
																						.addComponent(
																								jLabel8,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								76,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel14,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								76,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel16,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				366,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addComponent(
																jLabel5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																519,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jRadioButton5,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				140,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jRadioButton6,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				140,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jRadioButton7,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				141,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jRadioButton8,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				97,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addComponent(
																jScrollPane4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																519,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				69,
																				69,
																				69)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				100,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				154,
																				154,
																				154)
																		.addComponent(
																				jButton4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				100,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jLabel17,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												66,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(536, 536, 536))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(153, 153, 153)
										.addComponent(
												jButton9,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												224,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(403, 403, 403)
										.addComponent(
												jButton7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(112, 112, 112)
										.addComponent(
												jButton8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(705, Short.MAX_VALUE))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jLabel11,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel12,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								53,
																								Short.MAX_VALUE))
																		.addGap(
																				6,
																				6,
																				6)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel10,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								468,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(
																												31,
																												31,
																												31)
																										.addComponent(
																												jButton5,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												100,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												112,
																												112,
																												112)
																										.addComponent(
																												jButton6,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												100,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(
																				76,
																				76,
																				76)
																		.addComponent(
																				jLabel15,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				66,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				143,
																				143,
																				143)
																		.addComponent(
																				jRadioButton9,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				81,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jRadioButton10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				62,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				372,
																				372,
																				372)))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				0,
																				Short.MAX_VALUE))
														.addComponent(
																jLabel13,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																518,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(603, 603, 603)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				14,
																				14,
																				14)
																		.addComponent(
																				jLabel17,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				25,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				49,
																				49,
																				49))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel2,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel4,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								38,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel5,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								45,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel3,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel8,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jLabel6,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				35,
																																				Short.MAX_VALUE)
																																		.addGap(
																																				8,
																																				8,
																																				8))
																														.addGroup(
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jLabel16,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				32,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jScrollPane4,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																128,
																																Short.MAX_VALUE)
																														.addComponent(
																																jScrollPane2,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																128,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(
																												10,
																												10,
																												10)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jRadioButton1,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jRadioButton2,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jRadioButton3,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jRadioButton4,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jRadioButton5,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jRadioButton6,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jRadioButton7,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jRadioButton8,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																29,
																																Short.MAX_VALUE)))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel7,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												43,
																												Short.MAX_VALUE)
																										.addGap(
																												167,
																												167,
																												167)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jButton1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												34,
																												Short.MAX_VALUE)
																										.addGap(
																												17,
																												17,
																												17)
																										.addComponent(
																												jLabel11,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												39,
																												Short.MAX_VALUE))
																						.addComponent(
																								jButton2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								34,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																false)
																														.addComponent(
																																jButton4,
																																javax.swing.GroupLayout.Alignment.LEADING,
																																0,
																																34,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton3,
																																javax.swing.GroupLayout.Alignment.LEADING,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																34,
																																Short.MAX_VALUE))
																										.addGap(
																												40,
																												40,
																												40))))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel9)
																		.addGap(
																				268,
																				268,
																				268)
																		.addComponent(
																				jLabel14,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel13,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												65,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jScrollPane1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												221,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel12,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jLabel10,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																154,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(
																												18,
																												18,
																												18)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jRadioButton10,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jRadioButton9,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jButton6,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																34,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jButton5,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																34,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(
																												61,
																												61,
																												61)))
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jButton9,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								73,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																										.addComponent(
																												jButton7,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												34,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												jButton8,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												34,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(
																				709,
																				709,
																				709))
														.addComponent(
																jLabel15,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(jPanel1,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 848,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tempcount3++;
		goStart2(jLabel2.getText());
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tempcount3--;
		goStart3(jLabel2.getText());
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tempcount2++;
		goStart2(jLabel2.getText());
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tempcount2--;
		goStart2(jLabel2.getText());
	}

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		goEnd();
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tempcount1++;
		goStart1(jLabel2.getText());
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tempcount1--;
		goStart1(jLabel2.getText());
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tempcount++;
		goStart(jLabel2.getText());
		tempResult();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tempcount--;
		goStart(jLabel2.getText());
		tempResult();
	}

	/**
	 * @param args the command line arguments
	 */

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton10;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JRadioButton jRadioButton5;
	private javax.swing.JRadioButton jRadioButton6;
	private javax.swing.JRadioButton jRadioButton7;
	private javax.swing.JRadioButton jRadioButton8;
	private javax.swing.JRadioButton jRadioButton9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextArea jTextArea2;
	private javax.swing.JTextArea jTextArea4;
	// End of variables declaration//GEN-END:variables

}
