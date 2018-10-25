class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int pos=-1;
        for(int i=len-1;i>=1;i--){//find the left boundary of the area that needs to be rearranged in nums
            if(nums[i-1]<nums[i]){
                pos=i-1;
                break;
            }
        }
        if(pos!=-1){//found the boundary
            int j=nums.length-1;
            while(nums[j]<=nums[pos]){j--;}
            swap(nums, pos, j);
            reverse(nums, pos+1, nums.length-1);
        }else{//boundary not found == rearrangement is not possible. We sort nums in ascending order
            reverse(nums, 0, nums.length-1);
        }
    }
    
    private void swap(int[] nums, int l, int r){
        int temp=-1;
        temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        
    }
    private void reverse(int[] nums, int start, int end){
        if(end-start<1) return;
        while(start<end){
            swap(nums, start++, end--);
        }
    }
}