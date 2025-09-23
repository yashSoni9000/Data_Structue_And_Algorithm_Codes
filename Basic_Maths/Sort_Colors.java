class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;

        // my approach uses O(n) but has SC of O(n)
        // myApproach(arr, n);

        // optimal Approach with O(n) TC and O(1) SC
        optimalApproach(arr, n);
    }

    // optimal Approach
    public void optimalApproach(int[] arr, int n) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
            else mid++;
        }
    }

    public void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    // my approach
    public void myApproach(int[] arr, int n) {
        int[] freq = new int[3];
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            index = replaceNumbers(arr, index, freq[i], i);
        }
    }
    public int replaceNumbers(int[] arr, int index, int count, int value) {
        while (count > 0) {
            arr[index++] = value;
            count--;
        }
        return index;
        
    }
}