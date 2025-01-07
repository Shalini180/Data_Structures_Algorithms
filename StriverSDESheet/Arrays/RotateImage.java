class Solution {
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
    }
    public void reverse(int[] a){
        int n = a.length;
        for(int i = 0; i < n/2;i++){
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int[] a : matrix) reverse(a);
    }
}
