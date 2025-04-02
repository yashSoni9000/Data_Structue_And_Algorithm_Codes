import java.util.*;

class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int stalls = sc.nextInt();
            int cows = sc.nextInt();
            int[] location = new int[stalls];

            for (int i = 0; i < stalls; i++) {
                location[i] = sc.nextInt();
            }
            Arrays.sort(location);

            Solution ac = new Solution();
            int result = ac.aggresiveCows(location, cows);
            System.out.println(result);

            t--;
        }
        sc.close();
    }
}

class Solution {
    public int aggresiveCows(int[] location, int cows) {
        // No need for min and max parameters as we can get them from sorted array
        int low = 1; // minimum possible distance
        int high = location[location.length - 1] - location[0]; // maximum possible distance
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canFitCows(location, mid, cows)) {
                ans = mid;  // store the current valid answer
                low = mid + 1;  // try for larger distance
            } else {
                high = mid - 1;  // try for smaller distance
            }
        }
        
        return ans;
    }

    public boolean canFitCows(int[] location, int dist, int cows) {
        int currCows = 1;  // place first cow at first position
        int last = location[0];
        
        // Check all positions up to the last one
        for (int i = 1; i < location.length; i++) {
            if (location[i] - last >= dist) {
                currCows++;
                last = location[i];
                if (currCows == cows) return true;  // early return if all cows placed
            }
        }
        
        return currCows >= cows;
    }
}