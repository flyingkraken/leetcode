class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        while(i<=nums.length-1){
            if(nums[i]==target){
                return i;
            }
            
            if(nums[i]>target){
                return i;
            }
            
            i++;
        }
        
        return i;
    }
}
