class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, count = 0, total = nums1.length + nums2.length;
        int mid = total % 2 == 0 ? total / 2 - 1 : total / 2;
        boolean even = total % 2 == 0;
        boolean apply = false;
        int sum = 0;
        while (i < nums1.length || j < nums2.length) {
            
            if (i >= nums1.length) {
                
                if (count >= mid) {
                    sum += nums2[j];
                    if (!even) break;
                    if (even && apply) break;
                    if (even) apply = true;
                }
                
                j++;
                count++;
                continue;
            }
            
            if (j >= nums2.length) {
                
                if (count >= mid) {
                    sum += nums1[i];
                    if (!even) break;
                    if (even && apply) break;
                    if (even) apply = true;
                }
                
                i++;
                count++;
                continue;
            }
            
            if (nums1[i] < nums2[j]) {
                if (count >= mid) {
                    sum += nums1[i];
                    if (!even) break;
                    if (even && apply) break;
                    if (even) apply = true;
                }
                i++;
            } else {
                if (count >= mid) {
                    sum += nums2[j];
                    if (!even) break;
                    if (even && apply) break;
                    if (even) apply = true;
                }
                j++;
            }
            count ++;
        }
        
        return even ? (double) sum / 2 : sum;
    }
}
