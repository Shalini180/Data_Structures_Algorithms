class Pair{
    Integer node;
    Integer parent;
    Pair(Integer node, Integer parent){
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    public boolean bfsHelper(ArrayList<ArrayList<Integer>> adj, int[] vis, int start){
        int n = adj.size();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        vis[start] = 1;
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node, parent = pair.parent;
            for(int nei : adj.get(node)){
                if(vis[nei] == -1){
                    q.add(new Pair(nei, node));
                    vis[nei] = 1;
                }
                else if(parent != nei) return true;
            }
        }
        
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for(int i = 0; i < n;i++){
            if(vis[i] == -1){
               if(bfsHelper(adj, vis, i) == true) return true;
            }
        }
        
        return false;
    }
}
