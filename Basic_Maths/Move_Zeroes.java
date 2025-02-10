class Solution {
    public void moveZeroes(int[] arr) {

        // my approach
        // myApproach(arr);

        // two pointer approach is optimal
        pointerApproach(arr);
    }

    public void myApproach(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) count++;
            else {
                if (count > 0){
                    arr[i - count] = arr[i];
                    arr[i] = 0;
                }
            }
        }
    }

    public void pointerApproach(int[] arr) {
        int n = arr.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] != 0) {
                arr[i] = arr[j];
                i++;
            }
        }

        while (i < n){
            arr[i++] = 0;
        }
    }
}