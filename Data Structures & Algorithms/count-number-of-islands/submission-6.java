class Solution {
    private static final int[][] directions = 
    {{1, 0}, {-1, 0},{0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        //basic logic - we mark all the visited cells as water and 
        //go ahead.in order to not count the same cells again
        //for all '1' cells , we perform dfs and set its value as 0(water)
        //then we check al adjacent 8 cells - whichever are valid
        //if any is 0 we return 
        //if 1 we dfs again
        int islands = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || 
        grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        for(int[] dir : directions){
            dfs(grid,r+dir[0],c+dir[1]);
        }
    }
}
