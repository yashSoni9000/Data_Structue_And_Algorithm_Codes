import java.util.*;
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        int aLength = a.length, bLength = b.length;
        int prev = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < aLength && j < bLength) {
            if (a[i] <= b[j]) {
    	        prev = checkForUnion(prev, ans, a[i++]);
            }
            else {
            	prev = checkForUnion(prev, ans, b[j++]);
            }
        }

        while (j < bLength) {
        	prev = checkForUnion(prev, ans, b[j++]);
        }
        
        while (i < aLength) {
        	prev = checkForUnion(prev, ans, a[i++]);
        }
        
        return ans;
    }
    
    public static int checkForUnion(int prev, ArrayList<Integer> ans, int num) {
        if (num != prev){
        		ans.add(num);
        		prev = num;
        }
        return prev;
    }
}
