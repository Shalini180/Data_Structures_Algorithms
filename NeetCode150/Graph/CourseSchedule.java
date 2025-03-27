import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            int to = pre[0], from = pre[1];
            adj[from].add(to);
            inDegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neighbor : adj[curr]) {
                if (--inDegree[neighbor] == 0) q.add(neighbor);
            }
        }

        return count == numCourses;
    }
}
