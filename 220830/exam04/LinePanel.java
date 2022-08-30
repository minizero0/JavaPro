package exam04;

import java.awt.Graphics;

import javax.swing.JPanel;

public class LinePanel extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawLine(100, 100, 200, 100);
	}


}
