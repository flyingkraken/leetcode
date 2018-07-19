class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        for(int i=0;i<gas.length;i++){
            remain += gas[i] -cost[i];
        }
        
        if(remain < 0){
            return -1;
        }
        if(gas.length == 1){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int idx = -1;
        int[] x = new int[gas.length];
        for(int i=0;i<gas.length;i++){
            if(i==0){
                x[i] = gas[i] - cost[i];
            }
            else{
                x[i] = x[i-1] + gas[i] - cost[i];
            }
            
            if(x[i]<min){
                min = x[i];
                idx = i;
            }
        }
        
        return (idx+1)%gas.length;
        //直接输出最小累加值所在的index+1，因为题目中说了只有一种情况符合要求，所以累加到最后肯定是0，另一方面，我们必须保证中途不存在小于零的累加值，所以最小累加值的index就是终点，index+1自然就是起点了。
        
    }
}
