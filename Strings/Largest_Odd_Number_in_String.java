class Solution {
    public String largestOddNumber(String num) {
        // return naiveApproach(num);

        return optimalApproach(num);
    }

    public String optimalApproach(String num) {
        int ansIndex = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 == 1) {
                ansIndex = i;
                break;
            }
        }

        return num.substring(0, ansIndex + 1);
    }

    public String naiveApproach(String num) {
        int ansIndex = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (isOdd(i, num)) {
                ansIndex = i;
                break;
            }
        }

        return num.substring(0, ansIndex + 1);
    }

    public boolean isOdd(int i, String num) {
        switch (num.charAt(i)) {
            case '0':
                return false;
            case '1':
                return true;
            case '2':
                return false;
            case '3':
                return true;
            case '4':
                return false;
            case '5':
                return true;
            case '6':
                return false;
            case '7':
                return true;
            case '8':
                return false;
            case '9':
                return true;
            default :
                return true;
        }
        
    }
}