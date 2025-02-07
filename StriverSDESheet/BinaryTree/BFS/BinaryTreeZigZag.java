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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;

        while(!q.isEmpty()){
            int n = q.size();
            Deque<Integer> temp = new LinkedList<>();
            for(int i = 0;i < n;i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(reverse == true) temp.addFirst(curr.val);
                else temp.add(curr.val);
            }

            ans.add(new ArrayList<>(temp));
            reverse = !reverse;
        }

        return ans;
    }
}
