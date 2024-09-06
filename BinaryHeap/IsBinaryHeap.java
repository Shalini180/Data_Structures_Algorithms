class Solution {
    boolean isCBT(Node tree, int i, int n){
        if(tree == null) return true;
        if(i >= n) return false;
        return isCBT(tree.left, 2*i + 1, n) && isCBT(tree.right, 2*i + 2, n);
    }
    int count(Node tree){
        if(tree == null) return 0;
        
        return 1 + count(tree.left) + count(tree.right);
    }
    boolean isHeapHelper(Node tree){
        if(tree == null) return true;
        if(tree.left == null && tree.right == null) return true;
        if(tree.right == null){
            return tree.data > tree.left.data;
        }
        
        return tree.data > tree.left.data && tree.data > tree.right.data && isHeap(tree.left) && isHeap(tree.right);
    }
    boolean isHeap(Node tree) {
        int count = count(tree);
        if(isCBT(tree, 0, count) == false) return false;
        return isHeapHelper(tree);
    }
}
