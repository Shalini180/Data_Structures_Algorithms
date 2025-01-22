class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> ans){
        vis[node] = 1;
        ans.add(node);
        
        for(Integer neighbour : adj.get(node)){
            if(vis[neighbour] == -1){
                dfs(neighbour, adj, vis, ans);
            }
        }
        
    }
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] vis = new int[n+1];
        Arrays.fill(vis, -1);
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, adj, vis, ans);
        return ans;
    }
}
