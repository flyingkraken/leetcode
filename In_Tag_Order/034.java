class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        res[0] = res[1] = -1;
        int l = 0;
        int r = len - 1;
        
        findTarget(nums, res, target, l, r);
        
        return res;
    }
    
    private void findTarget(int[] nums, int[] res, int target, int l, int r){
        if(l > r || nums[l] > target || nums[r] < target) return;
        
        int mid = (l + r) / 2;

        if(nums[mid] == target){
            res[0] = findIndex(nums, target, mid, true);       
            res[1] = findIndex(nums, target, mid, false);
            return;
        }
        else if(nums[mid] < target){
            findTarget(nums, res, target, mid + 1, r);
        }
        else{//nums[mid] > target
            findTarget(nums, res, target, l, mid - 1);
        }
    }
    
    private int findIndex(int[] nums, int target, int index, boolean goLeft){
        if(goLeft){
            while(index >= 0 && index < nums.length && nums[index] == target){index--;}
            return index + 1;
        }
        else{
            while(index >= 0 && index < nums.length && nums[index] == target){index++;}
            return index - 1;
        }
    }
}
