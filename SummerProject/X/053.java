class Solution {
    public int maxSubArray(int[] nums) {
        //动态规划
        
        int[] maxSub = new int[nums.length];
        int max=nums[0];
        maxSub[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            maxSub[i] = Math.max(maxSub[i-1]+nums[i],nums[i]);
            max = Math.max(max,maxSub[i]);
        }
        
        return max;
    }
}
