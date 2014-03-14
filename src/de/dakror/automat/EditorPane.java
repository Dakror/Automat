package de.dakror.automat;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import de.dakror.automat.tool.Tool;

public class EditorPane extends JPanel implements MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	
	Point mouse;
	
	public EditorPane()
	{
		setBackground(Color.white);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if (Automat.currentAutomat.selectedTool != null && mouse != null)
		{
			Stroke stroke = ((Graphics2D) g).getStroke();
			((Graphics2D) g).setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 1 }, 0));
			Tool tool = Tool.getToolForName(Automat.currentAutomat.selectedTool, mouse.x, mouse.y);
			g.drawRect(mouse.x, mouse.y, tool.getWidth(), tool.getHeight());
			((Graphics2D) g).setStroke(stroke);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		mouse = null;
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		if (Automat.currentAutomat.selectedTool != null)
		{
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				add(Tool.getToolForName(Automat.currentAutomat.selectedTool, e.getX(), e.getY()));
				Automat.currentAutomat.selectedTool = null;
			}
			else Automat.currentAutomat.selectedTool = null;
			repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouse = e.getPoint();
		if (Automat.currentAutomat.selectedTool != null) repaint();
	}
}
