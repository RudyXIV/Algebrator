package javaprophet.algebrator.algorithm.liketerms;

import javaprophet.algebrator.parser.Term;
import javaprophet.algebrator.parser.TermSet;

/**
 * Created by JavaProphet on 8/30/14 at 4:43 PM.
 */
public class LikeTerms {

	public TermSet run(TermSet terms) {
		TermSet termsNew = new TermSet();
		top:
		for(Term term : terms.getTerms()) {
			for(Term term2 : terms.getTerms()) {
				if(term == term2)
					continue top;
				if(term.getVariables().equals(term2.getVariables())) {
					System.out.println(term.getRaw() + " is like " + term2.getRaw());
				}
			}
		}
		return termsNew;
	}

}
