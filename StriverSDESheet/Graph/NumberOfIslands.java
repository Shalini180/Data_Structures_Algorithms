class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public boolean[][] calcVisited(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') visited[i][j] = false;
                else visited[i][j] = true;
            }
        }
        return visited;
    }

    public int bfsHelper(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean visited[][] = calcVisited(grid);
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {  // If it's land and not visited
                    bfs(i, j, grid, n, m, visited);
                    count++;  // Increment island count
                }
            }
        }

        return count;
    }

    public void bfs(int i, int j, char[][] grid, int n, int m, boolean[][] vis) {
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            // Traverse in 4 directions
            for (int k = 0; k < 4; k++) {
                int newX = x + delRow[k];
                int newY = y + delCol[k];

                // Check if the new cell is valid and not visited
                if (newX >= 0 && newX < n && newY >= 0 && newY < m &&
                    grid[newX][newY] == '1' && !vis[newX][newY]) {
                    vis[newX][newY] = true;
                    q.add(new Pair(newX, newY));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        return bfsHelper(grid);
    }
}
