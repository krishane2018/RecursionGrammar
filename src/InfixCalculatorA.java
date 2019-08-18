
public class InfixCalculatorA {

	private String input;
	
	public InfixCalculatorA(String input) {
		this.input = input;
	}
	
	private boolean isOperator(char operator) {
		if(operator=='+'||operator=='-'||operator=='*'||operator=='/') {
			return true;
		}
		return false;
	}
	
	private int precedence (char operator) {
		if (operator=='+'|| operator=='-') {
			return 1;
		}
		return 2;
	}
	
	public String convertPostfix(String infix) {
		String postfixExp = "";
		StackListBased<Character> stack = new StackListBased<Character>(); 
		for (int i=0;i<infix.length();i++) {
			char ch = infix.charAt(i);
			
			if(Character.isDigit(ch)) {
				postfixExp = postfixExp + ch;
			}
			else if(ch=='(') {
				stack.push(ch);
			}
			else if(ch==')') {
				while(!stack.peek().equals('(')) {
					postfixExp = postfixExp + stack.pop();
				}
				stack.pop();
			}
			else if(isOperator(ch)) {
				while(!stack.isEmpty() && !stack.peek().equals('(') && 
						(precedence(ch)<=precedence(stack.peek()))) {
					postfixExp = postfixExp + stack.pop();
				}
				stack.push(ch);
			}
		}
		while (!stack.isEmpty()) {
			postfixExp = postfixExp + stack.pop();
		}
		return postfixExp;
	}
	
	private int operation (int operand1, int operand2, char operator) {
		if(operator=='+') {
			return (operand1 + operand2);
		}
		else if(operator=='-') {
			return (operand1 - operand2);
		}
		else if(operator=='*') {
			return (operand1 * operand2);
		}
		else {
			return (operand1/operand2);
		}
	}
	
	
	public int getPostfix (String postfix) {
		StackListBased<String> stack = new StackListBased<String>();
		int operand2;
		int operand1;
		char ch;
		int result = 0;
		
		for(int i=0; i<postfix.length();i++) {
			ch = postfix.charAt(i);
			
			if(Character.isDigit(ch)) {
				stack.push(String.valueOf(ch));
			}
			else {
				System.out.println(stack);
				operand2 = Integer.valueOf(stack.pop());
				operand1 = Integer.valueOf(stack.pop());
				result = operation(operand1, operand2, ch);
				stack.push(String.valueOf(result));
			}
		}
		return result;
	}
	
	public void evaluateInfix() {
		System.out.println("infix: "+input);
		String postfix = convertPostfix(input);
		System.out.println("postfix: "+postfix);
		System.out.println("result: "+getPostfix(postfix));
	}
	
	public static void main(String[] args) {
	
	}

}
