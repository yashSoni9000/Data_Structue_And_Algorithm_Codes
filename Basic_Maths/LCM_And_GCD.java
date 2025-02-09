class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        // code here mail no, direct office
        int[] ans = new int[2];
        int hcf = 1;
        int hcfMin = Math.min(a, b);
        while (hcfMin > 0) {
            if ((a % hcfMin == 0) && (b % hcfMin == 0)){
                hcf = hcfMin;
                break;
            }
            hcfMin--;
        }
        ans[0] = (a * b) / hcf;
        ans[1] = hcf;
        return ans;
    }
}