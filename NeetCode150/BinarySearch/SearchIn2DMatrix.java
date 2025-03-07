class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;
        while(row < n && col >= 0){
            if(target == matrix[row][col]) return true;
            if(target > matrix[row][col]) row++;
            else col--;
        }

        return false;
    }
}
