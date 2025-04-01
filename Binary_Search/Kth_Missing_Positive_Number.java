class Solution {
    public int findKthPositive(int[] arr, int k) {
        // return naiveSolution(arr, k);

        // return optimalSolution(arr, k);

        return geniousSolution(arr, k);
    }

    public int geniousSolution(int[] nums, int k) {
        for (int num : nums) {
            if (num <= k) k++;
            else break;
        }

        return k;
    }

    public int optimalSolution(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        int currDiff = 0, currNum = 0;
        int diff = 0, num = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            
            currDiff = nums[mid] - (mid+ 1);
            currNum = nums[mid];

            if (currDiff < k) {
                low = mid + 1;
                diff = currDiff;
                num = currNum;
            }
            else high = mid - 1;
        }

        return num + (k - diff);
    }

    public int naiveSolution(int[] nums, int k) {
        List<Integer> missingNumber = new ArrayList<>();
        int current = 1;

        for (int num : nums) {
            if (num != current) {
                while (current < num) missingNumber.add(current++);
            }
            current++;
        }
        while (missingNumber.size() <= k) missingNumber.add(current++);

        return missingNumber.get(k - 1);
    }
}