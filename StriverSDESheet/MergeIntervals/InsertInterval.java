class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, start = newInterval[0], end = newInterval[1];
        int i = 0;
        List<int[]> ans = new ArrayList<>();
        while(i < n && intervals[i][1] < start){
            ans.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        ans.add(new int[]{start, end});

        while(i < n){
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
