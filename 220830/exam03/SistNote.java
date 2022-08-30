package exam03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SistNote extends JFrame {
	private JTextArea jta;
	
	public SistNote() {
		setTitle("메모장");
		JTextArea jta = new JTextArea(10,80);
		JScrollPane sj = new JScrollPane(jta);
		add(sj);
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		JMenuItem file_exit = new JMenuItem("종료");
		
		file.add(file_new);
		file.add(file_open);
		file.add(file_save);
		file.add(file_exit);
		
		file_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("");
				
				
			}
		});
		file_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String data = "";
					int ch;
					
					FileReader fr = new FileReader("memo.txt");
					while (true) {
						ch = fr.read();
						data += (char)ch;
						if (ch == -1)
							break;
					}
					fr.close();
					jta.setText(data);
					JOptionPane.showMessageDialog(null, "파일을 읽어왔음.");
				}catch (Exception e1) {
					System.out.println("오류발생 : " + e1.getMessage());
				}
				System.out.println("새파일 생성");
			}
		});
		file_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = jta.getText();
				//memo.txt
				try {
				FileWriter fw = new FileWriter("memo.txt");
				fw.write(data);
				fw.close();
				System.out.println("파일을 저장");
				}catch (Exception e1) {
					System.out.println("에러 발생 :  " + e1.getMessage());
				}				
			}
		});
		file_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		
		
		jmb.add(file);
		
		setJMenuBar(jmb);		//frame 메뉴바 설정
		
		add(jta);
		setSize(400, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new SistNote();
		
	}
}

