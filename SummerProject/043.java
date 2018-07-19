/*class Solution {
    public String multiply(String num1, String num2) {
        long n1 = str2Int(num1);
        long n2 = str2Int(num2);
        
        return String.valueOf(n1*n2);
        
    }
    
    private long str2Int(String num){// note that the integer represented by "num" is non-negative
        int len = num.length();
        long sum = 0;
        
        for(int i=0;i<len;i++){
            sum = sum*10 + (num.charAt(i) - '0');
        }
        
        return sum;
    }
    
}*/
class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;//进位
        int[] result = new int[len1+len2];
        String str = new String();
        
        for(int i1=len1-1;i1>-1;i1--){
            for(int i2=len2-1;i2>-1;i2--){
                int tmp = (num1.charAt(i1)-'0')*(num2.charAt(i2)-'0');
                myCarry(result, i1+i2+1, tmp);
                //carry = tmp+result[i1+i2+1]
                //result[i1+i2+1] = (tmp+result[i1+i2+1])%10;
                //result[i1+i2] += carry;
            }
        }
        
        int i=0;
        while(i < len1+len2 && result[i]==0){
            i++;
        }
        if(i==len1+len2){
            return "0";
        }
        for(;i<len1+len2;i++){
            str = str.concat(String.valueOf(result[i]));
        }
        
        return str;
    }
    
    private void myCarry(int[] result, int k, int x){
        int i=k;
        while(i>-1){
            int tmp = result[i] + x;
            if(tmp > 9){
                result[i] = tmp%10;
                x = tmp / 10;
                i--;
            }
            else{
                result[i] = tmp;
                break;
            }
        }
    }

}
