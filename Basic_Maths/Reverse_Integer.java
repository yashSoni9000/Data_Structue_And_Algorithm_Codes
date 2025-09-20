class Solution {
    public int reverse(int x) {
        int count = 0, num =Math.abs(x);
        while(num != 0){
            int lastDigit = num % 10;
            if ((count > (Integer.MAX_VALUE - lastDigit) / 10)) return 0;
            count = (count * 10) + lastDigit;
            num /= 10;
        }
        return (x > 0) ? count : (-count);
        
    }
}