class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // return naiveApproach(nums1, nums2);

        return binaryApproach(nums1, nums2);
    }
    public double binaryApproach(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) return binaryApproach(nums2, nums1);
        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int mid1 = low + ((high - low) / 2);
            int mid2 = left - mid1;

            int l1 = (mid1 - 1) >= 0 ? nums1[(mid1 - 1)] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1) >= 0 ? nums2[(mid2 - 1)] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE;

            if ((l1 <= r2) && (l2 <= r1)) {
                // System.out.println((double)Math.max(l1, l2));
                if ((n1 + n2) % 2 == 1) return (double)Math.max(l1, l2);
                return ((double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
            }
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }

        return 0;        
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