package exam01;

import java.awt.Graphics;

import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class DrawPanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawLine(100, 100, 200, 100);
	}
	
	
	
	


}
