class Solution {
    static int[] calcInDegree(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            for(int node : adj.get(i)) arr[node] += 1;
        }
        
        return arr;
    }
    static ArrayList<Integer> bfsHelper(ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = calcInDegree(adj);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0) q.add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int nei : adj.get(node)){
                inDegree[nei] -= 1;
                if(inDegree[nei] == 0) q.add(nei);
            }
        }
        
        return ans;
    }
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> ans){
        vis[node] = 1;
        for(int nei : adj.get(node)){
            if(vis[nei] == -1){
                dfs(nei, adj, vis, ans);
            }
        }
        
        ans.add(node);
    }
    static ArrayList<Integer> dfsHelper(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n;i++){
            if(vis[i] == -1) dfs(i, adj, vis, ans);
        }
        Collections.reverse(ans);
        return ans;
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        return dfsHelper(adj);
    }
}
