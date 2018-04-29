class Solution {
    public int majorityElement(int[] nums) {
        //My Solution T=O(NlogN)
        /*
        Arrays.sort(nums);
        return nums[nums.length/2];
        */
    
        //Solution in Discussion T=O(N) S=O(1)
        int maj=nums[0],count=0;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                maj = nums[i];
                count ++;
            }
            else if(maj == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return maj;
    }
}