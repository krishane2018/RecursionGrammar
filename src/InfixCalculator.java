public class InfixCalculator {

	private String input;

	public InfixCalculator(String input) {
		this.input = input;
	}

	private boolean isOperator(char operator) { // Determines whether the character is an operator.
		if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
			return true;
		}
		return false;
	}

	private int precedence(char operator) { // Determines precedence of operation.
		if (operator == '+' || operator == '-') {
			return 1;
		}
		return 2;
	}

	public String convertPostfix(String infix) {
		String tempInt = "";    // Used to store integer till it is placed in the postfix string.
		String postfixExp = ""; // Stores postfix expression
		StackListBased<Character> stack = new StackListBased<Character>();

		for (int i = 0; i < infix.length(); i++) { // Runs through infix expression and organizes it
			char ch = infix.charAt(i); 			   // into postfix expression.

			if (Character.isDigit(ch)) { // Stores digit into string till full integer has been
				tempInt += ch; 			 // stored.
			} 
			else {
				
				if (!tempInt.equals("")) { // Adds full integer into postfix expression.
					postfixExp += (tempInt + " ");
					tempInt = "";
				}
				
				if (ch == '(') {
					stack.push(ch);
				} 
				
				else if (ch == ')') {
					while (!stack.peek().equals('(')) {
						postfixExp += (String.valueOf(stack.pop()) + " ");
					}
					stack.pop();
				} 
				
				else if (isOperator(ch)) {
					while (!stack.isEmpty() && !stack.peek().equals('(')
							&& (precedence(ch) <= precedence(stack.peek()))) {
						postfixExp += (String.valueOf(stack.pop()) + " ");
					}
					stack.push(ch);
				}
			}
		}
		
		if(!tempInt.equals("")) {
			postfixExp+=(tempInt+" "); //Needed if last character of infix is integer.
		}
		
		while (!stack.isEmpty()) {
			postfixExp += (String.valueOf(stack.pop()) + " ");// Adds all the characters left in the
		} 													  // stack to the postfix expression.

		return postfixExp.trim();
	}

	private double operation(double operand1, double operand2, char operator) { //Calculates operation
		if (operator == '+') {
			return (operand1 + operand2);
		} 
		else if (operator == '-') {
			return (operand1 - operand2);
		} 
		else if (operator == '*') {
			return (operand1 * operand2);
		} 
		else {
			return (operand1 / operand2);
		}
	}

	public int getPostfix(String postfix) {	// Determines the result of postfix operation
		StackListBased<Double> stack = new StackListBased<Double>();
		String[] arrPostfix = postfix.split(" ");
		double tempNum;
		double operand2;				// Initialization of variables
		double operand1;
		String str;
		double result = 0;

		for (int i = 0; i < arrPostfix.length; i++) {	// Runs through postfix expression and 
			str = arrPostfix[i];						// step by step calculates the result.

			try {										// Determines whether string is digit or 
				tempNum = Double.parseDouble(str);		// operator.
				stack.push(tempNum);
			} catch (NumberFormatException e) {
				operand2 = stack.pop();
				operand1 = stack.pop();
				result = operation(operand1, operand2, str.charAt(0));
				stack.push(result);
			}
		}
		return (int) result;
	}

	public void evaluateInfix() {				// Prints out the infix and postfix expression as 
		System.out.println("infix: " + input);	// well as the result.
		String postfix = convertPostfix(input);
		System.out.println("postfix: " + postfix);
		System.out.println("result: " + getPostfix(postfix));
	}


}
