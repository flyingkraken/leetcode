class Solution {
    /*
    public void moveZeroes(int[] nums) {
        int p0=0,p1=0,tmp;
        for(p0=0;p0<nums.length;p0++){
            if(nums[p0]==0){
                for(p1 = p0+1;p1<nums.length && nums[p1]==0;p1++){;}
                if(p1 < nums.length){
                    tmp = nums[p0];
                    nums[p0] = nums[p1];
                    nums[p1] = tmp;
                }
                else{
                    return;
                }
            }
        }
        return;
    }
    */
    
    //基于交换的算法，效率稍低
    public void moveZeroes(int[] nums) {
        int p0=0,num0=0,tmp;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(num0==0){
                    p0=i;
                }
                num0++;
            }
            else if(num0 > 0){
                tmp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = tmp;
                p0++;
            }
        }
    }
    
    //最快的算法：直接读取数组的非零元素，依次从头开始覆盖数组，最后在剩余位置补零
    //代码省略...
}