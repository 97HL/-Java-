package User;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.nio.channels.Channel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import Shujuku.Shujukulianjie;
import View.Datastatistics;

public class MyChartPanel {
	ChartPanel frame1;
	public  MyChartPanel() throws ClassNotFoundException, SQLException{//����ͼ
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "�ɼ�ͼ", // ͼ�����
                            "ѧ����", // Ŀ¼�����ʾ��ǩ
                            "�ɼ�", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                            false,          // �Ƿ����ɹ���
                            false           // �Ƿ�����URL����
                            );
        
        //�����￪ʼ
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
          
          //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������
          
         frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame
         
	}
	private  CategoryDataset getDataSet() throws ClassNotFoundException,SQLException {//��ѯ���ݿ�
DefaultCategoryDataset dataset = new DefaultCategoryDataset();
ArrayList<Student> list = new ArrayList<Student>();
String sql = null;
Student stu = null;
Shujukulianjie a;
Statement stmt;
String name;
String score;
a = new Shujukulianjie();
stmt = a.conn.createStatement();
sql = "select * from score ";
ResultSet rs = stmt.executeQuery(sql);
while (rs.next()) {
	name = rs.getString("name");
	score = rs.getString("score");
	stu = new Student(name, score);
	list.add(stu);
	dataset.addValue(Double.parseDouble(score), name, name);
}

return dataset;
}
public Component getChartPanel(){
	return frame1;
	
}
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	JFrame frame = new JFrame("����ͳ��");
	    frame.add(new MyChartPanel().getChartPanel()); // �������ͼ
	    frame.setBounds(50, 50, 800, 600);
	    frame.setVisible(true);
	}
}

        
            
          
            
