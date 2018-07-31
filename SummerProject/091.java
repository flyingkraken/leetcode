class Solution {
    public int numDecodings(String s) {
        if(s.length()==1){
            return s.charAt(0)=='0'?0:1;// 注意：'0' 不能代表任何字母，下同。
        }
        char[] ss = s.toCharArray();
        int[] dp = new int[ss.length];// 动态规划。实际一开始考虑问题时，是想用递归的DFS，但是后来发现很多计算是重复的，于是改进为动态规划了。
        
        dp[ss.length-1]=ss[ss.length-1]=='0'?0:1;
        for(int i=ss.length-2;i>=0;i--){// 倒叙求数组dp[]，dp[0]即为返回值
            int tmp = (int)(ss[i]-'0');
            if(tmp!=0){
                dp[i] += dp[i+1];
            }
                
            tmp = (int)((ss[i]-'0')*10)+(int)(ss[i+1]-'0');
            if(tmp>9 && tmp<27){
                if(i+2<ss.length){
                    dp[i] += dp[i+2];
                }else{
                    dp[i] += 1;
                }
            }
        }
        
        return dp[0];
    }
}
