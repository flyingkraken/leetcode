class Solution {
    public int climbStairs(int n) {
        int count=0;
        for(int i=0;i<=n/2;i++){
            count += combination(i,n-i);
        }
        return count;
        //return combination(7,28);
    }
    
    /*
    private int combination(int m, int n){
        if(m == n || m*n == 0){
            return 1;
        }
        long res=1;
        for(int i=n;i>=n-m+1;i--){
            res *= i; 
        }
        for(int i=m;i>=1;i--){
            res /= i;
        }
        return (int)res;
    }
    */
    //以上求组合数的方法，在n>20时会发生溢出
    
    private int combination(int m, int n){
        if(m == n || m*n == 0){
            return 1;
        }
        
        long res = 1;
        for(int i=1;i<=m;i++){
            res *= n-m+i;
            res /= i;
        }
        return (int)res;
    }
}
