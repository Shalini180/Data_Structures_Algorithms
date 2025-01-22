class Solution {
    public ArrayList<Integer> helper(int v,  ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(0);
        int n = adj.size();
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        vis[0] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(Integer nei : adj.get(node)){
                if(vis[nei] == -1) {
                    q.add(nei);
                    vis[nei] = 1;
                }
            }
        }
        
        return ans;
    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        return helper(V, adj);
    }
}
