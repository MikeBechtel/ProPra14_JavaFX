package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class SettingsMenuController 
{
	private Main mainApp;
	
	@FXML
	private ChoiceBox<String> choiceRes;
	
	public SettingsMenuController() {}
	
	public void setMainApp(Main mainApp)
	{
		this.mainApp = mainApp;
	}
	
	public Main getMainApp()
	{
		return this.mainApp;
	}
	
	@FXML
	private void handleSettings()
	{
		mainApp.showSettingsMenu();
	}
	
	@FXML
	private void initialize() 
	{
		choiceRes.setItems(FXCollections.observableArrayList(
				"800 x 600", "1024 x 768", "1152 x 864",
				"1280 x 960"
		));
		choiceRes.getSelectionModel().selectFirst();
	}
	
	@FXML
	private void handleBack()
	{
		mainApp.showMainMenu();
	}
}
