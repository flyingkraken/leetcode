class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //T=O(N^2)
        /*
        int p1=0,p2=1,mid;
        int[] result = new int[2];
        for(mid=1;numbers[mid]<target/2;mid++){;}
        //while(numbers[p1]+numbers[p2]<=target){
        for(p2=mid;p2<numbers.length;p2++){
            for(p1=0;p1<p2;p1++){
                if(numbers[p1]+numbers[p2]==target){
                    result[0]=p1+1;
                    result[1]=p2+1;
                    return result;
                }
            }
        
        }
        return result;
        */
        
        //T=O(N)
        int l=0,r=numbers.length-1;
        int[] result = new int[2];
        while(l<r){
            if(numbers[l]+numbers[r]>target){
                r--;
            }
            else if(numbers[l]+numbers[r]<target){
                l++;
            }
            else{
                result[0]=l+1;
                result[1]=r+1;
                return result;
            }
        }
        return result;
        
    }
}