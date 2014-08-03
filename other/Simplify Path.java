public class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "";
        }
        String[] directory = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String str : directory) {
            if (str.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
            else if (str.length() > 0 && !str.equals(".")) {
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        if (!stack.empty()) {
            sb.append(stack.pop());
        }
        while (!stack.empty()) {
            sb.insert(0,stack.pop()).insert(0, "/");
        }
        return sb.toString();
    }
}

//use a stack
//always insert value at the front of res
//be careful with special cases
//use equals() not == to determine if two strings are equal
