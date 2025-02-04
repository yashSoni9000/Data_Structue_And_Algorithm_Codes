class Solution {
    static int evenlyDivides(int n) {
        // code here
        int count = 0, num = n;
        while (num > 0){
            int temp = num % 10;
            if (temp != 0 && (n % temp) == 0) count++;
            num /= 10;
        }
        return count;
    }
}