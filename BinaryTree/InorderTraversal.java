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
    public void inorderHelper(TreeNode root, List<Integer> ans){
        if(root == null) return;
        inorderHelper(root.left, ans);
        ans.add(root.val);
        inorderHelper(root.right, ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorderHelper(root, answer);
        return answer; 
    }
}
