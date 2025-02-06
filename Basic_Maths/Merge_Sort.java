class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if (l >= r) return;
        int mid = (l + r) / 2;
        
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
    void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int inc = mid + 1, tempArrCounter = 0;
        int low = left, high = right;
        
        while (left <= mid && (inc) <= right) {
            
            if (arr[left] < arr[inc]) {
                temp[tempArrCounter++] = arr[left++];
            }
            else {
                temp[tempArrCounter++] = arr[inc++];

            }
        }
        
        while (left <= mid) {
            temp[tempArrCounter++] = arr[left++];
        }
        
        while (inc <= right) {
            temp[tempArrCounter++] = arr[inc++];
        }
        
        for (int i = low; i <= high; i++){
            arr[i] = temp[i - low];
        }
    }
}