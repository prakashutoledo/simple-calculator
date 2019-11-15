package simple.calculator.evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

	private TextField txField = new TextField();
	private Panel buttonPanel = new Panel();
	private String checkString = "";

	// total of 20 buttons on the calculator,
	// numbered from left to right, top to bottom
	// bText[] array contains the text for corresponding buttons
	private static final String[] bText = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "^", "=",
			"/", "(", ")", "C", "CE" };

	/**
	 * C is for clear, clears entire expression CE is for clear expression, clears
	 * last entry up until the last operator.
	 */
	private Button[] buttons = new Button[bText.length];

	public static void main(String... args) {
		System.out.println("Hello Starting Calculator");
		EvaluatorUI calc = new EvaluatorUI();
	}

	public EvaluatorUI() {
		setLayout(new BorderLayout());
		this.txField.setPreferredSize(new Dimension(600, 50));
		this.txField.setFont(new Font("Courier", Font.BOLD, 28));

		add(txField, BorderLayout.NORTH);
		txField.setEditable(false);

		add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setLayout(new GridLayout(5, 4));

		// create 20 buttons with corresponding text in bText[] array
		Button bt;
		for (int i = 0; i < EvaluatorUI.bText.length; i++) {
			bt = new Button(bText[i]);
			bt.setFont(new Font("Courier", Font.BOLD, 28));
			buttons[i] = bt;
		}

		// add buttons to button panel
		for (int i = 0; i < EvaluatorUI.bText.length; i++) {
			buttonPanel.add(buttons[i]);
		}

		// set up buttons to listen for mouse input
		for (int i = 0; i < EvaluatorUI.bText.length; i++) {
			buttons[i].addActionListener(this);
		}

		setTitle("Calculator");
		setSize(400, 400);
		setLocationByPlatform(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand().toUpperCase()) {
		case "=":
			try {
				Evaluator infix = new Evaluator();
				if (!this.txField.getText().isEmpty()) {
					int value = infix.eval(this.txField.getText().trim());
					txField.setText(value + "");
					this.checkString = this.txField.getText();
				}
				
			} catch (RuntimeException ex) {
				JOptionPane.showMessageDialog(this, "Can't parse above expression", "Invalid Expression",
					JOptionPane.WARNING_MESSAGE);
			}

			break;
		case "CE":
			this.checkString = "";
			this.txField.setText(this.checkString);
			break;
		case "C" :
			if (this.txField.getText() != null && !this.txField.getText().isEmpty()) {
				this.checkString = this.checkString.substring(0, this.checkString.length() - 1);
				this.txField.setText(this.checkString);
			}
			
			break;
		default :
			checkString = checkString + arg0.getActionCommand();
			this.txField.setText(checkString);
			break;

		}
	}
}
