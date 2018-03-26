class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int tmp=0,max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                max = max < tmp? tmp: max;
                tmp = 0;
            }
            else{
                tmp++;
            }
        }
        max = max < tmp? tmp: max;
        return max;
    }
}