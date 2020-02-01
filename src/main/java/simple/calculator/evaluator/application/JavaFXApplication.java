package simple.calculator.evaluator.application;

import java.util.Arrays;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import simple.calculator.evaluator.InfixEvaluator;
import simple.calculator.evaluator.ui.NumberEnum;


/**
 * Main class for running JavaFX implementation of simple calculator.
 * All the required root pane is added by childrens which then add into parent 
 * or treated as parent to create a new scene which is eventually added into stage to show.
 * This implementation and {@link JavaFXFxmlApplication} implementation are 
 * same with the only difference is required components for parent scene are loaded from
 * source fxml file and here we need to create it explicitely and add into
 * root or parent.
 * 
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 * 
 * @see JavaFXFxmlApplication
 */
public class JavaFXApplication extends Application {
	
	private final AnchorPane rootPane = new AnchorPane();
	private final GridPane gridPane = new GridPane();
	private final TextField textField = new TextField();
	
	
	public static void main(String... args) {
		launch(args);
	}
	/**
	 * Performs the given click button action. All buttons clicked action is
	 * performed Calls the infix evaluator to parse and evaluate the given
	 * expression into value.
	 * 
	 * @throws RuntimeException if invalid expression in input to user and equals to
	 *                          button is clicked
	 *                          
	 * @throws IllegalArguentException if source targeting this event is instance of Button
	 */
    private final EventHandler<ActionEvent> buttonClickedHandler = (event) -> {
    	if(!(event.getSource() instanceof Button)) throw new IllegalArgumentException("Event only supports FX Buttons");
    	
    	var button = (Button) event.getSource();
		var infixEvaluator = new InfixEvaluator();
		
		switch (button.getText().toUpperCase()) {
		case "=": // performs calculation
			try {
				if (!this.textField.getText().isEmpty()) {
					this.textField.setText(String.valueOf(infixEvaluator.evaluate(this.textField.getText().trim())));
				}

			} catch (RuntimeException ex) {
			}
			break;

		case "CE": // clears all
			this.textField.setText("");
			break;

		case "C": // clear last digit
			if (this.textField.getText() != null && !this.textField.getText().isEmpty()) {
				this.textField.setText(this.textField.getText().substring(0, this.textField.getText().length() -1));
			}
			break;

		default: // Just add the digit to text box
			this.textField.setText(this.textField.getText() + button.getText());
			break;
		}
    };

    /**
     * {@inheritDoc}
     */
	@Override
	public void start(Stage primaryStage) throws Exception {
		rootPane.setPrefSize(400, 450);
		textField.setFont(Font.font("Courier New Bold", FontWeight.BOLD, 28.0));
		textField.setLayoutX(0);
		textField.setLayoutY(0);
		textField.setPrefSize(400, 50);
		textField.setEditable(false);
		textField.setBackground(Background.EMPTY);
		
		gridPane.setLayoutX(0);
		gridPane.setLayoutY(50);
		gridPane.setGridLinesVisible(true);
		gridPane.setPrefSize(400, 400);
		
		IntStream.rangeClosed(0, 3).forEach(stream -> {
			ColumnConstraints column = new ColumnConstraints();
			column.setMinWidth(10);
			column.setPrefWidth(100);
			column.setHgrow(Priority.SOMETIMES);
			
			gridPane.getColumnConstraints().add(column);
		});
		
		IntStream.rangeClosed(0, 4).forEach(stream -> {
			RowConstraints row = new RowConstraints();
			row.setMinHeight(10);
			row.setPrefHeight(30);
			row.setVgrow(Priority.SOMETIMES);
			
			gridPane.getRowConstraints().add(row);
		});
		
		Arrays.stream(NumberEnum.values()).map(number -> {
			var button = new Button(number.getButtonText());
			button.setUserData(number);
			return button;
		}).forEach(button -> {
			button.setFont(Font.font("Courier New Bold",FontWeight.BOLD, 28));
			button.setOnAction(this.buttonClickedHandler);
			button.setPrefSize(100, 80);
			var number = (NumberEnum) button.getUserData();
			this.gridPane.add(button, number.getColumn(), number.getRow());
		});
		
		this.rootPane.getChildren().addAll(this.textField, this.gridPane);
		
		var scene = new Scene(this.rootPane, 400, 450);	
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
	}
}
