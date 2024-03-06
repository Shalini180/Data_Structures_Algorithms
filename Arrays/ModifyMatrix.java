class Solution {
    public int[][] modifiedMatrix(int[][] originalMatrix) {
        int rows = originalMatrix.length;
        int cols = originalMatrix[0].length;
        
        for (int col = 0; col < cols; col++) {
            ArrayList<Integer> missingIndices = new ArrayList<>();
            int maxNonNegative = -2;
            for (int row = 0; row < rows; row++) {
                if (originalMatrix[row][col] != -1)
                    maxNonNegative = Math.max(maxNonNegative, originalMatrix[row][col]);
                else
                    missingIndices.add(row);
            }
            for (int index : missingIndices) {
                originalMatrix[index][col] = maxNonNegative;
            }
        }

        return originalMatrix;
    }
}
