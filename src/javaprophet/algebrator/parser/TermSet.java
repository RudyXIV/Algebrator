package javaprophet.algebrator.parser;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by JavaProphet on 8/30/14 at 3:13 PM.
 */
public class TermSet {

	private ArrayList<Term> terms = new ArrayList<Term>();

	public TermSet(Term... terms) {
		addTerm(terms);
	}

	public TermSet() {

	}

	public ArrayList<Term> getTerms() {
		return terms;
	}

	public void addTerm(Term... terms) {
		this.terms.addAll(Arrays.asList(terms));
	}
}
