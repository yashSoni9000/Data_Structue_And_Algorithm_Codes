class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        int[] newInterval = intervals[0];
        ans.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) newInterval[1] = Math.max(interval[1], newInterval[1]);
            else {
                newInterval = interval;
                ans.add(interval);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}