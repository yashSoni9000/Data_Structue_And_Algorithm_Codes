class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if (low >= high) return;
        
        int mid = partition(arr, low, high);
        quickSort(arr, low, mid - 1);
        quickSort(arr, mid + 1, high);
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        // int i = low, j = high, pivot = arr[low];
        // boolean lowFlag = false, highFlag = false;
        
        // while ((i <= j)) {
        //     if (arr[i] > pivot) lowFlag = true;
        //     else i++;
        //     if (arr[j] < pivot) highFlag = true;
        //     else j--;
            
        //     if (lowFlag && highFlag) {
        //         swap(arr, i, j);
        //         lowFlag = false;
        //         highFlag = false;
        //     }
        // }
        // if (j <= i) swap(arr, low, j);
        // return j;
        
        // optimised/clean code
        int pivot = arr[high];
        int num = low - 1;
        
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot){
                num++;
                swap(arr, num, j);
            }
        }
        
        swap(arr, num + 1, high);
        return num + 1;
    }
    
    static void swap(int[] arr, int curr, int dest){
        int temp = arr[curr];
        arr[curr] = arr[dest];
        arr[dest] = temp;
    }
}