class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        
        // SC is high
        // return naiveApproach(ans, numRows);

        // More optimal approach
        return optimalApproach(ans, numRows);

        //in case we want to print specific row 
        // printSpecificRow(numRows);
    }

    public void printSpecificRow(int numRows) {
        int ans = 1;
        for (int i = 1; i < numRows - 1; i++) {
            ans *= (numRows - i);
            ans /= i;
            System.out.print(ans + " ");
        }
     }

    // Optimal solution
    public List<List<Integer>> optimalApproach(List<List<Integer>> ans, int numRows) {
        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) curr.add(1);
                else {
                    int nCrs = nCr(i , j);
                    curr.add(nCrs);
                }
            }
            ans.add(curr);
        }

        // called for printing Nth row directly
        printSpecificRow(numRows);
        return ans;
    }

    public int nCr(int n, int r) {
        int mul = 1;
        for (int i = 0; i < r; i++) {
            mul *= (n - i);
            mul /= (i + 1);
        }
        return mul;
    }

    // naive Approach
    public List<List<Integer>> naiveApproach(List<List<Integer>> ans, int numRows) {
        for(int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) curr.add(1);
                else {
                    List<Integer> temp = ans.get(i - 1);
                    curr.add(temp.get(j - 1) + temp.get(j));
                }
            }
            ans.add(curr);
        }
        return ans;
    }
}