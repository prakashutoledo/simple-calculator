package simple.calculator.evaluator.application;

import java.io.IOException;

import simple.calculator.evaluator.ui.SwingUI;

/**
 * Main class for running Swing implementation of simple calculator
 * 
 * @author Prakash Khadka
 * 	       Created on: Feb 1, 2020
 *
 */
public class JavaSwingApplication {
	
	public static void main(String... args) throws IOException {
		System.out.println("Hello Starting Calculator");
		new SwingUI();
	}
}
