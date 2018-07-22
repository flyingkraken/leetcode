class Solution {
    public int singleNumber(int[] nums) {
        HashSet hash = new HashSet();
        for(int i=0;i<nums.length;i++){
            if(hash.contains(nums[i])==true){
                nums[i] *= -1;
            }
            else{
                hash.add(nums[i]);
            }
        }
        
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }
}
