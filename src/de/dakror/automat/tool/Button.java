package de.dakror.automat.tool;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import de.dakror.automat.Automat;
import de.dakror.automat.ToolFactory;


public class Button extends Tool
{
	private static final long serialVersionUID = 1L;
	
	public Button(int x, int y)
	{
		super(x, y, "Knopf");
	}
	
	@Override
	protected void showDialog()
	{
		String n = JOptionPane.showInputDialog(Automat.currentAutomat, "Titel:", "X");
		if (n == null || n.length() == 0) return;
		if (n.length() > 1) n = n.substring(0, 1);
		
		setIcon(new ImageIcon(ToolFactory.getImageForTool(getName(), 32, n)));
	}
}
