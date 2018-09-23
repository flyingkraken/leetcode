class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums.length<3){
            return res;
        }
        
        for(int i=0;i<nums.length;i++){

            int i0 = i;
            int k = i+1;
            while(k<nums.length && nums[k]==nums[i]/* && nums[i]!=0*/){
                i = k++;
            }
            
            if(k-i0>2 && nums[i]==0){// at least 3 duplicate zero appear, consider the case of [0, 0, 0]
                List<Integer> temp0 = new ArrayList<>();
                temp0.add(0);
                temp0.add(0);
                temp0.add(0);
                res.add(temp0);
            }
            
            if(k-i0>1){//at least 2 duplicates appear, consider the case of [x, x, y]
                for(int ii=i+1;ii<nums.length;ii++){
                    if(nums[ii]==-nums[k-1]*2){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[k-1]);
                        temp.add(nums[k-1]);
                        temp.add(nums[ii]);
                        res.add(temp);
                        break;
                    }
                }
            }
            
            if(i>=nums.length){
              return res;
          }

          twoSum(i+1, nums.length-1, -nums[i], res, nums);
      }
      return res;
    }

    private void twoSum(int l, int r, int target, List<List<Integer>> res, int[] nums){
        while(l<r){
            if(nums[l]+nums[r]<target){
                l++;
            }else if(nums[l]+nums[r]>target){
                r--;
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(nums[l]);
                temp.add(nums[r]);
                res.add(temp);

            	//remove duplicates and start a new "temp" list from left to right
                int m = l;
                while(m<r && nums[m]==nums[l]){
                   m++;
                }
                l = m;
            }
        }
    }
}
