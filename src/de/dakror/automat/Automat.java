package de.dakror.automat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public class Automat extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public static Automat currentAutomat;
	
	JToolBar toolBar;
	public EditorPane editorPane;
	String selectedTool;
	
	public Automat()
	{
		super("Automat");
		
		currentAutomat = this;
		
		setLayout(new BorderLayout());
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		initComponents();
		
		setVisible(true);
	}
	
	public void initComponents()
	{
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		addTool("Neu", false);
		addTool("Speichern", false);
		addTool("Laden", false);
		toolBar.addSeparator();
		addTool("Zustand", true);
		addTool("Lampe", true);
		addTool("Knopf", true);
		addTool("Variable", true);
		
		add(toolBar, BorderLayout.PAGE_START);
		
		editorPane = new EditorPane();
		add(editorPane, BorderLayout.CENTER);
	}
	
	public JButton addTool(String tool, boolean placable)
	{
		final JButton state = new JButton(ToolFactory.getIconForTool(tool, ""));
		state.setName(tool);
		if (placable)
		{
			state.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					selectedTool = state.getName();
				}
			});
		}
		state.setFocusPainted(false);
		state.setToolTipText(tool);
		toolBar.add(state);
		
		return state;
	}
	
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ToolTipManager.sharedInstance().setInitialDelay(0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		new Automat();
	}
}
