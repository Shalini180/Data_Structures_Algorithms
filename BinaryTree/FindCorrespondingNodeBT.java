/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode helper(TreeNode original, TreeNode cloned, TreeNode target) {
        // Base case: If original node is null, return null
        if (original == null) {
            return null;
        }

        // If the original node is the target, return the cloned node
        if (original == target) {
            return cloned;
        }

        // Recursively search the left subtree
        TreeNode result = helper(original.left, cloned.left, target);
        if (result != null) {
            return result;
        }

        // If not found in the left subtree, search the right subtree
        return helper(original.right, cloned.right, target);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(original, cloned, target);
    }
}
