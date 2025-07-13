class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(i, j, j, i, matrix);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                swap(i, j, i, (n - 1 - j), matrix);
            }
        }
    }

    public void swap(int first, int second, int third, int fourth, int[][] matrix) {
        int temp = matrix[first][second];
        matrix[first][second] = matrix[third][fourth];
        matrix[third][fourth] = temp;
    }
}