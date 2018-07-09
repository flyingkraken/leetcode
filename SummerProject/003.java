class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] maxLen = new int[s.length()];//maxLen[i] means the maximum length of the sub-sequence that ends at the index of i.
        int max=1;
        maxLen[0] = 1;
        for(int i=1;i<s.length();i++){
            int dupIdx=s.indexOf(s.charAt(i),i-maxLen[i-1]);
            if(dupIdx<i){//duplicate exists in the string ranging from s[i-maxLen[i-1]] to s[i-1]
                maxLen[i] = i - dupIdx;
            }
            else{
                maxLen[i] = maxLen[i-1]+1;
                max = Math.max(max,maxLen[i]);
            }
            
        }
        
        return max;
    }
}
