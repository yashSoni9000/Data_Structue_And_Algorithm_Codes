class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String combinedString = s + s;
        if (combinedString.contains(goal)) return true;
        
        return false;
        
    }
}