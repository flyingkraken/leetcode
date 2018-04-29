class Solution {
    //可以证明一种序列只能有唯一的分割方法，我们假设末位可以由2-bit组成，若假设成立则False，若假设不成立则True
    //然并卵，这种办法需要反向遍历数组，太复杂，根据这个思路我只能想到回溯法，太笨
    public boolean isOneBitCharacter(int[] bits) {  
        //以下是Discussion中排名前两位的方法
        
        //Solution_1: 从倒数第二位开始数连续的1的个数，若为奇数，则有一个1无0配对，返回Flase；若为偶数，则返回True
        
        int i, len=bits.length;
        for(i=len-2;i>=0 && bits[i]==1;i--){;}
        return (len-2-i)%2 == 0;
        
        
        //Solution_2: 从第一个位置开始，逢1移两位，逢0移一位，看最后是否正好到达最后一位，若是，则True，否则Flase
        /*
        int i=0, len=bits.length;
        for(;i<len-1;){
            if(bits[i] == 0) i++;
            else i+=2;
        }
        return i == len - 1;
        */
    }
}