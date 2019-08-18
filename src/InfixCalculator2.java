import java.util.ArrayList;

public class InfixCalculator2 {

	private String input;
	
	public InfixCalculator2(String input) {
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
	
	public ArrayList<String> convertPostfix(String infix) {
		String temp="";
		ArrayList<String> postfixExp = new ArrayList<String>();
		StackListBased<Character> stack = new StackListBased<Character>(); 
		for (int i=0;i<infix.length();i++) {
			char ch = infix.charAt(i);
			
			if(Character.isDigit(ch)) {
				//postfixExp = postfixExp + ch;
				temp+=ch;
			}
			else {
				if (!temp.equals("")) {
					postfixExp.add(temp);
					temp="";
				}
				if(ch=='(') {
					stack.push(ch);
				}
				else if(ch==')') {
					while(!stack.peek().equals('(')) {
						//postfixExp = postfixExp + stack.pop();
						postfixExp.add(String.valueOf(stack.pop()));
					}
					stack.pop();
				}
				else if(isOperator(ch)) {
					while(!stack.isEmpty() && !stack.peek().equals('(') && 
							(precedence(ch)<=precedence(stack.peek()))) {
						//postfixExp = postfixExp + stack.pop();
						postfixExp.add(String.valueOf(stack.pop()));
					}
					stack.push(ch);
				}
			}
		}
		while (!stack.isEmpty()) {
			//postfixExp = postfixExp + stack.pop();
			postfixExp.add(String.valueOf(stack.pop()));
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
	
	
	public int getPostfix (ArrayList<String> postfix) {
		StackListBased<Integer> stack = new StackListBased<Integer>();
		int temp;
		int operand2;
		int operand1;
		String ch;
		int result = 0;
		
		for(int i=0; i<postfix.size();i++) {
			ch = postfix.get(i);
			
			
			try {
				temp = Integer.parseInt(ch);
				stack.push(temp);
			}
			catch (Exception e) {
				operand2 = stack.pop();
				operand1 = stack.pop();
				result = operation(operand1, operand2, ch.charAt(0));
				stack.push(result);
			}
		}
		return result;
	}
	
	public void evaluateInfix() {
		System.out.println("infix: "+input);
		ArrayList<String> postfix = convertPostfix(input);
		System.out.println("postfix: "+postfix);
		System.out.println("result: "+getPostfix(postfix));
	}
	
	public static void main(String[] args) {
	
	}

}
