class Solution {
    public boolean isValid(String s) {
        int strLen = s.length();
        if (strLen % 2 != 0) return false;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') st.push(c);
            else {
                if (st.empty()) return false;
                switch(c) {
                    case ')' :
                        if ('(' != st.peek()) return false;
                        st.pop();
                        break;
                    case '}' :
                        if ('{' != st.peek()) return false;
                        st.pop();
                        break;
                    case ']' :
                        if ('[' != st.peek()) return false;
                        st.pop();
                        break;
                    default :
                        return false;
                }
            }
        }
        if (!st.empty()) return false;

        return true;
    }
}