package exam06;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseListener{

	private int x1,x2,y1,y2;
	private ArrayList<GraphicInfo> list;
	
	public LinePanel() {
		addMouseListener(this);
		list = new ArrayList<GraphicInfo>();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		for (int i = 0; i < list.size(); i++) {
			GraphicInfo info = list.get(i);
			g.drawLine(info.getX1(), info.getY1(), info.getX2(), info.getY2());
		}
		
//		Iterator<GraphicInfo> iter = list.iterator();
//		while (iter.hasNext()) {
//			iter.next();
//			GraphicInfo ls = iter.next();
//			
//			g.drawLine(ls.getX1(), ls.getY1(), ls.getX2(), ls.getY2());
//			paintAll(g);
//		}
		
		
		
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
		//GraphicInfo 객체 생성하여 리스트에 담는다. 
		list.add(new GraphicInfo(x1, y1, x2, y2));
		
		
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
