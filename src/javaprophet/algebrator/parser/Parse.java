package javaprophet.algebrator.parser;

import java.util.ArrayList;

/**
 * Created by JavaProphet on 8/30/14 at 12:48 PM.
 */
public class Parse {

	public Parse() {

	}

	public Equation parse(String raw) {
		ArrayList<TermSet> termSets = new ArrayList<TermSet>();
		for(String rawSide : raw.split("=")) {
			if(!rawSide.startsWith("+") || !rawSide.startsWith("-")) {
				rawSide = "+" + rawSide;
			}
			rawSide = rawSide.replace(" ", "");
			rawSide = rawSide.replace("--", "+");
			rawSide = rawSide.replace("++", "+");
			TermSet terms = new TermSet();
			for(int i = 0; i < rawSide.length(); i++) {
				if(rawSide.charAt(i) == '+') {
					int loc = -1;
					int locc1 = rawSide.indexOf("-", i + 1);
					int locc2 = rawSide.indexOf("+", i + 1);
					if(locc1 < 0) {
						loc = locc2;
					}else if(locc2 < 0) {
						loc = locc1;
					}else {
						loc = Math.min(locc1, locc2);
					}
					if(loc < 0) {
						loc = rawSide.length();
					}
					terms.addTerm(new Term(rawSide.substring(i + 1, loc)));
				}else if(rawSide.charAt(i) == '-') {
					int loc = -1;
					int locc1 = rawSide.indexOf("-", i + 1);
					int locc2 = rawSide.indexOf("+", i + 1);
					if(locc1 < 0) {
						loc = locc2;
					}else if(locc2 < 0) {
						loc = locc1;
					}else {
						loc = Math.min(locc1, locc2);
					}
					if(loc < 0) {
						loc = rawSide.length();
					}
					terms.addTerm(new Term(rawSide.substring(i, loc)));
				}
			}
			termSets.add(terms);
		}
		return new Equation(termSets);
	}

}
