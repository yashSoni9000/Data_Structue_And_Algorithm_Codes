class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int floor = -1, ceil = Integer.MAX_VALUE;
        int[] ans = new int[2];
        
        for (int num : arr) {
            if (num < x && num > floor) floor = num;
            else if (num > x && num < ceil) ceil = num;
            else if (x == num) floor = ceil = num;
        }
        
        ans[0] = floor;
        ans[1] = (ceil == Integer.MAX_VALUE) ? -1 : ceil;
        
        return ans;
    }
}