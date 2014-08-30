package javaprophet.algebrator.parser;

import java.util.ArrayList;

/**
 * Created by JavaProphet on 8/30/14 at 12:49 PM.
 */
public class Equation {

	private ArrayList<TermSet> termSets = new ArrayList<TermSet>();

	public Equation(ArrayList<TermSet> termSets) {
		this.termSets = termSets;
	}

	public ArrayList<TermSet> getTermSets() {
		return termSets;
	}

	public String listTermsForSet(int i) {
		if(i >= termSets.size() || i < 0)
			return "";
		String f = "";
		TermSet terms = termSets.get(i);
		for(Term term : terms.getTerms()) {
			f += term.getRaw() + ", ";
		}
		if(f.length() > 0) {
			f = f.substring(0, f.length() - 2);
		}
		return f;
	}

}
