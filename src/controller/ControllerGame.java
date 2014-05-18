package controller;

import adapters.KeyboardAdapter;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Controller for the GameFrame.
 * Initializes a new GameLoop Objects, starts the
 * corresponding game loop as well as adds the
 * EventHandlers to this scene.
 * 
 * @author Bellum
 *
 */
public class ControllerGame
{
	private Scene parentScene;
	
	@FXML
	public AnchorPane gamePane;
	
	@FXML
	public ScrollPane scrollPane;
	
	@FXML
	public Label roundStats;
	
	private GameLoop loop;
	
	public ControllerGame()
	{
	}
	
	/**
	 * Gives this Object the parent Scene.
	 * This is necessary to add the EventListners.
	 * @param parentScene - The parent Scene
	 */
	public void setScene(Scene parentScene)
	{
		this.parentScene = parentScene;
	}
	
	public Scene getScene()
	{
		return parentScene;
	}
	
	/**
	 * Will be called automatically when the
	 * GameFrame is constructed. Disables
	 * the Scrollbars from the ScrollPane as well
	 * as starting the game loop.
	 */
	@FXML
	private void initialize()
	{
		scrollPane.hbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);
		scrollPane.vbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);
		
		loop = new GameLoop(this);
		loop.start();
	}
	
	/**
	 * Creates new Adapters 
	 * and adding the EventHandlers
	 * to the given Scene.
	 */
	public void initAdapters()
	{
		parentScene.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardAdapter(this.loop));
	}
}
