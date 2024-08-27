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
    public TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie){
        if(ps > pe || is > ie) return null;
        int rootElement = preorder[ps];
        TreeNode root = new TreeNode(rootElement);

        int i = is;
        int nodeLeft = 0;
        while(inorder[i] != rootElement){
            i++;
            nodeLeft++;
        }
        
        root.left = helper(preorder, inorder, ps + 1, ps + nodeLeft, is, i-1);
        root.right = helper(preorder, inorder, ps+nodeLeft+1, pe, i+1, ie);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length - 1;
        return helper(preorder, inorder, 0, n, 0, n);
    }
}
