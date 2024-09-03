 import java.util.*;

public class longestValidSubstring {
    static int findMaxLen(String S) {
        // code here
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else {
                if (st.size() > 0 && S.charAt(st.peek()) == '(') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
        }
        int max = 0;
        int len = S.length();

        while (st.size() > 0) {
            int top = st.pop();
            max = Math.max(max, len - top - 1);
            len = top;
        }
        return Math.max(max, len);
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = { "()(()))))", "(()))(", "()(()" };

        // Iterate through test cases
        for (String testCase : testCases) {
            int maxLength = longestValidSubstring.findMaxLen(testCase);
            System.out.println("Longest valid substring length in '" + testCase + "': " + maxLength);
        }
    }

}
