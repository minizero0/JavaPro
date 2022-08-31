package exam01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DrawPanel extends JPanel implements MouseListener{
	private int x1,x2,y1,y2;
	int drawType;		//접근명시자 생략시 같은 패키지내에 공유 허용
	Color drawColor;

	ArrayList<GraphicInfo> list;
	
	public DrawPanel() {
		addMouseListener(this);
		list = new ArrayList<GraphicInfo>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		/*
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
		
		g.setColor(drawColor);
		
		
		switch(drawType) {
			case 0:g.drawLine(x1, y1, x2, y2);break;
			case 1:g.drawRect(x, y, width, height);break;
			case 2:g.drawOval(x, y, width, height);break;
		}
		*/
		for (int i = 0; i < list.size(); i++) {
			GraphicInfo info = list.get(i);
			int x = info.getX1();
			int y = info.getY1();
			int width = info.getX2() - info.getX1();
			int height = info.getY2() - info.getY1();
			
			if (info.getX1()>info.getX2()) {
				x = info.getX2();
				width = info.getX1() - info.getX2();
			}
			if (info.getY1()>info.getY2()) {
				y = info.getY2();
				width = info.getY1() - info.getY2();
			}
			g.setColor(info.getDrawColor());
			
			switch (info.getDrawType()) {
				case 0:g.drawLine(info.getX1(), info.getY1(), info.getX2(), info.getY2());break;
				case 1:g.drawRect(x, y, width, height);break;
				case 2:g.drawOval(x, y, width, height);break;
			}
		}
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
		list.add(new GraphicInfo(x1, y1, x2, y2, drawType, drawColor));
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
