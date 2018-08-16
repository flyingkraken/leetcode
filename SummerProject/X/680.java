class Solution {
    /*
    public boolean validPalindrome(String s) {
        if(isPalindrome(s)==true){
            return true;
        }else{
            int[] count = new int[26];
            
            if(s.length()%2==0){
                if(removeSuspect(s.charAt(s.length()/2)-'a',s)==true||removeSuspect(s.charAt(s.length()/2-1)-'a',s)==true){
                    return true;
                }
            }
                
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)-'a']++;
            }
            for(int j=0;j<26;j++){
                if(count[j]%2==1){
                    if(removeSuspect(j, s)==true){
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
        
    private boolean removeSuspect(int suspect, String s){
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)-'a')==suspect){
                String tmp = s.substring(0,i)+s.substring(i+1,s.length());
                if(isPalindrome(tmp)==true){
                    return true;
                }
            }
        }
        return false;
    }
    */
    public boolean validPalindrome(String s) {
        return isPalindrome(s,1);
    }
    private boolean isPalindrome(String s, int chance){
        int len = s.length();
        for(int i=0;i<len;i++){
            int j=len-1-i;
            if(i<=j){
                if(s.charAt(i)!=s.charAt(j)){
                    if(chance>0){
                        return isPalindrome(s.substring(0,i)+s.substring(i+1,len),0)||isPalindrome(s.substring(0,j)+s.substring(j+1,len),0);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
