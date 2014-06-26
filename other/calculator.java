//evaluate result of expression, expression contains "+ - * /"
//http://www2.lawrence.edu/fast/GREGGJ/CMSC150/Infix/Expressions.html

import java.util.HashMap;
import java.util.Stack;

public class Calculator {
    public static int calculate(String str) {
    	Stack<Integer> num = new Stack<Integer>();
    	Stack<String> operators = new Stack<String>();
    	String temp = "+-*/";
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	map.put("+", 1);
    	map.put("-", 1);
    	map.put("*", 2);
    	map.put("/", 2);
    	String[] tokens = str.split(" ");
    	for (String token : tokens) {
    		if (!temp.contains(token)) {
    			num.push(Integer.parseInt(token));
    		}
    		else {
    			if (operators.empty()) {
    				operators.push(token);
    			}
    			else {
    				String prev = operators.peek();
    				if (map.get(prev) < map.get(token)) {
    					operators.push(token);
    				}
    				else {
    					while (!operators.empty() && map.get(operators.peek()) >= map.get(token)) {
    						int num1 = num.pop();
    						int num2 = num.pop();
    						String op = operators.pop();
    						int result = helper(num2, num1, op);
    						num.push(result);
    					}
    					operators.push(token);
    				}
    			}
    		}
    	}
    	while (!operators.empty()) {
    		int num1 = num.pop();
    		int num2 = num.pop();
    		String op = operators.pop();
    		num.push(helper(num2, num1, op));
    	}
    	return num.pop();
    }
    
    public static int helper(int a, int b, String s) {
    	switch (s) {
    	case "+": return a + b;
    	case "-": return a - b;
    	case "*": return a * b;
    	case "/": return a / b;
    	default: return 0;
    	}
    }
	
	public static void main(String[] args) {
		String str = "10 - 1 * 2 * 3 / 6 + 1 + 3 + 1 * 2 * 3";
		System.out.print(calculate(str));
	}
}

