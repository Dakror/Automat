package de.dakror.automat.tool;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import de.dakror.automat.Automat;
import de.dakror.automat.ToolFactory;

public class Tool extends JLabel
{
	private static final long serialVersionUID = 1L;
	
	public Tool(int x, int y, String tool)
	{
		int size = 32;
		setName(tool);
		setBounds(x, y, size, size);
		setIcon(new ImageIcon(ToolFactory.getImageForTool(tool, size, "")));
		
		if (tool.equals("Zustand"))
		{
			int i = 0;
			for (Component c : Automat.currentAutomat.editorPane.getComponents())
				if (c.getName().equals("Zustand")) i++;
			
			setIcon(new ImageIcon(ToolFactory.getImageForTool(tool, size, i + "")));
		}
		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) showDialog();
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					Automat.currentAutomat.editorPane.remove(Tool.this);
					Automat.currentAutomat.editorPane.repaint();
				}
			}
		});
	}
	
	protected void showDialog()
	{}
	
	public static Tool getToolForName(String name, int x, int y)
	{
		if (name.equals("Knopf")) return new Button(x, y);
		
		return new Tool(x, y, name);
	}
}
