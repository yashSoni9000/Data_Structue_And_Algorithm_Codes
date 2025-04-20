class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int strLen = s.length();

        for (int i = 0; i < strLen; i++) {
            Map<Character, Integer> mp = new HashMap<>();
            for (int j = i; j < strLen; j++) {
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                char c = s.charAt(j);
                mp.put(c, mp.getOrDefault(c, 0) + 1);

                for (Map.Entry<Character, Integer> me : mp.entrySet()) {
                    max = Math.max(me.getValue(), max);
                    min = Math.min(me.getValue(), min);
                }
                ans += (max - min);
            }
        }

        return ans;
    }
}