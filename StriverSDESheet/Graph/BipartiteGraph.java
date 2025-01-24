class Solution {
    public boolean bfsHelper(int ind, int[][] graph, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(ind);
        vis[ind] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : graph[node]) {
                if (vis[nei] == -1) {
                    vis[nei] = 1 - vis[node];
                    q.add(nei);
                } else if (vis[nei] == vis[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfsHelper(int node, int[][] graph, int[] vis, int color){
        vis[node] = color;
        for(int nei : graph[node]){
            if(vis[nei] == -1){
                vis[nei] = 1 - color;
                boolean check = dfsHelper(nei, graph, vis, vis[nei]);
                if(check == false) return check;
            }
            else if(vis[nei] == color) return false; 
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                if (!dfsHelper(i, graph, vis, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
