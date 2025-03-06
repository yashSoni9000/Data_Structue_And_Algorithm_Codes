class Solution {
    public void setZeroes(int[][] matrix) {
        // sub optimal
        // subOptimal(matrix);

        optimal(matrix);
    }

    // optimal
    public void optimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean row = false, col = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row = true;
                    if (j == 0) col = true;

                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }

        if (col) for (int i = 0; i < n; i++) matrix[i][0] = 0;
        if (row) for (int j = 0; j < m; j++) matrix[0][j] = 0;
    }

    // sub optimal
    public void subOptimal(int[][] matrix) {
        ArrayList<ArrayList<Integer>> mp = new ArrayList<ArrayList<Integer>>();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);

                    mp.add(temp);
                }
            }
        }

        for (ArrayList<Integer> index : mp) {
            int first = index.get(0);
            int second = index.get(1);

            for (int i = 0; i < n; i++) matrix[i][second] = 0;
            for (int i = 0; i < m; i++) matrix[first][i] = 0;
        }
    }
}