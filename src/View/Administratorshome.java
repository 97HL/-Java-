/*
 * Administratorshome.java
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

import javax.swing.JOptionPane;

import Shujuku.Shujukulianjie;

/**
 *
 * @author  __USER__
 */
public class Administratorshome extends javax.swing.JFrame {

	/** Creates new form Administratorshome */
	public Administratorshome(String a) {
		initComponents();
		jLabel6.setText(a);
		jLabel16.setText(a);
		jLabel18.setText(a);
	}

//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();  
	    this.setLocation((scrSize.width)/2, (scrSize.height)/2);
	    this.setResizable(false);
		jPanel1 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField10 = new javax.swing.JTextField();
		jLabel20 = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();
		jLabel12 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel16 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		jPanel7 = new javax.swing.JPanel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jTextField9 = new javax.swing.JTextField();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton8 = new javax.swing.JButton();
		jLabel19 = new javax.swing.JLabel();
		jButton9 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTabbedPane1.setBackground(new java.awt.Color(63, 81, 181));
		jTabbedPane1.setOpaque(true);

		jPanel4.setBackground(new java.awt.Color(233, 239, 254));

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel1.setText("\u771f\u5b9e\u59d3\u540d:");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel2.setText("\u8d26\u53f7:");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel3.setText("\u5bc6\u7801:");

		jButton1.setBackground(new java.awt.Color(123, 180, 197));
		jButton1.setForeground(new java.awt.Color(255, 255, 255));
		jButton1.setText("\u67e5\u8be2");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setBackground(new java.awt.Color(123, 180, 197));
		jButton2.setForeground(new java.awt.Color(255, 255, 255));
		jButton2.setText("\u5220\u9664");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setBackground(new java.awt.Color(123, 180, 197));
		jButton3.setForeground(new java.awt.Color(255, 255, 255));
		jButton3.setText("\u589e\u52a0");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton3ActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jLabel5.setText("\u6b22\u8fce\u7ba1\u7406\u5458:");

		jLabel6.setText("jLabel6");

		jLabel7.setText("\u589e\u52a0\u65f6\u8bf7\u9009\u62e9\u73ed\u7ea7");

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel4.setText("\u73ed\u7ea7\uff1a");

