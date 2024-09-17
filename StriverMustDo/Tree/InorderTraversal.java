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
    List<Integer> answer;
    public Solution(){
        this.answer = new ArrayList<>();
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        answer.add(root.val);
        helper(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return answer;
    }
}
