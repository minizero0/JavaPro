package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Hoemwork01 extends JFrame{
	
	Vector<Vector<String>> vector;
	Vector<String> colName;
	JTable table;
	JTextField jtf;
	
	public void search() {
		
	}
	
	public Hoemwork01() {
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		vector = new Vector<>();
		colName = new Vector<>();
		jtf = new JTextField();
		
		
		table = new JTable(vector, colName);
		JScrollPane jsp = new JScrollPane(table);
		
		
		
		JButton btn = new JButton("검색");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
				table.updateUI();
				
			}
		});
		
		jp.add(jtf);
		jp.add(btn);
		add(jp, BorderLayout.SOUTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new Hoemwork01();
	}
}