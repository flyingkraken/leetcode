class Solution {
    public int trap(int[] height) {
        int i=0,water=0;
        int len = height.length;
        while(i<len-1){
            boolean higher=false;
            int block = 0;
            int maxHeight = -1;
            int maxIndex = i;
            int maxBlock = 0;
            
            for(int j=i;j<height.length;j++){
                block += height[j];
                if(j!=i && height[j]>maxHeight){
                    maxHeight = height[j];
                    maxIndex = j;
                    maxBlock = block;
                }
                
                if(height[j]>height[i]){
                    if(height[i]!=0){
                        water += height[i]*(j-i-1)-block+height[i]+height[j];
                    }
                    higher = true;
                    i = j;
                    break;
                }
            }
            
            if(higher == false){
                if(maxHeight!=0){
                    water += maxHeight*(maxIndex-i-1)-maxBlock+height[i]+height[maxIndex];
                }
                i = maxIndex;
            }

        }
        return water;
    }
}