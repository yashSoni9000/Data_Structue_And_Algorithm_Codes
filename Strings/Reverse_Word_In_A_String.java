class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        // return naiveSolution(s);

        return subOptimalSolution(s);
    }

    public String subOptimalSolution(String s) {
        StringBuilder word = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (word.length() != 0) {
                word = word.reverse();
                ans.append(word);
                ans.append(" ");
                word.setLength(0);
                }
            } else word.append(c);
        }
        word = word.reverse();
        ans.append(word);

        return ans.toString().trim();
    }

    public String naiveSolution(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (word.length() != 0)
                    stack.push(word.toString());
                word.setLength(0);
            } else
                word.append(c);
        }
        stack.push(word.toString());

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
            if (!stack.isEmpty())
                ans.append(" ");
        }

        return ans.toString();
    }
}