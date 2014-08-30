import javaprophet.algebrator.parser.Equation;
import javaprophet.algebrator.parser.Parse;

/**
 * Created by JavaProphet on 8/30/14 at 12:36 PM.
 */
public class MainTest {

	public static void main(String[] args) {
		Parse parse = new Parse();
		Equation e = parse.parse("2x+7=9*7");
		System.out.println(e.listTermsForSet(0));
		System.out.println(e.listTermsForSet(1));
	}

}
