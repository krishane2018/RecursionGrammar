import java.util.LinkedList;

public class StackListBased<E> {
	
	private LinkedList<E> items; // Holds the items of the stack.
	
	public StackListBased() {	// Constructor, creates stack.
		createStack();
	}
	
	public void createStack() {		// Creates stack.
		items = new LinkedList<E>();
	}
	
	public void popAll() {			// Removes all the items in the stack.
		items.clear();
	}
	
	public boolean isEmpty() {		// Checks if stack is empty. 
		return items.isEmpty();
	}
	
	public void push (E o) {		// Adds item to the stack.
		items.push(o);
	}
	
	public E pop() throws RuntimeException { // Removes item at the top of the stack and returns it.
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return items.pop();
	}
	
	public E peek() throws RuntimeException{ // Returns the top item of the stack.
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return items.peek();
	}

}
