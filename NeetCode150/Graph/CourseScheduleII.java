import java.util.*;

class Solution {
    public List<List<Integer>> formAdjList(int n, int[][] pre) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < pre.length; i++) {
            adjList.get(pre[i][1]).add(pre[i][0]);
        }
        return adjList;
    }

    boolean dfs(int node, boolean[] vis, List<List<Integer>> adjList, Stack<Integer> st, boolean[] inMem) {
        vis[node] = true;
        inMem[node] = true;
        for (int nei : adjList.get(node)) {
            if (!vis[nei]) {
                if (dfs(nei, vis, adjList, st, inMem)) return true;
            } else if (inMem[nei]) return true;
        }
        st.push(node);
        inMem[node] = false;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = formAdjList(numCourses, prerequisites);
        boolean[] vis = new boolean[numCourses];
        boolean[] inMem = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, adjList, st, inMem)) {
                    return new int[0];
                }
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        while (!st.isEmpty()) {
            order[index++] = st.pop();
        }

        return order;
    }
}
