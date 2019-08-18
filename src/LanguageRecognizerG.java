public class LanguageRecognizerG {
	
	private String input;
	
	public LanguageRecognizerG(String input) {
	
		this.input=input;
	}
	
	private boolean isE (char myChar) { // Determine if a character is in "E"
		if(myChar=='&'||myChar=='#') {
			return true;
		}
		return false;
	}
	
	private boolean isV (char myChar) { // Determines if a character is in "V"
		if(myChar=='W'||myChar=='A') {
			return true;
		}
		return false;
	}
	
	public void recursivePrintG() { // Outputs whether the string is in the language G 
		if(recursiveRecogG (input)) {
			System.out.format("Recusion: Word \"%s\" IS a word of the G language \n", input);
		}
		else {
			System.out.format("Recusion: Word \"%s\" is NOT a word of the G language \n", input);
		}
	}
	
	public boolean recursiveRecogG (String word) {
		if (word.equals("")) {	// Base Case
			return true;
		}
		else if(word.length()==1 && isE(word.charAt(0))) { // Base Case
			return true;
		}
		else if (word.length()==2 && isV(word.charAt(0)) && isE(word.charAt(1))) { // Base Case
			return true;
		}
		else if (isE(word.charAt(0)) && isV(word.charAt(word.length()-1))) { // Recursive case
			return recursiveRecogG(word.substring(1,word.length()-1));
		}
		return false;
	}
	

}
