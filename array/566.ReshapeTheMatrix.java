class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums[0].length*nums.length){
            return nums;
        }
        
        int[][] mtx = new int [r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                mtx[i][j] = nums[(i*c + j)/nums[0].length][(i*c + j)%nums[0].length];
            }
        }
        
        return mtx;
    }
}
