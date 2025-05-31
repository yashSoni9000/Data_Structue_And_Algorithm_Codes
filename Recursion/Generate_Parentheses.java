class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, 0, 0, "", n);

        return ans;
    }

    public void helper(List<String> ans, int left, int right, String s, int n) {
        if (s.length() == (2 * n)) {
            ans.add(s);
            return;
        }

        if (left < n) helper(ans, left + 1, right, s + "(", n);
        if (right < left) helper(ans, left, right + 1, s + ")", n);
    }
}