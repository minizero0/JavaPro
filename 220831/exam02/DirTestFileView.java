package exam02;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DirTestFileView extends JFrame{
	
	private JList<String> list;
	private JTextArea jta;
	
	public DirTestFileView() {
		setLayout(new BorderLayout());
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		 
		
		File dir = new File("/Users/mini0/eclipse-workspace/JavaProgramming/src/SsangYong220810"); 
		String data[] = dir.list();
		list = new JList<String>(data);
		JScrollPane jsp_list = new JScrollPane(list);
		add(jsp_list, BorderLayout.WEST);
		add(jsp, BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DirTestFileView();
	}

}
