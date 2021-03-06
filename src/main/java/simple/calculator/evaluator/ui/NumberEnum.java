package simple.calculator.evaluator.ui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum representing all the available numbers or button keys for simple calculator 
 * in all UI implementation including swing and JavaFX
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 *
 */
public enum NumberEnum {
	SEVEN("7", "Seven", 7, 0, 0),
	EIGHT("8", "Eight", 8, 0, 1), 
	NINE("9", "Nine", 9, 0, 2),
	PLUS("+", "Plus", null, 0, 3), 
	FOUR("4", "Four", 4, 1, 0),
	FIVE("5", "Five", 5, 1, 1), 
	SIX("6", "Six", 6, 1, 2), 
	MINUS("-", "Minus", null, 1, 3), 
	ONE("1", "One", 1, 2, 0), 
	TWO("2", "Two", 2, 2, 1), 
	THREE("3", "Three", 3, 2, 2),
	MULTIPLY("*", "Multiply", null, 2, 3),
	ZERO("0", "Zero", 0, 3, 0),
	POWER("^", "Power", null, 3, 1),
	EQUALS_TO("=", "Equals To", null, 3, 2),
	DIVIDE("/", "Divide", null, 3, 3),
	LEFT_P("(", "Left Parenthesis", null, 4, 0), 
	RIGHT_P(")", "Right Parenthesis", null, 4, 1),
	C("C", "Clear Last", null, 4, 2),
	CE("CE", "Clear All", null, 4, 3);

	private final String buttonText;
	private final String description;
	private final Integer value;
	private final int row;
	private final int column;

	private final static Map<String, NumberEnum> BUTTON_MAP = new HashMap<>();

	static {
		BUTTON_MAP.putAll(Arrays.stream(NumberEnum.values()).collect(HashMap::new, (map, button) -> {
			map.put(button.getButtonText(), button);
		}, Map::putAll));
	}

	private NumberEnum(String buttonText, String description, Integer value, int row, int column) {
		this.buttonText = buttonText;
		this.description = description;
		this.value = value;
		this.row = row;
		this.column = column;
	}

	/**
	 * Returns the row number to which this key is mapped into
	 * JavaFX grid pane.
	 * 
	 * @return a row number for grid pane
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Returns the column number to which this key is mapped to JavaFX
	 * grid pane.
	 * 
	 * @return a column number for grid pane
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Returns a string text to be shown into buttons of calculator
	 * grid pane
	 * 
	 * @return a text representation of this key
	 */
	public String getButtonText() {
		return buttonText;
	}

	/**
	 * Returns a description mapped for this key
	 * 
	 * @return a text representation of this key
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns a Integer value mapped for this key
	 * 
	 * @return a value
	 */
	public Integer getValue() {
		return value;
	}
	
	/**
	 * Gets the equivalent enum represented by this text by looking from
	 * button map
	 * 
	 * @param text a text to look up in map
	 * @return {@link NumberEnum} represented with given text
	 * 
	 * @throws RuntimeException if text is not in the map
	 */
	public static NumberEnum fromButtonText(final String text) {
		return BUTTON_MAP.compute(text, (key, value) -> {
			System.out.println(key);
			if(value == null) throw new RuntimeException("Invalid text spotted");
			return value;
		});
	}
}
