package exam01;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class DrawPanel extends JPanel implements MouseListener{
	private int x1,x2,y1,y2;
	int drawType;		//접근명시자 생략시 같은 패키지내에 공유 허용

	public DrawPanel() {
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
//		g.drawLine(x1,y1,x2,y2);
		int width = x2-x1;
		int height = y2-y1;
		int x = x1;
		int y = y1;
		
		if(x1>x2) {
			width = x1 - x2;
			x = x2;
		}
		if(y1>y2) {
			height = y1 - y2;
			y = y2;
		}
//		g.drawRect(x, y, width, height);
		g.drawOval(x, y, width, height);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	


}
