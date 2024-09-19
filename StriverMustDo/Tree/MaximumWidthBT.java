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
class Pair {
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int width = 1;
            int min = 0;
            for(int i = 0;i < size;i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int index = curr.index;
                if(i == 0){
                    min = index;
                    width -= index;
                }
                if(i == size - 1) width += index;

                if(node.left != null) q.add(new Pair(node.left, 2*index + 1 - min));
                if(node.right != null) q.add(new Pair(node.right, 2*index + 2 - min));
            }

            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}
