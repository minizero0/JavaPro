package exam02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DeleteFrame extends JFrame{
	
	JButton btn01,btn02;
	
	public DeleteFrame() {
		setLayout(new FlowLayout());
		
		btn01 = new JButton("bus.sist삭제");
		btn02 = new JButton("Helel삭제");
		add(btn01);
		add(btn02);
		
		btn01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int re = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠어요?");
				if (re == 0) {
					File file = new File("/Users/mini0/Desktop/bus.sist");
					file.delete();
					JOptionPane.showMessageDialog(null, "파일을 삭제했습니다.");
				}
				
			}
		});
		btn02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int re = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠어요?");
				if (re == 0) {
					File file = new File("/Users/mini0/Desktop/helel");
					file.delete();
					JOptionPane.showMessageDialog(null, "파일을 삭제했습니다.");
				}
				
			}
		});
		
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DeleteFrame();
	}

}
