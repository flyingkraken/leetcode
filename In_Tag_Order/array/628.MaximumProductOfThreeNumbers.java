class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length==3){
            return nums[0]*nums[1]*nums[2];
        }
        
        int[] max = new int[]{-1000,-1000,-1000};
        int[] min = new int[]{1000,1000,1000};
        for(int i:nums){
            if(i>max[0]){
                max[2]=max[1];
                max[1]=max[0];
                max[0]=i;
            }
            else if(i>max[1]){
                max[2]=max[1];
                max[1]=i;
            }
            else if(i>max[2]){
                max[2]=i;
            }
                
            if(i<min[0]){
                min[2]=min[1];
                min[1]=min[0];
                min[0]=i;
            }
            else if(i<min[1]){
                min[2]=min[1];
                min[1]=i;
            }
            else if(i<min[2]){
                min[2]=i;
            }
        }
        
        int maxP1=max[0]*max[1]*max[2];
        int maxP2=max[0]*min[0]*min[1];
        
        return maxP1<maxP2?maxP2:maxP1;
        
    }
}