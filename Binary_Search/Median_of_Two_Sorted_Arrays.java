class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return naiveApproach(nums1, nums2);
    }

    public double naiveApproach(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int totalLength = n + m;
        int[] combined = new int[totalLength];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                combined[k++] = nums1[i++];
            } else {
                combined[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) combined[k++] = nums1[i++];
        while (j < nums2.length) combined[k++] = nums2[j++];

        int mid = totalLength / 2;
        if (totalLength % 2 == 0) {
            return (combined[mid - 1] + combined[mid]) / 2.0;
        } else {
            return combined[mid];
        }
    }
}