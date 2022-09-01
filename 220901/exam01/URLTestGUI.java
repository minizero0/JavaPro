package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteOrder;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLTestGUI extends JFrame {
	private JTextArea jta;
	private JTextField jtf;

	public URLTestGUI() {
		jta = new JTextArea();
		jtf = new JTextField();
		JButton btn = new JButton("읽어오기");
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(jtf, BorderLayout.CENTER);
		p.add(btn, BorderLayout.EAST);
	
		
		JScrollPane jsp = new JScrollPane(jta);
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int re = JOptionPane.showConfirmDialog(null, "검색합니까?");
				if(re == 0) {
					String name = jtf.getText();  //TextField에 입력된 문자열로 name 초기화
					try {
						URL url = new URL(name);
						InputStream is = url.openStream();
						byte data[] = new byte[200];
						String str = "";
//						String line = "";
						while (is.read(data) != -1) {
							str += new String(data);
//							str += line;
							Arrays.fill(data, (byte)0);   //배열 초기화
						}
						jta.setText(str);
						is.close();
					}catch(Exception ex) {
						System.out.println("예외발생:" + ex.getMessage());
					}
				}
				
			}
		});
	}
	public static void main(String[] args) {
		new URLTestGUI();

	}

}
