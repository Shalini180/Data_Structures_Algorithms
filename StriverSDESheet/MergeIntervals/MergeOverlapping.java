class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int i = 1, n = intervals.length;
        int start = intervals[0][0], end = intervals[0][1];
        while(i < n){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                int[] curr = new int[]{start, end};
                ans.add(curr);
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }

        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }
}
