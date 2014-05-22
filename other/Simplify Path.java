public class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "";
        }
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String s : directories) {
            if (s.equals(".") || s.length() == 0) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(s);
            }
        }
        StringBuilder res = new StringBuilder();
        res.append("/");
        if (stack.empty()) {
            return "/";
        }
        while (!stack.empty()) {
            res.insert(1, stack.pop() + "/");
        }
        String result = res.toString();
        return result.substring(0, result.length() - 1);
    }
}

//use a stack
//always insert value at the front of res
//be careful with special cases
//use equals() not == to determine if two strings are equal
