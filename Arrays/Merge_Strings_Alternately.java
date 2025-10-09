class Solution {
    public String mergeAlternately(String word1, String word2) {
        int length = Math.min(word1.length(), word2.length());
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (; carry < length; carry++) {
            ans.append(word1.charAt(carry));
            ans.append(word2.charAt(carry));
        }
        for (int i = carry; i < word1.length(); i++) ans.append(word1.charAt(i));
        for (int i = carry; i < word2.length(); i++) ans.append(word2.charAt(i));

        return ans.toString();
    }
}