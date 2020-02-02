# simple-calculator

```This is a simple-calculator which is used for testing my custom OpenJDK-12 bundled with OpenJFX-13.
   This project uses Java Swing, JavaFX and JavaFX FXML for creating simple calculator using Infix Evaluator algorithm to evaluate given expression.```

Understanding task 
By default clean, build, test and jar task is performed and jar files are automatically generated in ```~/build/libs```
All 4 jars will be available after the sucessful build. You can run ```java -jar <JAR-NAME>``` to test individual.

This project requires Java-12 and JFX-13 to build. So, make sure you have already added them as environment variables or by some other mean otherwise
build will fail.

task ```runFXUIMain``` will run calculator UI implemented with JavaFX. To run this hit
```./gradlew or gradlew runFXUIMain``` to run.
task ```runFXMLMain``` will run calculator UI implemented with JavaFX FXML.
task ```runSwingMain``` will run calculator UI implemented with Java Swing.
task ```runMainWithArgs``` will run command line implementation of expression evaluator