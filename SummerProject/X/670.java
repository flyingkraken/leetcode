class Solution {
    public int maximumSwap(int num) {
        char max = '0';               
        int max_position=frist_greater;    
        for(int i=frist_greater;i<digits.length;i++){//find max digit in remain digits
            if(max<=digits[i]){
                max = digits[i];
                max_position = i;
            }
        }

        for(int i=0;i<frist_greater;i++){  //find first digit that smaller than max digit in the second part
            if(max>digits[i]){
                StringBuilder s = new StringBuilder(String.valueOf(digits));
                s.setCharAt(max_position,digits[i]);
                s.setCharAt(i,max);
                return Integer.parseInt(s.toString());  //no need to check overflow since max value is 10^8
            }
        }
        return num;
    }
}
