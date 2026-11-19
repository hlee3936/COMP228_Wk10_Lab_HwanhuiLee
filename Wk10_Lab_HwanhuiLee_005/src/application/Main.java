package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		GridPane pane = new GridPane();
		
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label title = new Label("Employment  Application");
		Label subtitle1 = new Label("Personal Information");
		Label subtitle2 = new Label("Employment Eligibility");
		
		title.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		subtitle1.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		subtitle2.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		
		
		TextField nameField = new TextField();
		TextField addressField = new TextField();
		TextField contactField = new TextField();
		TextField emailField = new TextField();
		TextField attainmentField = new TextField();
		RadioButton maleButton = new RadioButton("Male");
		RadioButton femaleButton = new RadioButton("Female");
		RadioButton otherButton = new RadioButton("Other");
		HBox genderHBox = new HBox(maleButton, femaleButton, otherButton);
		VBox genderVBox = new VBox(new Label("Gender"), genderHBox);
		DatePicker datePicker = new DatePicker();
		TextField positionField = new TextField();
		TextField salaryField = new TextField();
		RadioButton authorizedYesButton = new RadioButton("Yes");
		RadioButton authorizedNoButton = new RadioButton("No");
		RadioButton relativesYesButton = new RadioButton("Yes");
		RadioButton relativesNoButton = new RadioButton("No");
		TextField furtherField = new TextField();
		Button submitButton = new Button("Submit");
		
		genderHBox.setSpacing(10);
		
		ToggleGroup genderGroup = new ToggleGroup();
		maleButton.setToggleGroup(genderGroup);
		femaleButton.setToggleGroup(genderGroup);
		otherButton.setToggleGroup(genderGroup);
		ToggleGroup authorizedGroup = new ToggleGroup();
		authorizedYesButton.setToggleGroup(authorizedGroup);
		authorizedNoButton.setToggleGroup(authorizedGroup);
		ToggleGroup relativesGroup = new ToggleGroup();
		relativesYesButton.setToggleGroup(relativesGroup);
		relativesNoButton.setToggleGroup(relativesGroup);
		
		pane.add(title, 0, 0, 4, 1);
		pane.add(subtitle1, 0, 1, 2, 1);
		pane.add(new Label("Full Name"), 0, 2, 2, 1);
		pane.add(nameField, 2, 2, 2, 1);
		pane.add(new Label("Current Address"), 0, 3, 2, 1);
		pane.add(addressField, 2, 3, 2, 1);
		pane.add(new Label("Contact\nNumber"), 0, 4);
		pane.add(contactField, 1, 4);
		pane.add(new Label("Email\nAddress"), 2, 4);
		pane.add(emailField, 3, 4);
		pane.add(new Label("Highest\nEducational\nAttainment"), 0, 5);
		pane.add(attainmentField, 1, 5);
		pane.add(genderVBox, 2, 5, 2, 1);
		pane.add(subtitle2, 0, 6, 2, 1);
		pane.add(new Label("Date\nAvailable"), 0, 7);
		pane.add(datePicker, 1, 7);
		pane.add(new Label("Desired\nPosition"), 2, 7);
		pane.add(positionField, 3, 7);
		pane.add(new Label("Desired Salary"), 0, 8, 2, 1);
		pane.add(salaryField, 2, 8, 2, 1);
		pane.add(new Label("Are you legally authorized to work in the country?"), 0, 9, 4, 1);
		pane.add(authorizedYesButton, 0, 10);
		pane.add(authorizedNoButton, 1, 10);
		pane.add(new Label("Do you have relatives working for our company?"), 0, 11, 4, 1);
		pane.add(relativesYesButton, 0, 12);
		pane.add(relativesNoButton, 1, 12);
		pane.add(new Label("If yes, please explain further"), 0, 13, 2, 1);
		pane.add(furtherField, 2, 13, 2, 1);
		pane.add(submitButton, 0, 14, 4, 1);
		
		GridPane.setHalignment(title, HPos.CENTER);
		GridPane.setHalignment(submitButton, HPos.CENTER);
		
		Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(540);
        
        EmploymentFormDao employmentFormDao = new EmploymentFormDao();
        
        submitButton.setOnAction(e -> {
        	try {
        		RadioButton selectedGenderButton = (RadioButton) genderGroup.getSelectedToggle();
        		RadioButton selectedAuthorizedButton = (RadioButton) authorizedGroup.getSelectedToggle();
        		RadioButton selectedRelativesButton = (RadioButton) relativesGroup.getSelectedToggle();
        		
        		EmploymentForm employment = new EmploymentForm(
        			nameField.getText(),
        			addressField.getText(),
        			contactField.getText(),
        			emailField.getText(),
        			attainmentField.getText(),
        			selectedGenderButton.getText(),
        			datePicker.getValue(),
        			positionField.getText(),
        			salaryField.getText(),
        			selectedAuthorizedButton.getText().equals("Yes"),
        			selectedRelativesButton.getText().equals("Yes"),
        			furtherField.getText()
        		);
        			
        			int id = employmentFormDao.saveEmploymentForm(employment);
        			System.out.println("ID: " + id + " Employment Form submitted!");
        	} catch (Exception ex) {
        		ex.printStackTrace();
			}
        });
        
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
