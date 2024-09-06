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
    public boolean isCompleteTreeHelper(TreeNode root, int i, int n){
        if(root == null) return true;
        if(i >= n) return false;
        return isCompleteTreeHelper(root.left, 2 * i + 1, n) && isCompleteTreeHelper(root.right, 2*i + 2, n);
    }
    public void countNode(TreeNode root, int[] ans){
        if(root == null) return;
        ans[0] += 1;
        countNode(root.left, ans);
        countNode(root.right, ans);
    }
    public boolean isCompleteTree(TreeNode root) {
        int[] count = new int[1];
        count[0] = 0;
        countNode(root, count);
        return isCompleteTreeHelper(root, 0, count[0]);
    }
}
