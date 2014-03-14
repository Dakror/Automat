package de.dakror.automat;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import de.dakror.automat.tool.Tool;

public class EditorPane extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	
	public EditorPane()
	{
		setBackground(Color.white);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setLayout(null);
		addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{}
	
	@Override
	public void mouseExited(MouseEvent e)
	{}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		if (Automat.currentAutomat.selectedTool != null)
		{
			add(Tool.getToolForName(Automat.currentAutomat.selectedTool, e.getX(), e.getY()));
			Automat.currentAutomat.selectedTool = null;
			repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{}
}
