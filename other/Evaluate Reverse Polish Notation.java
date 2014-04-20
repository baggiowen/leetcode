public class Solution {
    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            }
            else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (t) {
                    case "+": stack.push(String.valueOf(b + a)); break;
                    case "-": stack.push(String.valueOf(b - a)); break;
                    case "*": stack.push(String.valueOf(b * a)); break;
                    case "/": stack.push(String.valueOf(b / a)); break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//use a stack
//switch
//String.valueOf
