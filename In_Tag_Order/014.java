class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
        if(strs.length == 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append(strs[0]);
        for(String s:strs){
        	int i=0;
        	while(i<res.length()){
        		if(i>=s.length() || res.charAt(i)!=s.charAt(i)){
        			res = res.delete(i, res.length());//可以用substring代替
        			break;
        		}
        		i++;
        	}
            
        }
        return res.toString();
        */
        
        if(strs.length == 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        int p=0;
        while(equalAtIndex(strs, p)){
            res.append(strs[0].charAt(p++));
        }
        return res.toString();

    }
    
    private boolean equalAtIndex(String[] strs, int i){
        for(String s:strs){
            if(i>=s.length() || strs[0].charAt(i)!=s.charAt(i)){
        			return false;
        	}
        }
        return true;
    }
}