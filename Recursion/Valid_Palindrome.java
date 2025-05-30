class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        // System.out.println(s);
        
        return helper(s, 0);
    }

    public boolean helper(String s, int index) {
        int otherHalf = s.length() - 1 - index;
        if (index >= otherHalf) return true;

        if (s.charAt(index) == s.charAt(otherHalf)) return helper(s, index + 1);

        return false;
    }
}