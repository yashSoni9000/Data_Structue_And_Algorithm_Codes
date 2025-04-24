class Solution {
    public boolean isIsomorphic(String s, String t) {
        // return normalApproach(s, t);

        return simpleApproach(s, t);
    }

    public boolean simpleApproach(String s, String t) {
        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (mapST[s.charAt(i)] != mapTS[t.charAt(i)]) return false;
            mapST[s.charAt(i)] = i + 1;
            mapTS[t.charAt(i)] = i + 1;
        }

        return true;
    }

    public boolean normalApproach(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i <  s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (mapST.containsKey(cs) && mapST.get(cs) != ct) return false;
            if (mapTS.containsKey(ct) && mapTS.get(ct) != cs) return false;

            mapST.put(cs, ct);
            mapTS.put(ct, cs);
        }        

        return true;
    }
}