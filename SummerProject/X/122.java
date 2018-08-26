class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length, profit=0;
        //return profit(prices,0,len-1);
        for(int i=1;i<len;i++){
            profit += Math.max(0,prices[i]-prices[i-1]);
        }    
        return profit;
    }
}
