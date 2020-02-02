package simple.calculator.evaluator.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import simple.calculator.evaluator.InfixEvaluator;

/**
 * This class implementation is Java Swing implementation of simple calculator with
 * minimal feature.
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 *
 */
public class SwingUI extends JFrame {

	private static final long serialVersionUID = -4636813572868218797L;

	private TextField textField = new TextField();
	private final Panel buttonPanel;

	/**
	 * Performs the given click button action. All buttons clicked action is
	 * performed Calls the infix evaluator to parse and evaluate the given
	 * expression into value.
	 * 
	 * @throws RuntimeException if invalid expression in input to user and equals to
	 *                          button is clicked
	 */
	ActionListener butttonClickedListener = event -> {
		var infixEvaluator = new InfixEvaluator();
		switch (event.getActionCommand().toUpperCase()) {
		case "=": // performs calculation
			try {
				if (this.textField.getText() != null && !this.textField.getText().isEmpty()) {
					this.textField.setText(String.valueOf(infixEvaluator.evaluate(this.textField.getText().trim())));
				}

			} catch (RuntimeException ex) {
				JOptionPane.showMessageDialog(this, "Can't parse above expression", "Invalid Expression",
						JOptionPane.WARNING_MESSAGE);
			}
			break;

		case "CE": // clears all
			this.textField.setText("");
			break;

		case "C": // clear last digit
			if (this.textField.getText() != null && !this.textField.getText().isEmpty()) {
				this.textField.setText(this.textField.getText().substring(0, this.textField.getText().length() - 1));
			}
			break;

		default: // Just add the digit to text box
			this.textField.setText(this.textField.getText() + event.getActionCommand());
			break;
		}
	};

	public SwingUI() {
		this.buttonPanel = new Panel();
		this.setLayout(new BorderLayout());
		this.textField = new TextField();
		this.setUI();

	}

	/**
	 * Sets the swing components to be available in UI with action listener set for buttons
	 */
	private void setUI() {
		this.setTextFieldParameters();
		add(this.textField, BorderLayout.NORTH);
		add(this.buttonPanel, BorderLayout.CENTER);

		Arrays.stream(NumberEnum.values()).map(number -> new Button(number.getButtonText())).forEach(button -> {
			button.setFont(new Font("Courier", Font.BOLD, 28));
			button.addActionListener(this.butttonClickedListener);
			this.buttonPanel.add(button);
		});

		this.buttonPanel.setLayout(new GridLayout(5, 4));

		this.setTitle("Calculator");
		this.setSize(400, 400);
		this.setLocationByPlatform(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Sets this text field size, font and is a visible swing component
	 */
	private void setTextFieldParameters() {
		this.textField.setPreferredSize(new Dimension(600, 50));
		this.textField.setFont(new Font("Courier", Font.BOLD, 28));
		textField.setEditable(false);
	}
}
