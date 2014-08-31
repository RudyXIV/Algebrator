package javaprophet.algebrator.algorithm.liketerms;

import javaprophet.algebrator.parser.Term;
import javaprophet.algebrator.parser.TermSet;

import java.util.ArrayList;

/**
 * Created by JavaProphet on 8/30/14 at 4:43 PM.
 */
public class LikeTerms {

	protected static class TermSet2 {
		public TermSet2(Term term1, Term term2) {
			this.term1 = term1;
			this.term2 = term2;
		}

		Term term1;
		Term term2;
	}

	public TermSet run(TermSet terms) {
		TermSet termsNew = new TermSet();
		ArrayList<TermSet2> termScanned = new ArrayList<TermSet2>();
		for(Term term : terms.getTerms()) {
			ArrayList<Term> likeTerms = new ArrayList<Term>();
			bottom:
			for(Term term2 : terms.getTerms()) {
				if(term == term2)
					continue;
				for(TermSet2 ts : termScanned) {
					if((ts.term1 == term && ts.term2 == term2) || (ts.term1 == term2 && ts.term2 == term)) {
						continue bottom;
					}
				}
				termScanned.add(new TermSet2(term, term2));
				boolean isLike = term.getVariables().equals(term2.getVariables());
				if((term.getRaw().contains("^") && !term2.getRaw().contains("^")) || (!term.getRaw().contains("^") && term2.getRaw().contains("^"))) {
					isLike = false;
				}
				if(term.getRaw().contains("^") && term2.getRaw().contains("^")) {
					for(int i = 0; i < term.getRaw().length(); i++) {
						if(term.getRaw().charAt(i) == '^')
							for(int i2 = 0; i2 < term2.getRaw().length(); i2++) {
								if(term2.getRaw().charAt((i2)) == '^') {
									String exp1 = "";
									{
										int loc = -1;
										int locc1 = term.getRaw().indexOf("-", i + 1);
										int locc2 = term.getRaw().indexOf("+", i + 1);
										if(locc1 < 0) {
											loc = locc2;
										}else if(locc2 < 0) {
											loc = locc1;
										}else {
											loc = Math.min(locc1, locc2);
										}
										if(loc < 0) {
											loc = term.getRaw().length();
										}
										exp1 = term.getRaw().substring(i + 1, loc);
									}
									String exp2 = "";
									{
										int loc = -1;
										int locc1 = term2.getRaw().indexOf("-", i2 + 1);
										int locc2 = term2.getRaw().indexOf("+", i2 + 1);
										if(locc1 < 0) {
											loc = locc2;
										}else if(locc2 < 0) {
											loc = locc1;
										}else {
											loc = Math.min(locc1, locc2);
										}
										if(loc < 0) {
											loc = term2.getRaw().length();
										}
										exp2 = term2.getRaw().substring(i2 + 1, loc);
									}
									Term t1 = new Term(exp1);
									Term t2 = new Term(exp2);
									if(!t1.getVariables().equals(t2.getVariables())) {
										isLike = false;
									}else {
										if(!t1.equals(t2)) {
											isLike = false;
										}
									}
								}
							}
					}
				}
				if(isLike) {
					System.out.println(term.getRaw() + " is like " + term2.getRaw());
					likeTerms.add(term2);
				}
			}
			Term[] toCombine = new Term[likeTerms.size() + 1];
			toCombine[0] = term;
			System.arraycopy(likeTerms.toArray(new Term[0]), 0, toCombine, 1, toCombine.length - 1);
			termsNew.addTerm(combineTerms(toCombine));
		}
		return termsNew;
	}

	public Term combineTerms(Term... terms) {
		if(terms.length == 1) {
			return terms[0];
		}else if(terms.length == 0) {
			return null;
		}else {
			return null;//TODO: this needs to combine like terms, i will be writing down the rules for this at school.
		}
	}

}
