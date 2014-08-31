package javaprophet.algebrator.util;

/**
 * Created by JavaProphet on 8/30/14 at 4:53 PM.
 */
public class Util {

	public static boolean isNumber(char c) {
		if(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
			return true;
		}
		return false;
	}

	public static boolean isDecimal(char c) {
		if(c == '.') {
			return true;
		}
		return false;
	}

	public static boolean isOperator(char c) {
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == '<' || c == '>') {
			return true;
		}
		return false;
	}

}
