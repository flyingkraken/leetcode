class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> out = new ArrayList<Integer>();
        int[] count = new int[26];
        
        for(int i=0;i<p.length();i++){
            count[p.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            int[] copy = new int[26];
            System.arraycopy(count, 0, copy, 0, 26);
            if(copy[tmp - 'a']!=0){
                if(match(s, copy, i, p.length())==1){
                    out.add(i);   
                }
            }
        }
        return out;
        
        
    }
    
    public int match(String s, int[] copy, int start, int len){
        if(start+len>s.length()){
            return 0;
        }
        for(int i=start;i<start+len;i++){
            if(copy[s.charAt(i)-'a']!=0){
                copy[s.charAt(i)-'a']--;
            }
            else{
                return 0;
            }
        }
        return 1;
    }
}
