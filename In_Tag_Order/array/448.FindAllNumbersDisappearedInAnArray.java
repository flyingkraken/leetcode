class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList(); 
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                dfs(nums, i);
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
    
    public void dfs(int[] nums, int p){
        int pp = Math.abs(nums[p])-1;
        if(nums[pp] < 0){
            return;
        }
        nums[pp] = -nums[pp];
        dfs(nums, pp);
    }
}