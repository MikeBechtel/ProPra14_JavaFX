package controller;

public class Player 
{
	private String name; 
	
	public Player()
	{
		this.name = "Player";
	}
	
	public Player(String name)
	{
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
