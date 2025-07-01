class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            boolean flag = false;
            if (i == nums2.length - 1) mp.put(nums2[i], -1);

            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    mp.put(nums2[i], nums2[j]);
                    flag = true;
                    break;
                }
            }

            if(!flag) mp.put(nums2[i], -1);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = mp.get(nums1[i]);
        }

        return ans;
    }
}