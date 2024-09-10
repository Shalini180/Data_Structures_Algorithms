class Solution {
    int row0;
    Solution(){
        row0 = 1;
    }
    public void markRow(int[][] matrix, int index){
        //i = 0, j = 1 to m
        if(index == 0) {
            row0 = 0;
        }
        else{
            matrix[0][index] = 0;
        }
    }
    public void markCol(int[][] matrix, int index){
        matrix[index][0] = 0;
    }
    public boolean isPresentRow(int[][] matrix, int index){
        if(index == 0) return row0 == 0;
        return matrix[0][index] == 0;
    }
    public boolean isPresentCol(int[][] matrix, int index){
        return matrix[index][0] == 0;
    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i < n; i++){
            for(int j = 0;j < m;j++){
                if(matrix[i][j] == 0){
                    markRow(matrix, j);
                    markCol(matrix, i);
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1;j<m;j++){
                if(isPresentRow(matrix, j) || isPresentCol(matrix, i)) matrix[i][j] = 0;
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0; j < m; j++) matrix[0][j] = 0;
        }

        if(row0 == 0){
            for(int i = 0; i < n; i++) matrix[i][0] = 0;
        }
    }
}
