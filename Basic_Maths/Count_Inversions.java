class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        
        // TC O(n) and SC O(1);
        // return naiveApproach(arr);
        
        
        // 
        return optimalApproach(arr);
    }
    
    static int optimalApproach(int arr[]) {
        int low = 0, high = arr.length - 1;
        
        int[] num = new int[high];
        num = arr;
        
        return mergeSort(num, low, high);
    }
    
    static int mergeSort(int[] arr, int low, int high) {
        
        int ans = 0;
        
        if (low >= high) return ans;
        
        int mid = (low + high) / 2;
        
        ans += mergeSort(arr, low, mid);
        ans += mergeSort(arr, mid + 1, high);
        ans += merge(arr, low, mid, high);
        
        return ans;
    }
    
    static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        int ans = 0;
        
        int first = low, last = mid + 1;
        
        while(first <= mid && last <= high) {
            if (arr[first] <= arr[last]) temp.add(arr[first++]);
            else {
                ans += (mid - first + 1);
                temp.add(arr[last++]);
            }
        }
            
        while (first <= mid) temp.add(arr[first++]);
        while (last <= high) temp.add(arr[last++]);
            
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        
        return ans;
    }
    
    static int naiveApproach(int arr[]) {
        int n = arr.length;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) ans++;
            }
        }
        
        return ans;
    }
}