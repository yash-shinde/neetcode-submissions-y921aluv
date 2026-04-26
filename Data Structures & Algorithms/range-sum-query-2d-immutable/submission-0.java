class NumMatrix {
    private int[][] sumMat;
    public NumMatrix(int[][] matrix) {
       //create 2D presum array of size rows+1 * cols+1
       int ROWS = matrix.length;int COLS = matrix[0].length;
       sumMat = new int[ROWS+1][COLS+1];

       for(int r=0;r<ROWS;r++){
        int rowPrefix = 0;
        for(int c = 0;c<COLS;c++){
            rowPrefix += matrix[r][c];
            int colPrefix = sumMat[r][c+1];//r since we are using r+1 to store r's sums
            sumMat[r+1][c+1] = rowPrefix + colPrefix;
        }
       }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;col1++;row2++;col2++;
        int bottomRight = sumMat[row2][col2];
        int above = sumMat[row1-1][col2];
        int left = sumMat[row2][col1-1];
        int topLeft = sumMat[row1-1][col1-1];
        //topleft will add back the part that was subtracted twice
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */