class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int minRow = 0, minCol = 0;
        int maxRow = matrix.length - 1, maxCol = matrix[0].length - 1;

        while (minRow <= maxRow && minCol <= maxCol) {
            for (int i = minCol; i <= maxCol; i++) ans.add(matrix[minRow][i]);
            minRow++;

            for (int i = minRow; i <= maxRow; i++) ans.add(matrix[i][maxCol]);
            maxCol--;

            if (minRow > maxRow || minCol > maxCol) break;

            for (int i = maxCol; i >= minCol; i--) ans.add(matrix[maxRow][i]);
            maxRow--;

            for (int i = maxRow; i >= minRow; i--) ans.add(matrix[i][minCol]);
            minCol++;
        }
        return ans;
    }
}