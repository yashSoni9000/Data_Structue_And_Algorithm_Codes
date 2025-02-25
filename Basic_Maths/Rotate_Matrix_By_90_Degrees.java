class Solution {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int index = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][index - j];
                matrix[i][(index - j)] = temp;
            }
        }
    }
}