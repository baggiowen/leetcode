//evaluate result of expression, expression contains "+ - * /"
//http://www2.lawrence.edu/fast/GREGGJ/CMSC150/Infix/Expressions.html

import java.util.HashMap;
import java.util.Stack;

public class Calculator {

	/**
	 * @param args
	 */
	
    public static int calculate(String str) {
    	Stack<Integer> num = new Stack<Integer>();
    	Stack<Character> operators = new Stack<Character>();
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	map.put('+', 1);
    	map.put('-', 1);
    	map.put('*', 2);
    	map.put('/', 2);
    	for (int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		if (c >= '0' && c <= '9') {
    			num.push(c - '0');
    		}
    		else {
    			if (operators.isEmpty()) {
    				operators.push(c);
    			}
    			else {
    				char top = operators.peek();
    				if (map.get(c) > map.get(top)) {
    					operators.push(c);
    				}
    				else {
    					while (!operators.isEmpty() && map.get(operators.peek()) >= map.get(c)) {
    						int num1 = num.pop();
    						int num2 = num.pop();
    						char op = operators.pop();
    						int result = helper(num2, num1, op);
    						num.push(result);
    					}
    					operators.push(c);
    				}
    			}
    		}
    	}
    	while (!operators.isEmpty()) {
    		int num1 = num.pop();
    		int num2 = num.pop();
    		char op = operators.pop();
    		int result = helper(num2, num1, op);
    		num.push(result);
    	}
    	return num.pop();
    }
    
    public static int helper(int a, int b, char c) {
    	switch (c) {
    	case '+': return a + b;
    	case '-': return a - b;
    	case '*': return a * b;
    	case '/': return a / b;
    	default: return 0;
    	}
    }
	
	public static void main(String[] args) {
		String str = "1-1*2*3/6+1+3+1*2*3";
		System.out.print(calculate(str));
	}
}
