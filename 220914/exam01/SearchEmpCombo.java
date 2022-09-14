package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SearchEmpCombo extends JFrame {
	
	JTable table;
	Vector<Vector<String>> vector;
	Vector<String> colName;
	JComboBox<String> jcb;
	EmpDAO dao = new EmpDAO();
	ArrayList<EmpVO> list;
	
	public void list() {
		vector.clear();
		String name = jcb.getSelectedItem().toString();
		list = dao.searchEmp(name);
		for(EmpVO e: list) {
			Vector<String> v = new Vector<>();
			v.add(e.getEname());
			v.add(e.getSalary()+"");
			v.add(e.getAddr());
			v.add(e.getHiredate()+"");
			vector.add(v);
		}
		
	}
	
	public SearchEmpCombo() {
		String data[] = {"plan", "develop1", "develop2", "chongmu"};
		setLayout(new BorderLayout());
		jp.setLayout(new FlowLayout());
		jcb = new JComboBox<String>(data);
		list = new ArrayList<>();
		
		vector = new Vector<>();
		colName = new Vector<>();
		colName.add("이름");
		colName.add("급여");
		colName.add("주소");
		colName.add("입사일");
		
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				list();
				table.updateUI();
			}
		});
		
		table = new JTable(vector, colName);
		JScrollPane jsp = new JScrollPane(table);
		
		
		add(jcb, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new SearchEmp();
	}
}
