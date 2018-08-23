class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*for(int i=0;i<n;i++){
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1, 0, m+n);
        */
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        if(i<0){//in this case, m==0, elements in nums2[] have not been put into nums1[]
            for(;j>=0;j--){
                nums1[j] = nums2[j];
            }
        }
        
    }
}
