/*
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==1){
            return;
        }
        int maxIdx=-1; // the max index 'i' of nums[] such that nums[i]<nums[i+1]
        int tmp=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                maxIdx = i;
            }
        }
        
        if(maxIdx>=0){
            tmp = nums[maxIdx];
            nums[maxIdx] = nums[maxIdx+1];
            nums[maxIdx+1] = tmp;
        }
    }
}
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int i;
        for(i=len-1;i>=1;i--){
            if(nums[i-1]<nums[i])
                break;
        }
        i=i-1;
        if(i==-1)
            {//Arrays.reverse(nums);
            for(int j=0;j<=(len-1)/2;j++){
                int temp=nums[j];
                nums[j]=nums[len-1-j];
                nums[len-1-j]=temp;
            }
            return;}
        int index=0,min=Integer.MAX_VALUE;
        for(int j=i+1;j<len;j++){
            if(nums[j]>nums[i] && nums[j]<min)
                {min=Math.min(min,nums[j]);
                index=j;}
        }
        int temp=nums[i];
        nums[i]=nums[index];
        nums[index]=temp;
        Arrays.sort(nums,i+1,len);
    }
}
