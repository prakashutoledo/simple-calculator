package simple.calculator.evaluator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Driver class that uses {@link InfixEvaluator} to evaluate expressions. The expressions can
 * either be given as a command line argument , typed in at the keyboard or you
 * can used "auto" as a command line argument to run predefined expressions. If
 * you wish to type in expressions give NO command line arguments. Otherwise you
 * may give a list of strings as a command line argument and the driver will run
 * all strings in that list.
 *
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 * 
 * @throws RuntimeException if any
 * 
 * @see InfixEvaluator
 *
 */
public class InfixEvaluatorDriver {
	private static final String QUIT = "Quit";
	private static Map<String, String> testExpressions = new HashMap<>();

	static {
		testExpressions.put("1+2", "3");
		testExpressions.put("1/2", "0");
		testExpressions.put("1+2*3", "7");
		testExpressions.put("(1+2)*3", "9");
		testExpressions.put("2-(3/10)+2-5", "-1");
		testExpressions.put("(6-12*2)/3", "-6");
		testExpressions.put("3^2", "9");
		testExpressions.put("3^2/2", "4");
		testExpressions.put("3^2/2 +(4+5)", "13");
		testExpressions.put("3^2 + (2^4) +(4+5)", "34");
		testExpressions.put("3+2-9+8*2 + (3+9-8/2)", "20");
		testExpressions.put("2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9", "1176");
	}

	public static void main(String... args) {
		BufferedReader input = null;
		String expression;

		var infixEvaluator = new InfixEvaluator();
		if (args != null && args.length == 0) {
			try {
				input = new BufferedReader(new InputStreamReader(System.in));
				while (true) {
					System.out.print("Enter an Expression or Type(Quit) to end the program : ");
					expression = input.readLine().trim();

					if (expression.equalsIgnoreCase(QUIT)) {
						break;
					}
					
					System.out.printf("Expression : %s , Result : %d\n", expression, infixEvaluator.evaluate(expression));
					System.out.println("");
				}
				
			} catch (Exception ex) {
				System.out.println("Invalid input");
				System.out.println("Unable to evaluate given expression");
				
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						System.out.println("Unexpected error occured while closing stream");
					}
				}
			}

			sayGoodBye();
			return;
		}

		if (args.length == 1 && (args[0].toLowerCase()).equals("auto")) {
			testExpressions.forEach((infix, expectedResult) -> {
				String yourResult = infixEvaluator.evaluate(infix) + "";
				System.out.printf("%45s %5s : %5s : %7s%n", infix, expectedResult, yourResult,
						expectedResult.equals(yourResult) ? "Passed" : "Failed");
			});

			sayGoodBye();
			return;
		}

		try {
			Arrays.stream(args).forEach(argument -> {
				System.out.printf("Expression : %s , Result: %-6d\n", argument, infixEvaluator.evaluate(argument));
			});
		} catch (Exception ex) {
			System.out.println("Unable to evaluate given expression");
		}

		sayGoodBye();
	}

	private static void sayGoodBye() {
		System.out.println("************************Good Bye***********************");
	}
}
