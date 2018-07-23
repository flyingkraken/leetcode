/*class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int[][] lists = new int[4][A.length];
        int[][] minMax = new int[4][2];
        HashMap<Integer, Integer> hashD = new HashMap<Integer, Integer>();
        int count = 0;
        lists[0] = A;
        lists[1] = B;
        lists[2] = C;
        lists[3] = D;
        minMax = minAndMax(lists, minMax);
        for(int i=0;i<D.length;i++){
            if(hashD.containsKey(D[i])){
                int num = hashD.get(D[i]);
                hashD.put(D[i], num+1);
            }
            else{
                hashD.put(D[i],1);
            }
        }
        
        count = helper(lists, minMax, hashD, 0, 0, 0);
        
        return count;
        
        
    }
    
    private int[][] minAndMax(int[][] lists, int[][] minMax){
        for(int i=0;i<4;i++){
            minMax[i][0] = Integer.MAX_VALUE;
            minMax[i][1] = Integer.MIN_VALUE;
            for(int j=0;j<lists[0].length;j++){
                minMax[i][0] = Math.min(minMax[i][0],lists[i][j]);
                minMax[i][1] = Math.max(minMax[i][1],lists[i][j]);
            }
        }
        return minMax;
    }
    
    private int[] range(int[][] minMax, int start, int end){
        int[] rng = new int[2];
        for(int i=start;i<=end;i++){
            rng[0] += minMax[i][0];
            rng[1] += minMax[i][1];
        }
        return rng;
    }
    
    private int helper(int[][] lists, int[][] minMax, HashMap<Integer, Integer> hashD, int idx, int target, int count){
        if(idx == 3){//assume all the elements in each list are different
            if(hashD.containsKey(target)){
                count += hashD.get(target);
            }
        }
        if(idx<3){
            int[] rng = new int[2];
            rng = range(minMax, idx+1, 3);
            for(int i=0;i<lists[0].length;i++){
                int newTarget = target - lists[idx][i];
                if(rng[0]<=newTarget && newTarget<=rng[1]){
                       count = helper(lists, minMax, hashD, idx+1, newTarget, count); 
                }
            }
        }
        
        return count;
    }
}*/
//O(N^3), too slow

public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int count = 0;
        Integer one = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                int sm = A[i]+B[j];
                Integer v = map.get(sm);
                if(v == null) {
                    map.put(sm, one);
                } else {
                    map.put(sm, v.intValue() + 1);
                }
            }
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                int v = -(C[i]+D[j]);
                if(map.containsKey(v)) {
                    count += map.get(v).intValue();
                }
            }
        
        return count;
    }
