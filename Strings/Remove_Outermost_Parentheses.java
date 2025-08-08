class Solution {
    public String removeOuterParentheses(String s) {
        // return stackSolution(s);

        return iterateSolution(s);
    }

    public String iterateSolution(String s) {
        StringBuilder ans = new StringBuilder("");
        int counter = 0;

        for (char ch : s.toCharArray()) {
            if ( ch == '(') {
                if (counter > 0) ans.append("(");
                counter++;
            }
            else if (ch == ')') {
                if (counter > 1) ans.append(")");
                counter--;
            }
        }
        
        return ans.toString();
    }

    public String stackSolution(String s) {
        StringBuilder ans = new StringBuilder("");
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if ( ch == '(') {
                if (!stack.empty()) ans.append("(");
                stack.push('(');
            }
            else if (ch == ')') {
                stack.pop();
                if (!stack.empty()) ans.append(")");
            }
        }
        
        return ans.toString();
    }
}