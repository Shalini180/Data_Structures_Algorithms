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
    public TreeNode helper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return null;
        int sum = 0;
        if(root1 != null) sum += root1.val;
        if(root2 != null) sum += root2.val;
        TreeNode newRoot = new TreeNode(sum);
        TreeNode root1Left = (root1 != null) ? root1.left : null;
        TreeNode root2Left = (root2 != null) ? root2.left : null;
        TreeNode root1Right = (root1 != null) ? root1.right : null;
        TreeNode root2Right = (root2 != null) ? root2.right : null;
        newRoot.left = helper(root1Left, root2Left);
        newRoot.right = helper(root1Right, root2Right);
        
       
        return newRoot;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return helper(root1, root2);
    }
}
