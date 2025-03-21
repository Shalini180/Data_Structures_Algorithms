class Solution {
    public int orangesRotting(int[][] grid) {
        int totalCount = 0;
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) q.add(new int[]{i, j});
                else if(grid[i][j] == 1) totalCount += 1;
            }
        }
        if(totalCount == 0) return 0;

        int totalMinutes = 0;
        int[] row = {0, 0, -1, 1};
        int[] col = {-1, 1, 0, 0};
        int time = -1;
        while(q.size() > 0) {
            int k = q.size();
            for(int i = 0; i < k;i++) {
                int[] coord = q.poll();
                for(int j = 0; j < 4; j++){
                    int nRow = coord[0] + row[j];
                    int nCol = coord[1] + col[j];
                    if(nRow < 0 || nCol < 0 || nRow >= n || nCol >= m || grid[nRow][nCol] != 1) continue;
                    q.add(new int[]{nRow, nCol});
                    grid[nRow][nCol] = 2;
                    totalCount--;
                }
            }

            time++;
        }

        return (totalCount == 0) ? time : -1;
    }
}
