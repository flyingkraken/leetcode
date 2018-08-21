class Solution {
    public String countAndSay(int n) {
        String res = "1";
        
        if(n==1)
            return res;
        
        for(int i=2;i<=n;i++)
            res = say(res);
        
        return res;
    }
    
    private String say(String str){
        int i=0;
        //String res = new String();
        StringBuilder res = new StringBuilder();
        while(i<str.length()){
            char count = '1';
            char digit = str.charAt(i);
            while(++i<str.length() && str.charAt(i)==digit){
                count++;
            }
            res.append(count).append(digit);

        }
        return res.toString();
    }
}
