class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        int[] sumTo = new int[len+1];
        for(int i=1;i<=len;i++){
            sumTo[i] = 0;
            for(int j=0;j<i;j++){
                sumTo[i] += nums[j]; 
            }
        }
        
        for(int i=0;i<=len;i++){
            for(int j=i+1;j<=len;j++){
                if(sumTo[j]-sumTo[i] == k){
                    count++;
                }
            }
        }
        
        return count;
    }
}
//This is not a final version and can be optimized by hashtable.
