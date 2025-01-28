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
    public void inOrder(TreeNode root, List<Integer> ans){
        if(root == null) return;

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> answer = new ArrayList<>();
        inOrder(root, answer);
        int i = 0, j = answer.size() - 1;
        while(i < j) {
            int sum = answer.get(i) + answer.get(j);
            if(sum == k) return true;
            else if(sum < k) i++;
            else j--;
        }

        return false;
    }
}
