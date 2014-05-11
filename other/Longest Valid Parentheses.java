public class Solution {
    public int longestValidParentheses(String s) {
        int last = -1;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                if (stack.empty()) {
                    last = i;
                }
                else {
                    stack.pop();
                    if (stack.empty()) {
                        max = Math.max(max, i - last);  //如果stack已经为空
                    }
                    else {
                        max = Math.max(max, i - stack.peek()); //针对这种情况 "(()"
                    }
                }
            }
        }
        return max;
    }
}

//当括号匹配时也不要忘了stack是空与否的判断
