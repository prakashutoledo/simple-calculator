package simple.calculator.evaluator.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for running JavaFX FXML implementation of simple calculator.
 * Source fxml file is loaded into {@link FXMLLoader} to load xml components and
 * add into parent to create a new scene which is eventually added into stage to show.
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 * 
 * @see JavaFXApplication
 *
 */
public class JavaFXFxmlApplication extends Application {
	
	public static void main(String... args) {
		launch(args);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		var loader = new FXMLLoader();
		var content = loader.load(this.getClass().getClassLoader().getResourceAsStream("simple/calculator/evaluator/ui/Calculator.fxml"));
		
        var scene = new Scene((Parent) content, 400, 450);
        
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
	}

}
