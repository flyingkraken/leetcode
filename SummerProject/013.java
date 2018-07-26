class Solution {
    public int romanToInt(String s) {
        int result =0;
        for(int i =0; i< s.length() -1; i++){
            int first = getCharValue(s.charAt(i));
            int second = getCharValue(s.charAt(i+1));
            if(first<second){
                result = result -first;
            }else{
                result = result + first;
            }
        }
        return result + getCharValue(s.charAt(s.length() -1));
    }
    
    
    public int getCharValue(char c){
        switch(c){
        case 'I':
        return 1;
        case 'V':
        return 5;
        case'X':
        return 10;
        case 'L':
        return 50;
        case 'C':
        return 100;
        case 'D':
        return 500;
        case 'M':
        return 1000;
        }
        throw new IllegalStateException();
    }
}
