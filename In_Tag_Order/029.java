class Solution {
    public int divide(int dividend, int divisor) {
    	int sign = (divident>0) ^ (divisor) ? -1: 1;

    	long dvd = Math.abs(divident);
    	long dvs = Math.abs(divisor);
    	long res = 0;

		return helper(dvd, dvs, 0);
    }

    private void helper(long dvd, long dvs, long res){
    	if(dvd<dvs) return 0;
    	while(dvd>=dvs){
    		dvs<<1;
    		res<<1;
    	}
    	return res + helper(dvd-dvs/2, dvs>>res, 0);
    }
}