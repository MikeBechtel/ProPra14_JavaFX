package controller;

import application.Main;
import javafx.fxml.FXML;

public class MainMenuController 
{
	private Main mainApp;
	
	public MainMenuController() {}
	
	public void setMainApp(Main mainApp)
	{
		this.mainApp = mainApp;
	}
	
	public Main getMainApp()
	{
		return this.mainApp;
	}
	
	@FXML
	private void handleLocal()
	{
		mainApp.showGameScene();
	}
	
	@FXML
	private void handleSettings()
	{
		mainApp.showSettingsMenu();
	}
	
	@FXML
	private void handleExit()
	{
		System.exit(0);
	}
}
