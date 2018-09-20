//My solution, beats 40%
class Solution {
    public String intToRoman(int num) {
        String[][] pool = {{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},{"M", "MM", "MMM", "", "", "", "", "", ""}};
        int[] numArray = readInt(num);
        int len = 4;
        String res = new String();
        for(int i=0;i<len;i++){
            if(numArray[i]>0){
                res += pool[len-1-i][numArray[i]-1];
            }
        }
        return res;
    }
    
    /**
     *read an int number and convert it to int[]
     **/
    private int[] readInt(int num){
        int[] resNum = new int[4];
        int i = 3;
        while(num>0){
            resNum[i--] = num%10;
            num /= 10;
        }
        return resNum;
    }
}

//Better solution
class Solution {
    
    private final static String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
    private final static String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    
    private final static String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    
    private final static String[] M = {"", "M", "MM", "MMM"};
    
    public String intToRoman(int num) {
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
