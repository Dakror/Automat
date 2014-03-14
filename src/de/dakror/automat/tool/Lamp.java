package de.dakror.automat.tool;



public class Lamp extends Tool
{
	private static final long serialVersionUID = 1L;
	
	public Lamp(int x, int y)
	{
		super(x, y, "Lampe");
	}
	
	@Override
	protected void showDialog()
	{}
}
