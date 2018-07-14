class Solution {
    public int islandPerimeter(int[][] grid) {
        int connect = 0;
        int area = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    area++;
                    if(i>0 && grid[i-1][j]==1){
                        connect++;
                    }
                    if(j>0 && grid[i][j-1]==1){
                        connect++;
                    }     
                }       
            }
        }
        return 4*area-2*connect;
    }
}
