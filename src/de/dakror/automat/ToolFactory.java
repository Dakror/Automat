package de.dakror.automat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import de.dakror.gamesetup.util.Helper;

public class ToolFactory
{
	public static Icon getIconForTool(String tool, String text)
	{
		int size = 20;
		Image img = null;
		try
		{
			if (tool.equals("Speichern")) img = ImageIO.read(ToolFactory.class.getResource("/img/save.png")).getScaledInstance(size - 1, size - 1, Image.SCALE_DEFAULT);
			else if (tool.equals("Laden")) img = ImageIO.read(ToolFactory.class.getResource("/img/open.png")).getScaledInstance(size - 1, size - 1, Image.SCALE_DEFAULT);
			else if (tool.equals("Neu")) img = ImageIO.read(ToolFactory.class.getResource("/img/new.png")).getScaledInstance(size, size - 1, Image.SCALE_DEFAULT);
			else img = getImageForTool(tool, size, text);
			
			return new ImageIcon(img);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage getImageForTool(String tool, int size, String text)
	{
		BufferedImage bi = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) bi.getGraphics();
		Helper.setRenderingHints(g, true);
		if (tool.equals("Zustand"))
		{
			g.setColor(text.equals("0") ? Color.cyan : Color.gray);
			g.fillArc(0, 0, size - 1, size - 1, 0, 360);
			g.setColor(Color.black);
			g.drawArc(0, 0, size - 1, size - 1, 0, 360);
			g.setColor(Color.white);
			Helper.drawHorizontallyCenteredString(text.length() == 0 ? "X" : text, size, (size + 18) / 2 - 2, g, 18);
		}
		else if (tool.equals("Lampe"))
		{
			g.setColor(text.length() == 0 ? Color.yellow : Color.decode(text));
			g.fillRect(0, 0, size, size);
			g.setColor(Color.black);
			g.drawRect(0, 0, size - 1, size - 1);
		}
		else if (tool.equals("Knopf"))
		{
			g.setColor(Color.lightGray);
			g.fillRoundRect(0, 0, size - 1, size - 1, 8, 8);
			g.setColor(Color.black);
			g.drawRoundRect(0, 0, size - 1, size - 1, 8, 8);
			Helper.drawHorizontallyCenteredString(text.length() == 0 ? "X" : text, size, (size + 18) / 2 - 2, g, 18);
		}
		else if (tool.equals("Variable"))
		{
			g.setColor(Color.black);
			Helper.drawHorizontallyCenteredString(text.length() == 0 ? "Var" : text, size, size - Math.round(5 * (size / 20f)), g, 13);
		}
		
		return bi;
	}
}
