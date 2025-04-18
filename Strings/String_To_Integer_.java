class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int strLen = s.length();

        if (s.length() == 0)
            return 0;

        boolean isNegative = false;
        int i = 0;
        long ans = 0; // Use long to avoid overflow
        int maxLimit = Integer.MAX_VALUE / 10;

        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            isNegative = s.charAt(i) == '-';
            i++;
        }

        for (; i < strLen; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                // Check overflow before updating ans
                if (ans > maxLimit || (ans == maxLimit && digit > (isNegative ? 8 : 7))) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = (ans * 10) + digit;
            } else {
                break;
            }
        }

        ans = isNegative ? -ans : ans; // Apply sign
        // Clamp to integer bounds
        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) ans;
    }
}