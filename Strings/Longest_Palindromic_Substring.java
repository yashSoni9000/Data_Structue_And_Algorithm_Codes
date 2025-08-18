class Solution {
    public String longestPalindrome(String s) {
        // return naiveSolution(s);

        return betterSolution(s);
    }

    public String betterSolution(String s) {
        if (s.length() <= 1) return s;

        String longestPalindrome = s.substring(0,1);

        for (int i = 0; i < s.length(); i++) {
            String odd = midStart(s, i, i); // if palindrome is odd
            String even = midStart(s, i, i + 1); // if palindrome is even

            if (odd.length() > longestPalindrome.length()) longestPalindrome = odd;
            if (even.length() > longestPalindrome.length()) longestPalindrome = even;
        }

        return longestPalindrome;
    }

    public String midStart(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }

    // naive approach
    public String naiveSolution(String s) {
        int strLen = s.length();

        for (int i = strLen ; i > 0; i--) {
            for (int j = 0; j <= strLen - i; j++) {
                if (check(j, i + j, s)) {
                    return s.substring(j, i + j);
                }
            }
        }

        return "";
    }

    public boolean check (int i, int j, String s) {
        int start = i;
        int end = j - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
        
    }
}