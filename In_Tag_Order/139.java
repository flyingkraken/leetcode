/* DFS
** Low efficiency
*/

/*class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(wordDict, s, 0, 0, false);
    }
    
    private boolean match(String str, String substr){
        if(str.length()<substr.length()) return false;
        return (str.substring(0, substr.length()).equals(substr));
    }
    
    private boolean dfs(List<String> wordDict, String s, int i, int j, boolean res){
        if(i == s.length()) return true;
        
        boolean tmp = false;
        for(;j<wordDict.size();j++){
            String temp = wordDict.get(j);
            if(match(s.substring(i), temp)){
                tmp = true;
                res = res || dfs(wordDict, s, i+temp.length(), 0, res);   
            }
        }
        if(tmp==false){
            return false;
        }else{
            return res;
        }
    }
}*/

/* DP solution
** High efficiency
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];//dp[0] = true
        int maxLen = 0;
        
        for(String word:wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        
        dp[0] = true;
        for(int i=1;i<dp.length;i++){
            myDP(s, dp, i, wordDict, maxLen);
        }
        
        return dp[dp.length-1];
    }

    private void myDP(String s, boolean[] dp, int i, List<String> wordDict, int maxLen){
        dp[i] = false;
        
        for(int j=1;j<=maxLen && j<=i;j++){
            if(dp[i-j]==true && wordDict.contains(s.substring(i-j, i))){
                dp[i] = true;
                return;
            }
        }
    }

}

