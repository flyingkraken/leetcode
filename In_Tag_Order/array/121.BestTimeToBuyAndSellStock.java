class Solution {
    public int maxProfit(int[] prices) {
        //我只想到了Brutal Force和基于排序后的算法 都很繁琐
        
        //Solution in Discussion
        int ProfitCur=0, ProfitSofar=0;
        for(int i=1;i<prices.length;i++){
            ProfitCur += prices[i] - prices[i-1];
            ProfitCur = Math.max(0,ProfitCur);
            ProfitSofar = Math.max(ProfitSofar, ProfitCur);
        }
        return ProfitSofar;
    }
}