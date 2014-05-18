package controller;

import adapters.GameLoop;
import adapters.KeyboardAdapter;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameController
{
	private Scene parentScene;
	
    static int dx = 10;
    static int dy = 10;
	
	@FXML
	private AnchorPane gamePane;
	
	@FXML
	private ScrollPane scrollPane;
	
	public GameController()
	{
	}
	
	public void setScene(Scene parentScene)
	{
		this.parentScene = parentScene;
	}
	
	public Scene getScene()
	{
		return parentScene;
	}
	
	@FXML
	private void initialize()
	{
		scrollPane.hbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);
		scrollPane.vbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);
		
		GameLoop loop = new GameLoop(gamePane);
		loop.start();
	}
	
	public void initAdapters()
	{
		parentScene.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardAdapter());
	}
}
