class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] += 2*dp[i-1];//仅有左枝情形 + 仅有右枝情形，所以要乘以2
            if(i>2){
                for(int j=2;j<i;j++){
                    dp[i] += dp[j-1]*dp[i-j];//既有左枝，又有右枝。j为根节点
                }
            }
        }
        return dp[n];
    }
}
