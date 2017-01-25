package calculatorFiles;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class CreateLabels {
	
	
	public void makeLabels(Label label,int column,int row) {
		label.setPrefHeight(50);
		label.setPrefWidth(50);
		label.setAlignment(Pos.CENTER);
		String firstNumber = String.valueOf(row);
		String secondNumber = String.valueOf(column);



		if (row == 0 || column == 0) {
			label.getStyleClass().add("outsideCells");

			if(row == 0) {
				label.setText(secondNumber);
			}
			else if (column == 0) {
				label.setText(firstNumber);
			}
		} 

		else {
			label.setText(firstNumber + " * " + secondNumber);   
			label.getStyleClass().add("insideCells");
		}

	}

}
