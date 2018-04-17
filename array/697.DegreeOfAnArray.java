class Solution {
    public int findShortestSubArray(int[] nums) {
        //int max_nums = Arrays.stream(nums).max().getAsInt();//利用stream 求最大值这一步最费时，直接设为50000后，效率提高显著(耗时由120ms减少到20ms)
        int[] count = new int[50000];
        int[] x1 = new int[50000];
        int[] x2 = new int[50000];//若改用一个int[50000][3]的二维数组，则寻址会比较耗时
        int max=0,len=50001;
        for(int i=0;i<nums.length;i++){
            if(count[nums[i]]==0){
                x1[nums[i]] = i;
            }
            count[nums[i]] ++;
            x2[nums[i]] = i;
            
            max = Math.max(count[nums[i]],max);
            
        }

        for(int i:nums){
            if(max==count[i]){
                len = Math.min(x2[i]-x1[i]+1,len);
            }
        }
        return len;
        
    }
}

