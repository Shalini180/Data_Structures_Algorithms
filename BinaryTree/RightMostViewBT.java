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
    public void helper(TreeNode root, List<Integer> ans, int depth){
        if(root == null) return;
        if(depth == ans.size())
            ans.add(root.val);

        helper(root.right, ans, depth + 1);
        helper(root.left, ans, depth + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        helper(root, answer, 0);
        return answer;
    }
}
