class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //for each treasure chest use multi source bfs
        //we will take the distance from trsr + 1 for each adjacent cell
        //if cell is land and the cells curr dist is > calc dist 
        //we add it to queue. else we dont
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        //add all trsr chests to queue
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(q.size() == 0) return;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                //if out of bounds or already visisted
                if(r >= m || c >= n || r < 0 || c < 0 || 
                grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }

                q.add(new int[]{r,c});

                grid[r][c] = grid[row][col]+1;
            }
        }
    }
}
