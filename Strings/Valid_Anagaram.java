class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() !=  t.length()) return false;

        // return mapApproach(s, t);

        return arrayApproach(s, t);
    }

    public boolean arrayApproach(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }

        return true;
    }

    public boolean mapApproach(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = t.charAt(i);

            mp.put(c, mp.getOrDefault(c, 0) + 1);
            mp.put(c2, mp.getOrDefault(c2, 0) - 1);
        }

        for (Map.Entry<Character, Integer> me : mp.entrySet()) {
            if (me.getValue() != 0) return false;
        }

        return true;
    }
}