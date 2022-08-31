package Prac;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DirTextFileViewVector_Prac extends JFrame{
	
	private JList<String> list;
	private JTextArea jta;
	Vector<String> vector;
	
	public DirTextFileViewVector_Prac() {
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		vector = new Vector<String>();
		setLayout(new BorderLayout());
		
		File dir = new File("/Users/mini0/Desktop/SsangYong220810");
		String data[] = dir.list();
		for(String fname : data) {
			vector.add(fname);
		}
		
		list = new JList<String>(vector);
		
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				String fname = list.getSelectedValue();
				try {
					FileReader fr = new FileReader("/Users/mini0/Desktop/SsangYong220810/" + fname);
					int ch;
					String str = "";
					while((ch =fr.read()) != -1)
						str += (char)ch;
					jta.setText(str);
					fr.close();
					
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JPanel p_center = new JPanel();
		JScrollPane jsp_list = new JScrollPane(list);
		p_center.setLayout(new BorderLayout());
		p_center.add(jsp_list, BorderLayout.WEST);
		p_center.add(jsp, BorderLayout.CENTER);
		
		JButton btn_delete = new JButton("파일 삭제");
		p_center.add(btn_delete, BorderLayout.SOUTH);
		add(p_center, BorderLayout.CENTER);
		
		btn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int re = JOptionPane.showConfirmDialog(null, "파일삭제?");
				if (re == 0) {
					String fname = list.getSelectedValue();
					
					File file = new File("/Users/mini0/Desktop/SsangYong220810/"+fname);
					file.delete();
					JOptionPane.showMessageDialog(null, "삭제성공");
					
					vector.clear();
					File dir = new File("/Users/mini0/Desktop/SsangYong220810");
					String data[] = dir.list();
					for (String fn:data)
						vector.add(fn);
					list.updateUI();
					jta.setText("");
					
						
				}
				
			}
		});
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		 new DirTextFileViewVector_Prac();

	}

}
