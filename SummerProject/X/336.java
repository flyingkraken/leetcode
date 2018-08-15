class Solution {
    /*public List<List<Integer>> palindromePairs(String[] words) {
        
        String str1;
        String str2;
        List<List<Integer>> res = new ArrayList();
        int[][] count = new int[words.length][26];
        List<String> allWords = new ArrayList();
        int[][] valid = new int[words.length][words.length];
          
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                str1 = words[i];
                str2 = words[j];
                if(myHelper(str1, str2)==true){
                    addToRes(i,j,res);
                }
                if(myHelper(str2, str1)==true){
                    addToRes(j,i,res);
                }
                
            }
        }
        /*
        for(int i=0;i<words.length;i++){
            allWords.add(words[i]);
            for(int j=0;j<words[i].length();j++){
                count[i][words[i].charAt(j)-'a']++;
            }
        }
        
        for(int j=0;j<26;j++){
            for(int i=0;i<words.length;i++){
                if(count[i][j]>0){
                    for(int k=0;k<words.length;k++){
                        //int[] ik = new int[]{i,k};
                        if(i!=k && count[k][j]>0 && valid[i][k]==0){
                            if(myHelper(words[i],words[k])==true){
                                addToRes(i,k,res);
                                valid[i][k]=1;
                                //valid.add(ik);

                            }else{
                                valid[i][k]=-1;
                                //invalid.add(ik);
                            }
                        }
                    }
                }
            }
        }
        
        
        if(allWords.contains("")){
            for(int i=0;i<words.length;i++){
                if(myHelper(words[i],"")==true){
                    addToRes(i,allWords.indexOf(""),res);
                    addToRes(allWords.indexOf(""),i,res);
                }
            }
        }
        

        return res;
        
        
        
    }*/
    
    
    /*
    private boolean myHelper(String str1, String str2){
        //if(str1.length()+str2.length()==1){return true;}
        //if((str1.length()+str2.length())%2==1){return false;}
        String str = str1 + str2;
        int len = str.length();
        int i,j;
        
        if(str.length()==0){
            return false;
        }
        if(len%2==0){
            i = len/2 - 1;
            j = len/2;
        }
        else{
            i = len/2 - 1;
            j = len/2 + 1;
        }
        for(;i>=0 && j<len;i--,j++){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }
    
    private void addToRes(int i, int j, List<List<Integer>> res){
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(i);
        tmp.add(j);
        res.add(tmp);
    }
    */
    
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new LinkedList<>();
        if (words == null) return pairs;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++ i) map.put(words[i], i);
        for (int i = 0; i < words.length; ++ i) {
            int l = 0, r = 0;
            while (l <= r) {
                String s = words[i].substring(l, r);
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                if (j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
                    pairs.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                if (r < words[i].length()) ++r;
                else ++l;
            }
        }
        return pairs;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; ++ i)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}


