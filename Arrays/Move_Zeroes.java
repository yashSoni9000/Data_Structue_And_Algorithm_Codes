class Solution {
    public void moveZeroes(int[] arr) {
        // my approach aka snowball approach
        // myApproach(arr);

        // two pointer approach
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
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) arr[i++] = arr[j];
        }

        while (i != arr.length) arr[i++] = 0; 
    }
}