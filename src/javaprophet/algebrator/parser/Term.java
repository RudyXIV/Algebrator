package javaprophet.algebrator.parser;

import javaprophet.algebrator.util.Util;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by JavaProphet on 8/30/14 at 12:48 PM.
 */
public class Term {

	private String raw = "";

	public Term(String raw) {
		this.raw = raw;
	}

	public String getVariables() {
		ArrayList<Character> chars = new ArrayList<Character>();
		for(int i = 0; i < raw.length(); i++) {
			char c = raw.charAt(i);
			if(!Util.isNumber(c) && !Util.isOperator(c)) {
				chars.add(c);
			}
		}
		Collections.sort(chars);
		char[] sA = new char[chars.size()];
		Character[] tC = chars.toArray(new Character[0]);
		for(int i = 0; i < chars.size(); i++) {
			sA[i] = tC[i];
		}
		return new String(sA);
	}

	public String getRaw() {
		return raw;
	}

}
