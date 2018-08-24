class Solution {
    public String addStrings(String num1, String num2) {
        /*
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int i1 = n1.length - 1;
        int i2 = n2.length - 1;
        int resLen = Math.max(i1,i2)+2;
        int i=resLen - 1;
        char[] res = new char[resLen];
        int carry = 0;
        
        while(i1>=0 && i2>=0){
            int sum = n1[i1--]-'0' + n2[i2--]-'0' + carry; 
            res[i--] = (char)(sum%10 + (int)'0');
            carry = sum/10;
        }
        
        while(i1>=0){
            int sum = n1[i1--]-'0' + carry;
            res[i--] = (char)(sum%10 + (int)'0');
            carry = sum/10;
        }
        while(i2>=0){
            int sum = n2[i2--]-'0' + carry;
            res[i--] = (char)(sum%10 + (int)'0');
            carry = sum/10;
        }
        if(carry>0){
            res[i] = (char)(carry + (int)'0');
            return String.valueOf(res);
        }
        
        return String.valueOf(res, 1, resLen-1);
        */
        //以上是自己写的，beats 50%
        
        //利用StringBuilder类的reverse方法，可以避免一开始的逆向相加
        StringBuilder res = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0) sum += num1.charAt(i--) - '0';
            if(j>=0) sum += num2.charAt(j--) - '0';
            res.append(sum%10);
            carry = sum/10;
        }
        
        if(carry>0){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
