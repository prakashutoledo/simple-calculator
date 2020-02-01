package simple.calculator.evaluator.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXFxmlApplication extends Application {
	
	public static void main(String... args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		Parent content = loader.load(this.getClass().getClassLoader().getResourceAsStream("simple/calculator/evaluator/ui/Calculator.fxml"));
		
        Scene scene = new Scene(content, 400, 450);
        
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
	}

}
