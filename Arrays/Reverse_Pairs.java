class Solution {
    public int reversePairs(int[] nums) {
        int low = 0, high = nums.length - 1;

        int ans = mergeSort(nums, low, high);

        // System.out.println(Arrays.toString(nums));
        return ans;
    }

    public int mergeSort(int[] nums, int low, int high) {
        int ans = 0;
        if (low >= high)
            return 0;

        int mid = (low + high) / 2;

        ans += mergeSort(nums, low, mid);
        ans += mergeSort(nums, mid + 1, high);
        ans += merge(nums, low, mid, high);

        return ans;
    }

    public int merge(int[] nums, int low, int mid, int high) {

        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        int ans = 0;

        int j = right;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > (2L * nums[j])) {
                j++;
            }
            ans += (j - (mid + 1));
        }

        while (left <= mid && right <= high) {
            if (nums[left] < nums[right])
                temp.add(nums[left++]);
            else
                temp.add(nums[right++]);
        }

        while (left <= mid)
            temp.add(nums[left++]);
        while (right <= high)
            temp.add(nums[right++]);

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

        return ans;
    }
}