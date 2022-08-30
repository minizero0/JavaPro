package TeamExam03;

import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JPanel;

import exam07.GraphicInfo;

public class LinePanel extends JPanel implements MouseListener{
	Scanner sc = new Scanner(System.in);
	private int x1,x2,y1,y2;
	HashSet<Integer> hs;
	ArrayList<GraphicInfo> list;
	
	public LinePanel() {
		addMouseListener(this);
		list = new ArrayList<GraphicInfo>();
		hs = new HashSet<Integer>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Iterator<Integer> iter = hs.iterator();
		
		while(iter.hasNext()) {
			switch (iter.next()) {
				case 0:g.drawOval(x1, y1, x2-x1, y2-y1);
				case 1:g.drawRect(x1, y1, x2-x1, y2-y1);
			}
		}
		
//		g.drawRect(x1, y1, 100, 200);
		
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
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
