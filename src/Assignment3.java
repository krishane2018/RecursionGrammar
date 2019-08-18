import java.io.*;

public class Assignment3 {
	
	public static void main(String[] args) {
//		BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
//		String input = new String();
//		// read in substring pattern, catching any exceptions
//		try {
//			while (true) {
//				System.out.print("Enter the G-language word to check: ");
//				input = keyboardReader.readLine();
//				break;
//			}
//		} catch (IOException e) {
//			System.out.println(e);
//		}
//		LanguageRecognizerG w1 = new LanguageRecognizerG(input);
//		w1.recursivePrintG();
//
//		// read in infix expression, catching any exceptions
//		try {
//			while (true) {
//				System.out.print("Enter the infix expression to evaluate: ");
//				input = keyboardReader.readLine();
//				break;
//			}
//		} catch (IOException e) {
//			System.out.println(e);
//		}

		
		InfixCalculator w2 = new InfixCalculator( "(10 + 3 * 4 / 6)");
		w2.evaluateInfix();
		System.out.println();
		
		w2 = new InfixCalculator(" 12*3 - 4 + (18 / 6) ");
		w2.evaluateInfix();
		System.out.println();
		
		w2 = new InfixCalculator(" 35 - 42 * 17 /2 + 10");
		w2.evaluateInfix();
		System.out.println();
		
		w2 = new InfixCalculator(" 3 * (4 + 5)");
		w2.evaluateInfix();
		System.out.println();
		
		w2 = new InfixCalculator("3 * ( 17 - (5+2))/(2+3)");
		w2.evaluateInfix();
		System.out.println();
		
		
	}
}
