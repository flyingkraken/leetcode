class Solution {
    public int arrayPairSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int max_sum = 0;
        for(int i = 0; i < nums.length/2; i++){
            max_sum += nums[2*i];
        }
        return max_sum;
    }
    
    public static int quickSort(int[] nums, int start, int end){
        if(start == end){
            return 0;
        }
        if(start == end - 1){
            if(nums[start] > nums[end]){
                switchElem(nums, start, end);
            }
            return 0;
        }
        
        int p, p1, p2;
        for(p = start, p1 = start, p2 = end;p1 < p2;p2--){
            if(nums[p2]<nums[p]){
                for(;p1 < p2;p1++){
                    if(nums[p1]>nums[p]){
                        switchElem(nums, p1, p2);
                        break;
                    }
                }
                //continue;
            }
        }
        
        switchElem(nums, p, p1);
        
        if(start <= p1 - 1){
            quickSort(nums, start, p1 - 1);
        }
        if(p1 + 1 <= end){
            quickSort(nums, p1 + 1, end);
        }
        
        return 0;
    }
    
    public static void switchElem(int[] nums, int n1, int n2){
        int tmp;
        tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
    
    /*public static void main(String[] args) {
    	int[] nums = new int[] {5,3,6,2,8,10,4,15,62,32};
    	quickSort(nums, 0, nums.length - 1);
    	for(int i=0; i <nums.length;i++) {
    		System.out.print(nums[i]+",");
    	}
    }*/
   
}