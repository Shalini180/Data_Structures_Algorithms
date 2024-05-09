class SubrectangleQueries {
    int[] rec;
    int row;
    int col;
    
    public SubrectangleQueries(int[][] rectangle) {
        row = rectangle.length;
        col = rectangle[0].length;
        rec = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = i*col + j;
                rec[index] = rectangle[i][j];
            }
        }
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                int index = i*col +  j;
                rec[index] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rec[row*this.col +  col];
    }
}
