class Solution {
    public int romanToInt(String s) {
        int strLength = s.length();
        int ans = 0;

        for (int i = 0; i < strLength; i++) {
            char c1 = s.charAt(i);
            char c2 = 'P';
            if ((i + 1) < strLength) c2 = s.charAt(i + 1);

            int initial = valueOfRoman(c1);
            int next = valueOfRoman(c2);

            if (initial < next) {
                ans += (next - initial);
                i++;
            }
            else ans += initial;
        }

        return ans;
    }

    public int valueOfRoman(char c) {
        switch (c) {
            case 'I' :
                return 1;
            case 'V' :
                return 5;
            case 'X' :
                return 10;
            case 'L' :
                return 50;
            case 'C' :
                return 100;
            case 'D' :
                return 500;
            case 'M' :
                return 1000;
            default :
                return 0;
        }
    }
}