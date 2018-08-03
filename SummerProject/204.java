class Solution {
    public int countPrimes(int n) {
        if(n==1 || n==0){
            return 0;
        }
        boolean[] prime = new boolean[n];
        int count = 0;
        /*
        for(int i=2;i<n;i++){
            prime[i] = 1;
        }
        
        for(int i=2;i<=n/2;i++){
            if(prime[i]==1){
                for(int j=2*i;j<n;j+=i){
                    prime[j] = 0;
                }
            }
        }*/
        for(int i=2;i<=Math.sqrt(n);i++){
            if(!prime[i]){
                for(int j=i*i;j<n;j+=i){
                    prime[j] = true;
                }
            }
        }
        
        
        for(int i=2;i<n;i++){
            if(!prime[i]){
                count++;
            }
        }
        
        return count;
    }
}