		jLabel20
				.setText("\u67e5\u8be2\u548c\u5220\u9664\u8bf7\u6839\u636e\u540d\u5b57");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel6))
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addGap(
																				22,
																				22,
																				22)
																		.addGroup(
																				jPanel4Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								jPanel4Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jButton1)
																										.addGroup(
																												jPanel4Layout
																														.createSequentialGroup()
																														.addGap(
																																39,
																																39,
																																39)
																														.addComponent(
																																jButton3)))
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel7)
																														.addComponent(
																																jLabel20))
																										.addGap(
																												2,
																												2,
																												2)))
																		.addComponent(
																				jButton2)))
										.addContainerGap(658, Short.MAX_VALUE))
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGap(28, 28, 28)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel4)
																		.addContainerGap())
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel4Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												182,
																												Short.MAX_VALUE))
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								jLabel3)
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addComponent(
																												jTextField2,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												182,
																												Short.MAX_VALUE))
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jTextField3,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																182,
																																Short.MAX_VALUE)
																														.addComponent(
																																jTextField10,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																182,
																																javax.swing.GroupLayout.PREFERRED_SIZE))))
																		.addGap(
																				639,
																				639,
																				639)))));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGap(14, 14, 14)
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel4)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField10,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jLabel20)
										.addGap(7, 7, 7)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton2)
														.addComponent(jButton1))
										.addGap(17, 17, 17)
										.addComponent(jLabel7)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												134, Short.MAX_VALUE)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(jLabel6))));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jTabbedPane1.addTab("\u7ba1\u7406\u5b66\u751f", jPanel2);

		jPanel5.setBackground(new java.awt.Color(233, 239, 254));

		jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel8.setText("\u771f\u5b9e\u59d3\u540d:");

		jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel9.setText("\u8d26\u53f7:");

		jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
		jLabel10.setText("\u5bc6\u7801:");

		jLabel11.setText("\u5f00\u8bbe\u7684\u73ed\u7ea7:");

		jButton4.setBackground(new java.awt.Color(123, 180, 197));
		jButton4.setForeground(new java.awt.Color(255, 255, 255));
		jButton4.setText("\u67e5\u8be2");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jLabel12.setText("\u6b22\u8fce\u7ba1\u7406\u5458:");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }
						, { null, null, null, null }
						, { null, null, null, null }
						, { null, null, null, null }}, new String[] { "班级名",
						"人数", }));
		jScrollPane2.setViewportView(jTable1);

		jLabel21
				.setText("\u67e5\u8be2\u548c\u5220\u9664\u8bf7\u6839\u636e\u540d\u5b57");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap(713, Short.MAX_VALUE)
										.addComponent(jLabel12)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jLabel16,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												55,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(21, 21, 21))
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addComponent(
																				jTextField4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				155,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel8))
										.addContainerGap(682, Short.MAX_VALUE))
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addComponent(
																				jTextField5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				155,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel9))
										.addContainerGap(682, Short.MAX_VALUE))
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel10)
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addGroup(
																				jPanel5Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel5Layout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addComponent(
																												jLabel21))
																						.addComponent(
																								jTextField6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								155,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(682, Short.MAX_VALUE))
						.addGroup(
								jPanel5Layout.createSequentialGroup().addGap(
										60, 60, 60).addComponent(jButton4)
										.addContainerGap(742, Short.MAX_VALUE))
						.addGroup(
								jPanel5Layout.createSequentialGroup()
										.addContainerGap().addComponent(
												jLabel11).addContainerGap(784,
												Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												835, Short.MAX_VALUE)
										.addContainerGap()));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel8)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel9)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel10)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabel21)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton4)
										.addGap(22, 22, 22)
										.addComponent(jLabel11)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												179,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												36, Short.MAX_VALUE)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jLabel16,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel12,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jTabbedPane1.addTab("\u7ba1\u7406\u8001\u5e08", jPanel3);

		jPanel7.setBackground(new java.awt.Color(233, 239, 254));

		jLabel17.setText("\u6b22\u8fce\u7ba1\u7406\u5458:");

		jLabel18.setText("jLabel18");

		jLabel14.setText("\u8bf7\u8f93\u5165\u8001\u5e08\u540d\uff1a");

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } , { null, null, null, null }
						, { null, null, null, null }
						, { null, null, null, null }
						, { null, null, null, null }}, new String[] { "试卷名",
						 }));
		jScrollPane3.setViewportView(jTable2);

		jButton8.setBackground(new java.awt.Color(123, 180, 197));
		jButton8.setForeground(new java.awt.Color(255, 255, 255));
		jButton8.setText("\u5220\u9664");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jLabel19.setText("\u8bf7\u9009\u62e9\u8bd5\u5377\u540d");

		jButton9.setBackground(new java.awt.Color(123, 180, 197));
		jButton9.setForeground(new java.awt.Color(255, 255, 255));
		jButton9.setText("\u67e5\u8be2");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		jButton10.setBackground(new java.awt.Color(123, 180, 197));
		jButton10.setForeground(new java.awt.Color(255, 255, 255));
		jButton10.setText("\u589e\u52a0");
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout
				.setHorizontalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel7Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel17)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabel18)
																		.addGap(
																				45,
																				45,
																				45))
														.addGroup(
																jPanel7Layout
																		.createSequentialGroup()
																		.addGap(
																				49,
																				49,
																				49)
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel14)
																						.addGroup(
																								jPanel7Layout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addComponent(
																												jTextField9,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												200,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												27,
																												27,
																												27)
																										.addComponent(
																												jButton9,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												93,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jLabel19))
																		.addContainerGap(
																				480,
																				Short.MAX_VALUE))))
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addGap(163, 163, 163)
										.addComponent(
												jButton10,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												81,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												284, Short.MAX_VALUE)
										.addComponent(
												jButton8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												81,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(250, 250, 250)).addGroup(
								jPanel7Layout.createSequentialGroup().addGap(
										69, 69, 69).addComponent(jScrollPane3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										674,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(116, Short.MAX_VALUE)));
		jPanel7Layout
				.setVerticalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel7Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel14)
										.addGap(10, 10, 10)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton9))
										.addGap(18, 18, 18)
										.addComponent(jLabel19)
										.addGap(18, 18, 18)
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												263,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(23, 23, 23)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton10)
														.addComponent(jButton8))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												76, Short.MAX_VALUE)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel17)
														.addComponent(jLabel18))));

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jTabbedPane1.addTab("\u7ba1\u7406\u8bd5\u5377", jPanel6);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 864,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new Outoftestpaper(jTextField9.getText()).setVisible(true);
	}

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String tname = jTextField9.getText();
		try {
			Shujukulianjie a = new Shujukulianjie();
			ArrayList<Paper> list = new ArrayList<Paper>();
			Paper b;
			Statement stmt;
			stmt = a.conn.createStatement();
			String sql = "select*from " + tname + "depaper";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String papername = rs.getString("papername");
				b = new Paper(papername);
				list.add(b);
			}
			for (int i = 0; i < list.size(); i++) {
				jTable2.setValueAt(list.get(i).getPapername(), i, 0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "你还没有试卷");
		}
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int row = jTable2.getSelectedRow();
		String tname = jTextField9.getText();
		try {
			Shujukulianjie a = new Shujukulianjie();
			Statement stmt;
			stmt = a.conn.createStatement();
			String sql = "DELETE FROM " + tname + "depaper where papername="
					+ jTable2.getValueAt(row, 0) + "";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(this, "删除成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "你还没有试卷");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "你还没有试卷");
		}
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String name = jTextField4.getText();
		String id = null;
		String pwe = null;
		try {
			Shujukulianjie a = new Shujukulianjie();
			Statement stmt = a.conn.createStatement();
			String sql = "SELECT * FROM teacherlist where tname='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString(1);
				pwe = rs.getString(3);
			}
			jTextField5.setText(id);
			jTextField6.setText(pwe);
			String sql1 = "select*from " + name + " ";
			Statement stmt1;
			try {
				a = new Shujukulianjie();
				stmt = a.conn.createStatement();
				ResultSet rs1 = stmt.executeQuery(sql1);
				ArrayList<Wodeshujia> list = new ArrayList<Wodeshujia>();
				Wodeshujia wodeshujia;
				while (rs1.next()) {
					String classname = rs1.getString("classname");
					String classnumber = rs1.getString("classnumber");
					wodeshujia = new Wodeshujia(classname, classnumber);
					list.add(wodeshujia);
				}
				for (int i = 0; i < list.size(); i++) {
					jTable1.setValueAt(list.get(i).getClassname(), i, 0);
					jTable1.setValueAt(list.get(i).getClassnumber(), i, 1);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					a = new Shujukulianjie();
					stmt = a.conn.createStatement();
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(this,
							"你还没创建班级，已帮你创建，请按修改添加班级");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
			throws ClassNotFoundException, SQLException {
		// TODO add your handling code here:
		String name = jTextField1.getText();
		String id = jTextField2.getText();
		String pwe = jTextField3.getText();
		String banji = jTextField10.getText();
		Shujukulianjie a = new Shujukulianjie();
		String sql;
		Statement stmt = null;
		if (evt.getSource().equals(jButton3)) {
			if (name.equals("") || id.equals("") || pwe.equals("")) {
				JOptionPane.showMessageDialog(this, "存在信息没输入");
			} else if (name != null && pwe != null && id != null) {
				try {
					stmt = a.conn.createStatement();
					sql = "insert into studentlist(sid,Sname,spw,class) values('"
							+ Integer.parseInt(id)
							+ "','"
							+ name
							+ "','"
							+ pwe
							+ "','" + banji + "')";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(this, "增加成功");
					dispose();
					new home().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, "账号已存在");

				}
			}
		}

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String name = jTextField1.getText();
		Shujukulianjie a;
		try {
			a = new Shujukulianjie();
			Statement stmt = a.conn.createStatement();
			String sql = "DELETE FROM studentlist where Sname='" + name + "'";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(this, "删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "删除失败");
		}

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String name = jTextField1.getText();
		String id = null;
		String pwe = null;
		String sclass = null;
		try {
			Shujukulianjie a = new Shujukulianjie();
			Statement stmt = a.conn.createStatement();
			String sql = "SELECT * FROM studentlist where Sname='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString(1);
				pwe = rs.getString(3);
				sclass = rs.getString(4);
			}
			jTextField2.setText(id);
			jTextField3.setText(pwe);
			jTextField10.setText(sclass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "查询失败");
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
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField9;
	// End of variables declaration//GEN-END:variables

}