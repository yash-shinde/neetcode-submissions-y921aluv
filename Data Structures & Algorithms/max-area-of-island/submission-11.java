class Solution {
    private static final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        //similar to count no of islands
        //instead for each cell we ask what is the sie of island to the 
        //4 directions and then return that
       int ROWS = grid.length;
       int COLS = grid[0].length;
       int maxSize = 0;

       for(int r = 0 ;r < ROWS;r++){
        for(int c = 0 ; c < COLS ; c++){
            if(grid[r][c]==1){
              maxSize = Math.max(maxSize,dfs(grid,r,c)); 
            }
        }
       }
       return maxSize;
    }

    public int dfs(int[][] grid,int r,int c){
        //calculate the total size here and return it
        if(r <0 || c<0 || r>= grid.length || c>= grid[0].length || 
        grid[r][c] == 0)
            return 0;
        
        int res = 1;
        //mark visited as 0
        grid[r][c] = 0;
        
        for(int[] dir : directions){
            res += dfs(grid,r+dir[0],c+dir[1]);
        }
        return res;
    }
}
