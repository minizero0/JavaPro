package exam02;

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

public class DirTestFileViewVector extends JFrame{
	
	private JList<String> list;
	private JTextArea jta;
	Vector<String> vector;
	
	public DirTestFileViewVector() {
		setLayout(new BorderLayout());
		jta = new JTextArea();
		vector = new Vector<String>();
		JScrollPane jsp = new JScrollPane(jta);
		
		File dir = new File("/Users/mini0/Desktop/SsangYong220810"); 
		String data[] = dir.list();
		for (String fname:data) {
			vector.add(fname);
		}
		list = new JList<String>(vector);
		
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Ok");
				String fname = list.getSelectedValue();
				
				try {
					FileReader fr = new FileReader("/Users/mini0/Desktop/SsangYong220810/" +fname);
					int ch;
					String str = "";
					while ((ch = fr.read()) != -1) {
						str += (char)ch;
					}
					jta.setText(str);
					fr.close();
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
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
		
		JScrollPane jsp_list = new JScrollPane(list);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(jsp_list, BorderLayout.WEST);
		p_center.add(jsp, BorderLayout.CENTER);
		
		JButton btn_delete = new JButton("파일 삭제");
		add(p_center, BorderLayout.CENTER);
		add(btn_delete, BorderLayout.SOUTH);
		
		btn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int re =  JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?");
				if(re == 0) {
					String fname = list.getSelectedValue();
					File file = new File("/Users/mini0/Desktop/SsangYong220810/" + fname);
					file.delete();
					
					JOptionPane.showMessageDialog(null, "선택한 파일이 삭제되었습니다.");
					
					vector.clear();
					File dir = new File("/Users/mini0/Desktop/SsangYong220810");
					String arr[] = dir.list();
					for(String name:arr) {
						vector.add(name);
					}
					list.updateUI();
					jta.setText("");
				}
			}
		});
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //창을 닫을때 자동으로 프로그램 종료
	}

	public static void main(String[] args) {
		new DirTestFileViewVector();
	}

}
