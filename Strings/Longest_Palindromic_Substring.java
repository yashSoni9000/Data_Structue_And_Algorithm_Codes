class Solution {
    public String longestPalindrome(String s) {
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