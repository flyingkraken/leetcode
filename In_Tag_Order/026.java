/*
** Use two pointers "slow" and "fast"
*/
class Solution{
	public int removeDuplicates(int[] nums){
		int slow=0;
		int fast=0;
		for(int i=0;i<nums.length;i++){
			if(i>0 && nums[i-1]==nums[i]){
				fast++;
				continue;
			}
			nums[slow++] = nums[fast++];
		}
		return slow;
	}
}

//this version looks more concise
class Solution{
	public int removeDuplicates(int[] nums){
		int slow=0;
		for(int fast=1;fast<nums.length;fast++){
			if(nums[fast]!=nums[slow]){
				nums[++slow] = nums[fast];
			}
		}
		return slow+1;
	}
}