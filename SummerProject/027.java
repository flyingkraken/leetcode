class Solution {
    public int removeElement(int[] nums, int val) {
        /*
        //这个不能算是in-place的算法，因为本质上还是发生了交换操作
        int p=nums.length-1;
        for(int i=0;i<p+1;i++){
            if(nums[i]==val){
                for(;p>-1 && nums[p]==val;p--){}
                if(p>=i){
                    nums[p]=nums[p]^nums[i];
                    nums[i]=nums[p]^nums[i];
                    nums[p]=nums[p]^nums[i];
                    p--;
                }
                else{
                    return p+1;
                }
            }
        }
        return p+1;
        */
        
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[idx++]=nums[i];
            }
        }
        return idx;
        
    }
}
