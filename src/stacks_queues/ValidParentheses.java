package stacks_queues;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "([{}]))";
        System.out.println(isValidParenthesis(s));
    }

    public static boolean isValidParenthesis(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') st.push(ch);
            else {
                if (st.isEmpty()) return false;
                char rem = st.pop();
                if (!((ch == ')' && rem == '(') || (ch == '}' && rem == '{') || (ch == ']' && rem == '[')))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
