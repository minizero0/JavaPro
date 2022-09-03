package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.ByteOrder;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLTestGUI extends JFrame {
	private JTextArea jta;
	private JTextField jtf;
	private JFileChooser jfc;
	private JFrame f;

	public URLTestGUI() {
		jta = new JTextArea();
		jtf = new JTextField();
		jfc = new JFileChooser();
		JButton btn_read = new JButton("읽어오기");
		JButton btn_save = new JButton("저장하기");
		
		f= this;
		
		JPanel p = new JPanel();
		JPanel Bt = new JPanel();
		
		p.setLayout(new BorderLayout());
		p.add(jtf, BorderLayout.CENTER);
		p.add(Bt, BorderLayout.EAST);
		Bt.add(btn_read, BorderLayout.WEST);
		Bt.add(btn_save, BorderLayout.EAST);
		
	
		
		JScrollPane jsp = new JScrollPane(jta);
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_read.addActionListener(new ActionListener() {
			
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
		
		btn_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int re = jfc.showSaveDialog(null);
					if (re == JFileChooser.APPROVE_OPTION) {
						File file = jfc.getSelectedFile();
						FileWriter fw = new FileWriter(file);
						fw.write(jta.getText());
						fw.close();
						JOptionPane.showMessageDialog(null, "저장완료");
					}
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
			}
		});
	}
	public static void main(String[] args) {
		new URLTestGUI();

	}

}
