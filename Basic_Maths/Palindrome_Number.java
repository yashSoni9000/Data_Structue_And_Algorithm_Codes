class Solution {
    public boolean isPalindrome(int x) {
        // if (x < 0) return false;
        // int num = x, ans = 0;
        // while(num > ans){
        //     int lastDigit = num % 10;
        //     ans = (ans * 10) + lastDigit;
        //     num /= 10;
        // }
        // if (ans == x) return true;
        // return false;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        return x == reversedHalf || x == reversedHalf / 10;
        
    }
}