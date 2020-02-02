package simple.calculator.evaluator.ui;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import simple.calculator.evaluator.InfixEvaluator;

/**
 * FXML controller for @{file calculator.fxml}.
 * Source FXML is found inside the same package as this controller is at but
 * in resource folder.
 *  
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 *
 */
public class CalculatorFXMLController implements Initializable {
	
    @FXML
    private GridPane gridPane;
    
    @FXML
    private TextField textField;
    
    @FXML
    private AnchorPane rootPane;
    
	/**
	 * Performs the given click button action. All buttons clicked action is
	 * performed Calls the infix evaluator to parse and evaluate the given
	 * expression into value.
	 * 
	 * @throws RuntimeException if invalid expression in input to user and equals to
	 *                          button is clicked
	 * 
	 */
    private final EventHandler<ActionEvent> buttonClickedHandler = (event) -> {
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
     * 
     * {@inheritDoc}
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.textField.setEditable(false);
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
	}
}
