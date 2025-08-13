class Solution {    
    public String frequencySort(String s) {
        //your code goes here

        // not so optimal
        // return myAppropach(s);

        // more optimal
        return optimal(s);
    }

    public String optimal(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        List<Pair> pairs = new ArrayList<>();

        for (char i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                pairs.add(new Pair(freq[i], i));
            }
        }

        pairs.sort((p1, p2) -> p2.value - p1.value);

        StringBuilder ans = new StringBuilder();
        for (Pair p : pairs) {
            ans.append(String.valueOf(p.c).repeat(p.value));
        }

        return ans.toString();
    }

    public String myApproach(String s) {
        Pair[] pairs = new Pair[62];
        String ans = "";
        for (int i = 0; i < 62; i++) {
            if (i < 10) pairs[i] = new Pair(0, (char) (i + '0'));
            else if (i < 36) pairs[i] = new Pair(0, (char) ((i - 10) + 'A'));
            else pairs[i] = new Pair(0, (char) ((i - 36) + 'a'));
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // System.out.print(((c - 'a') + 36) + " ");
            if (c >= '0' && c <= '9') pairs[(c - '0')].value++;
            else if (c >= 'A' && c <= 'Z') pairs[(c - 'A') + 10].value++;
            else if (c >= 'a' && c <= 'z') pairs[((c - 'a') + 36)].value++;
        }

        Arrays.sort(pairs, (p1, p2) -> {
            if (p1.value != p2.value) {
                return p2.value - p1.value;
            }
            else return p1.c - p2.c;
        });

        for (int i = 0; i < 62; i++) {
            // System.out.println(pairs[i].value + " " + pairs[i].c);
            if (pairs[i].value > 0) {
                for (int j = 0; j < pairs[i].value; j++) {
                    ans += pairs[i].c;
                }
            }
            else break;
        }
        
        return ans;
    }
}

class Pair {
    int value;
    char c;
    Pair(int value, char c) {
        this.value = value;
        this.c = c;
    }
}