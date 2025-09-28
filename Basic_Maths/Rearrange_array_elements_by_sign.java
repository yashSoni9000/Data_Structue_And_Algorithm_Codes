class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // TC is O(n) but SC is O(n) 
        // return naiveApproach(nums, n);

        // sub Optimal Approach with SC  O(n) and TC O(n) but better
        // return subOptimalApproach(nums, n);

        // most optimal
        return optimalApproach(nums, n);
    }

    // optimal Approach
    public int[] optimalApproach(int[] nums, int n) {
        int posIndex = 0, negIndex = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
            else {
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    // optimal Approach
    public int[] subOptimalApproach(int[] nums, int n) {
        int positive = giveIndex(nums, n, 0, true);
        int negative = giveIndex(nums, n, 0, false);
        int[] ans = new int[n];
        int index = 0;
        while (positive < n && negative < n) {
            ans[index++] = nums[positive];
            ans[index++] = nums[negative];
            positive = giveIndex(nums, n, positive + 1, true);
            negative = giveIndex(nums, n, negative + 1, false);
        }
        // System.out.println(positive + " " + negative);
        return ans;
    }

    public int giveIndex(int[] nums, int n, int index, boolean isPositive) {
        int num = index;
        for (int i = index; i < n; i++) {
            if (isPositive) {
                if (nums[i] >= 0){ 
                    num = i;
                    break;
                }
            }
            else {
                if (nums[i] < 0) {
                    num = i;
                    break;
                }
            }
        }
        return num;
    }

    // naive Approach
    public int[] naiveApproach(int[] nums, int n) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) negative.add(nums[i]);
            else positive.add(nums[i]);
        }

        int[] ans = new int[n];
        int index = 0;

        for (int i = 0; i < n; i += 2) {
            ans[i] = positive.get(index);
            ans[i + 1] = negative.get(index);
            index++;
        }
        return ans;
        
    }
}