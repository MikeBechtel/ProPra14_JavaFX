package controller;

import adapters.GameLoop;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GameController
{
	private Main mainApp;
	
    static int dx = 10;
    static int dy = 10;
	
	@FXML
	private AnchorPane gamePane;
	
	public GameController()
	{
	}
	
	public void setMainApp(Main mainApp)
	{
		this.mainApp = mainApp;
	}
	
	public Main getMainApp()
	{
		return this.mainApp;
	}
	
	@FXML
	private void initialize()
	{
		GameLoop loop = new GameLoop(gamePane);
		loop.start();
	}
}
