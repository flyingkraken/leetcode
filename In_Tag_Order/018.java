class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            //if(nums[i]>target) break; //this is wrong if target<0
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;
            if(nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target) continue;
            
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j-1]==nums[j]) continue;
                //if(nums[i]+nums[j]>target) break; // this is wrong if target<0
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if(nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1]<target) continue;
            
                int l = j+1;
                int r = nums.length-1;
                while(l<r){
                    if(nums[l]+nums[r]<target-nums[i]-nums[j]) l++;
                    else if(nums[l]+nums[r]>target-nums[i]-nums[j]) r--;
                    else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        res.add(temp);
                        l++;
                        r--;
                        while(l<r && nums[l-1]==nums[l]) l++;
                        while(l<r && nums[r+1]==nums[r]) r--;
                    }
                }
            }
        }
        return res; 
    }
}