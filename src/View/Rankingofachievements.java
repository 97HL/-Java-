/*
 * Rankingofachievements.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import Shujuku.Shujukulianjie;
import User.Student;

/**
 *
 * @author  __USER__
 */
public class Rankingofachievements extends javax.swing.JFrame {

	/** Creates new form Rankingofachievements */
	public Rankingofachievements(String a) {
		initComponents();
		jLabel5.setText(a);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();  
	    this.setLocation((scrSize.width)/2, (scrSize.height)/2);
	    this.setResizable(false);
		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/������ҳ.png"))); // NOI18N
		jButton1.setActionCommand("");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel1.setText("\u6210\u7ee9\u6392\u540d\u67e5\u8be2");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel2.setText("\u8bd5\u5377\u540d\uff1a");

		jButton2.setBackground(new java.awt.Color(102, 255, 102));
		jButton2.setText("\u67e5\u8be2");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton2ActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jLabel3.setText("\u6210\u7ee9\u548c\u6392\u540d\uff1a");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } , { null, null, null, null }, { null, null, null, null }
						, { null, null, null, null }
						, { null, null, null, null }, { null, null, null, null }
						, { null, null, null, null }
						, { null, null, null, null }
						, { null, null, null, null }, { null, null, null, null }
						, { null, null, null, null }
						, { null, null, null, null }}, new String[] { "����",
						"�ɼ�" }));
		jScrollPane1.setViewportView(jTable1);

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
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				98,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel1)
																		.addGap(
																				78,
																				78,
																				78)
																		.addComponent(
																				jLabel5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				56,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				79,
																				79,
																				79)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel3)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jScrollPane1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												550,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												284,
																												Short.MAX_VALUE)))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												76,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																71,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabel6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																71,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
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
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLabel5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				25,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jButton1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				26,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel1))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				32,
																				32,
																				32)
																		.addComponent(
																				jLabel4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				17,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				12,
																				12,
																				12)
																		.addComponent(
																				jLabel6,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				17,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				164,
																				164,
																				164))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jScrollPane1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								228,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel3))
																		.addGap(
																				14,
																				14,
																				14)))
										.addContainerGap(68, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 413,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new Studenthome(jLabel5.getText()).setVisible(true);
		this.dispose();
	}

	public ArrayList<Student> select_rank() throws ClassNotFoundException {//��ѯѧ�������һ��������
		ArrayList<Student> list = new ArrayList<Student>();
		String papername = jTextField1.getText();
		String sql = null;
		Student stu = null;
		Shujukulianjie a;
		Statement stmt;
		String name;
		String score;
		try {
			a = new Shujukulianjie();
			stmt = a.conn.createStatement();
			sql = "select * from " + papername + "score ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				name = rs.getString("name");
				score = rs.getString("score");
				stu = new Student(name, score);
				list.add(stu);
			}
		} catch (SQLException sqle) {
			System.err.println("[mydb172017278]����: " + sqle.getMessage());
			JOptionPane.showConfirmDialog(this, "���Ծ�������");
		}
		return list;
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
			throws ClassNotFoundException {
		// TODO add your handling code here:
		ArrayList<Student> list = select_rank();
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int i = Integer.valueOf(o2.getScore()).intValue()
						- Integer.valueOf(o1.getScore()).intValue();
				if (i == 0) {
					return Integer.valueOf(o2.getNams()).intValue()
							- Integer.valueOf(o1.getNams()).intValue();
				}
				return i;

			}

		});
		for (int i = 0; i < list.size(); i++) {
			jTable1.setValueAt(list.get(i).getNams(), i, 0);
			jTable1.setValueAt(list.get(i).getScore(), i, 1);

		}

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
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}