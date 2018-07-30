class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int p = 0;
        int max = 0;
        for(int i:houses){
            if(p<heaters.length){
                int left=Integer.MAX_VALUE,right=left;
                if(i<heaters[p]){
                    right = heaters[p]-i;
                    if(p>0){
                        left = i-heaters[p-1];//此时，heaters[p-1]必定小于i                        
                    }
                }
                else{//i>=heaters[p]
                    if(p==heaters.length-1){
                        right = i - heaters[p];
                    }
                    else{
                        while(p<heaters.length-1 && heaters[p]<i){
                            p++;
                        }
                        right = heaters[p]-i;
                        if(p>0){
                            left = i-heaters[p-1];//此时，heaters[p-1]必定小于i                        
                        }        
                    }
                }
                
                max = Math.max(max, Math.min(left,right));
            }
        }
        
        return max;
    }
}
