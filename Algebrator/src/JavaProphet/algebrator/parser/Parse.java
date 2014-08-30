package JavaProphet.algebrator.parser;

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
			TermSet terms = new TermSet();
			for(String term : rawSide.split("[-\\+]]")) {
				terms.addTerm(new Term(term));
			}
			termSets.add(terms);
		}
		return new Equation(termSets);
	}

}
