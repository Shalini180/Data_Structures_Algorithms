/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;
            if(mp.containsKey(col) == false) mp.put(col, new TreeMap<>());
            if(mp.get(col).containsKey(row) == false) mp.get(col).put(row, new PriorityQueue<>());
            mp.get(col).get(row).add(node.val);

            if(node.left != null) q.add(new Tuple(node.left, row + 1, col - 1));
            if(node.right != null) q.add(new Tuple(node.right, row + 1, col + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : mp.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> it : ys.values()){
                while(it.size() > 0)
                ans.get(ans.size() - 1).add(it.poll());
            }
        }

        return ans;
    }
}
