class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        HashMap hash = new HashMap();
        for(int i=0;i<nums.length;i++){
            hash.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(target-nums[i]) && (int)hash.get(target - nums[i]) != i){
                return new int[]{i,(int)hash.get(target-nums[i])};
            }
        }
        
        throw new IllegalArgumentException("Illegal input!");
        */
        
        
        HashMap hash = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(target-nums[i])){
                return new int[]{(int)hash.get(target-nums[i]),i};
            }
            hash.put(nums[i],i);
        }
        
        throw new IllegalArgumentException("Illegal input!");
        
        
    }
}