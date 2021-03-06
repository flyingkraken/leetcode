class Solution {
    public int missingNumber(int[] nums) {
        
        //O(NlogN)
        /*
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
        */
        
        //O(N)
        int len=nums.length;
        int sum = len*(len+1)/2;
        int realsum=0;
        for(int i:nums){
            realsum += i;
        }
        return sum-realsum;
        
    }
}
