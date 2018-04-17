class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[] x = new int[]{-1,-1,-1,0,1,1,1,0};
        int[] y = new int[]{-1,0,1,1,1,0,-1,-1};
        
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                int sum = M[i][j];
                int total=9;
                for(int k=0;k<x.length;k++){
                    if(i+x[k]<0 || i+x[k]>M.length-1 || j+y[k]<0 || j+y[k]>M[0].length-1){
                        total--;
                    }
                    else{
                        sum += (M[i+x[k]][j+y[k]] & 0xFF);
                    }
                }
                M[i][j] |= (sum/total)<<8;
            }
        }
        
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                M[i][j] >>= 8;    
            }
        }
        return M;
    }
}