class Solution {
    public int removeElement(int[] nums, int val) {
        int slow=0;
        int fast=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                fast++;
                continue;
            }
            
            nums[slow++] = nums[fast++];
        }
        return slow;
    }
}