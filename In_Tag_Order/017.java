class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<Character, String>();
        List<String> res = new ArrayList<>();
        
        if(digits.length()==0){
            return res;
        }
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        /*
        ** Below is a non-recursive solution
        ** It uses add-delete operations, which looks more like a BFS solution.
        ** We comment these codes becasue it is less efficient.
        
        String tmpStr = map.get(digits.charAt(0));
        for(int i=0;i<tmpStr.length();i++){
            res.add(Character.toString(tmpStr.charAt(i)));
        }
        
        for(int i=1;i<digits.length();i++){
            String tempStr = map.get(digits.charAt(i));
            int size = res.size();
            for(int j=0;j<size;j++){
                for(int k=0;k<tempStr.length();k++){
                    res.add(res.get(j)+tempStr.charAt(k));
                }
            }
            for(int jj=0;jj<size;jj++){
                res.remove(0);
            }
        }
        return res;   
        */
        


        /*
        ** Below is a recursive solution using DFS.
        ** It's easy and concise.
        */
        Dfs(digits, map, res, 0, "");
        return res;
    }
    
    private void Dfs(String digits, Map<Character, String> map, List<String> res, int start, String path){
        if(start == digits.length()){
            res.add(path);
            return;
        }
        
        for(char c:map.get(digits.charAt(start)).toCharArray()){
            Dfs(digits, map, res, start+1, path+c);
        }
    }
}