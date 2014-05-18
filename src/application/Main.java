package application;
	
import java.io.IOException;

import controller.GameController;
import controller.MainMenuController;
import controller.SettingsMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	public Main()
	{
		
	}

	@Override
	public void start(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Worms Abklatsch");
		
		try
		{
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			
			this.primaryStage.setScene(scene);
			
			this.primaryStage.setResizable(true);
			this.primaryStage.show();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			System.out.println("Could not load '../view/RootLayout.fxml'.");
			System.exit(5);
		}
		
		showMainMenu();
	}
	
	public void showMainMenu()
	{
	    try 
	    {
	        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/MainMenu.fxml"));
	        AnchorPane menuPage = (AnchorPane) loader.load();
	        rootLayout.setCenter(menuPage);
	        
	        MainMenuController controllerMain = loader.getController();
	        controllerMain.setMainApp(this);
	    } 
	    catch (IOException ex) 
	    {
			ex.printStackTrace();
			System.out.println("Could not load '../view/MainMenu.fxml'.");
			System.exit(6);
	    }
	}
	
	public void showSettingsMenu()
	{
	    try 
	    {
	        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/SettingsMenu.fxml"));
	        AnchorPane menuPage = (AnchorPane) loader.load();
	        rootLayout.setCenter(menuPage);
	        
	        SettingsMenuController controllerMain = loader.getController();
	        controllerMain.setMainApp(this);
	    } 
	    catch (IOException ex) 
	    {
			ex.printStackTrace();
			System.out.println("Could not load '../view/SettingsMenu.fxml'.");
			System.exit(6);
	    }
	}
	
	public void showGameScene()
	{
	    try 
	    {
	        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/GameScene.fxml"));
	        AnchorPane gamePage = (AnchorPane) loader.load();
	        rootLayout.setCenter(gamePage);
	        
	        GameController controllerGame = loader.getController();
	        controllerGame.setScene(primaryStage.getScene());
	        controllerGame.initAdapters();
	    } 
	    catch (IOException ex) 
	    {
			ex.printStackTrace();
			System.out.println("Could not load '../view/GameScene.fxml'.");
			System.exit(6);
	    }
	}
	
	public Stage getPrimaryStage()
	{
		return this.primaryStage;
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
