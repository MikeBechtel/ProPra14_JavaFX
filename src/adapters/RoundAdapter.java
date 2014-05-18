package adapters;

import java.text.DecimalFormat;

import controller.GameLoop;

public class RoundAdapter 
{
	private GameLoop gameLoop;
	
	private final double roundSeconds = 19.9;
	private final int maxRounds = 20;
	private double timeLeft;
	private int currRound;
	
	private int nextPlayer;
	
	DecimalFormat formatter = new DecimalFormat("#0.0");
	
	public RoundAdapter(GameLoop gameLoop)
	{
		this.gameLoop = gameLoop;
		this.timeLeft = roundSeconds;
		this.currRound = 1;
		
		this.nextPlayer = 1;
	}
	
	public void handleRound()
	{
		if(timeLeft <= 0)
			nextRound();
		
		gameLoop.parentController.roundStats.setText(formatter.format(timeLeft) + ", Pl: " + gameLoop.currPlayer.getName());
		
		timeLeft = timeLeft - gameLoop.oneFrameDur.toSeconds();
	}
	
	public void reset()
	{
		this.timeLeft = roundSeconds;
		this.nextPlayer = 1;
	}
	
	public void nextRound()
	{
		currRound++;
		
		if(currRound > maxRounds)
		{
			gameLoop.nextMap();
			currRound = 1;
		}
		else
		{
			if(nextPlayer >= GameLoop.players.size())
				nextPlayer = 0;
			
			System.out.println("Current Round: " + currRound);
			gameLoop.currPlayer = GameLoop.players.get(nextPlayer);
			timeLeft = roundSeconds;
			nextPlayer++;
		}
	}
}
