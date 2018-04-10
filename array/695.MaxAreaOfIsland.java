class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[] count = new int[1250];
        int[][] connect = new int[1250][2];
        int group=0;//group number
        int cnt=0;//connect number
        int[][] newgrid = new int[grid.length + 1][grid[0].length + 1];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                newgrid[i+1][j+1] = grid[i][j];
            }
        }
        
        for(int i=1;i<grid.length+1;i++){
            for(int j=1;j<grid[0].length+1;j++){
                if(newgrid[i][j]==1){
                    int up = newgrid[i-1][j];
                    int left = newgrid[i][j-1];
                    if(up==0 && left==0){
                        count[group++]++;
                        newgrid[i][j] = group;
                    }
                    else if(up!=0 && left!=0 && up != left){
                        //count[left-1] += (1+count[up-1]);
                        //count[up-1] = 0;
                        count[left - 1] ++;
                        connect[cnt++][0] = up;
                        connect[up - 1][1] = left;
                        newgrid[i][j] = left;
                    }
                    else{
                        int k = up<left?left:up;
                        count[k-1]++;
                        newgrid[i][j] = k;
                    }
                }
            }
        }
        
        int max=0;
        for(int i=0;i<group;i++){
            if(connect[i][0]!=0){
                count[connect[connect[i][0] - 1][1] - 1] += count[connect[i][0] - 1];
            }
        }
        
        for(int i=0;i<group;i++){
            max = count[i]>max?count[i]:max;
        }
        return max;
    }
}