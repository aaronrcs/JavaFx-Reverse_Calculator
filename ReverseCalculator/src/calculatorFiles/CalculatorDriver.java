package calculatorFiles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CalculatorDriver extends Application {

	//Global variable for the Labels
	private Label[][] labels = new Label[11][11];

	public static void main(String[] args){
		launch(args);
	}	
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane pane = new BorderPane();
		//HBox for main Title or section of the GUI
		HBox mainHbox = new HBox(20);
		mainHbox.setPadding(new Insets(20, 10, 15, 15));
		mainHbox.setAlignment(Pos.TOP_CENTER);
		mainHbox.getStyleClass().add("mainTitle");

		Label label = new Label("Reverse Multiplication Table");
		label.setPadding(new Insets(10, 10, 10, 10));
		mainHbox.getChildren().add(label);
		
		//HBox for the middle Title or middle section
		HBox enteringANumber = new HBox(20);
		enteringANumber.setPadding(new Insets(10, 10, 10, 10));
		enteringANumber.setAlignment(Pos.TOP_CENTER);
		enteringANumber.getStyleClass().add("middleTitle");

		Label labelNumber = new Label("Enter a number: ");
		enteringANumber.getChildren().add(labelNumber);

		TextField userInput =  new TextField();
		enteringANumber.getChildren().add(userInput);


		Button button = new Button("Find Answer!");
		enteringANumber.getChildren().add(button);


		button.setOnMouseClicked(e-> {
			//Event happens with user clicks on the button 
			highLightGrid(userInput);

		});

		pane.setTop(mainHbox);
		pane.setCenter(enteringANumber);
		pane.setBottom(makeGrid());


		Scene sc = new Scene(pane, 550, 680);

		sc.getStylesheets().add("calculatorFiles/style.css");
		primaryStage.setTitle("Math Is Fun!");
		primaryStage.setScene(sc);
		primaryStage.show();



	} 
	
	//highlight the answer

	public void highLightGrid(TextField input){
		int storeUserInput = Integer.parseInt(input.getText());

		for(int row = 0; row < 11; row++){
			for(int col = 0; col < 11; col++){
				int tempNumber = row * col;
				labels[row][col].getStyleClass().remove("answerBox");


				if(storeUserInput == tempNumber){

					labels[row][col].getStyleClass().add("answerBox");


				}


			}
		}

	}


	public GridPane makeGrid() {
		GridPane grid = new GridPane();
		CreateLabels makeLabels = new CreateLabels();

		for (int row = 0; row < 11; row++){
			for (int column = 0; column < 11; column++) {
				Label label = new Label();
				makeLabels.makeLabels(label, column, row);
				labels[row][column] = label;
				grid.add(label, column, row);
				
			}
		}

		return grid;
	}
	

	

}
