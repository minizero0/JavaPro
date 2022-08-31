package exam02;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectOutputStream;

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
		 
		File dir = new File("/Users/mini0/Desktop/SsangYong220810"); 
		
		String data[] = dir.list();
		list = new JList<String>(data);
		
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
		add(jsp_list, BorderLayout.WEST);
		add(jsp, BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //창을 닫을때 자동으로 프로그램 종료
	}

	public static void main(String[] args) {
		new DirTestFileView();
	}

}
