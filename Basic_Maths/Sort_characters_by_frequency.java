class Solution {    
    public List<Character> frequencySort(String s) {
        //your code goes here
        Pair[] pairs = new Pair[26];
        for (int i = 0; i < 26; i++){
            pairs[i] = new Pair(0, (char) (i + 'a'));
        }


        for (int i = 0; i < s.length(); i++){
            pairs[s.charAt(i) - 'a'].num++;
        }

        Arrays.sort(pairs, (p1, p2) -> {
            if (p1.num != p2.num) return p2.num -p1.num;
            return p1.c - p2.c;
        });

        List<Character> result = new ArrayList<>();
        for (Pair p : pairs){
            if (p.num > 0) result.add(p.c);
            else break;
        }

        return result;
    }
}

class Pair{
    public int num;
    public char c;
    Pair(int num, char c){
        this.num = num;
        this.c = c;
    }
}