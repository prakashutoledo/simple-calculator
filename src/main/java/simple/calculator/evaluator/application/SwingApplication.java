package simple.calculator.evaluator.application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

import simple.calculator.evaluator.ui.NumberEnum;
import simple.calculator.evaluator.ui.SwingUI;

public class SwingApplication {
	public static void main(String... args) throws IOException {
		System.out.println("Hello Starting Calculator");
		new SwingUI();
	}
}
