class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] row = new long[n];
        long[] col = new long[m];
        for(int i = 0;i<n;i++){
            long c = 0;
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1)
                    c+= 1;
            }

            row[i] = c;
        }

        for(int i = 0;i<m;i++){
            long c = 0;
            for(int j = 0;j < n;j++){
                if(grid[j][i] == 1) c+= 1;
            }

            col[i] = c;
        }

        long total = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1)
                    total += (row[i] - 1) * (col[j] - 1);
            }
        }

        return total;
    }
}
