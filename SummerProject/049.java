/*class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<List<String>>();
        int[][] counts = new int[strs.length][26];
        int num = 0;//the number of existed anagrams
        for(int i=0;i<strs.length;i++){
            
        }
    }
    
    private int index(String str, int[][] counts, int num){
        int[] count = new int[26];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'a']++;
        }
        
        for(int i=0;i<num;i++){
            boolean equal = true;
            for(int j=0;j<26;j++){
                if(counts[i][j]!=count[j]){
                    equal = false;
                    break;
                }
            }
            if(equal == true){
                return i;
            }
        }
        
        return num;
    }
}*/

	public String sortArray(String arr){
		char[] charArray  = arr.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray); 
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String,Integer> wordMap = new HashMap<String,Integer>();
		int count = 0;
		
		for(int i=0;i<strs.length;i++){
			if(!wordMap.containsKey(sortArray(strs[i]))){
				wordMap.put(sortArray(strs[i]),count);
				List<String> temp = new ArrayList<String>();
				temp.add(strs[i]);
				res.add(temp);
				count++;
			}
			else{
				List<String> temp = res.get(wordMap.get(sortArray(strs[i])));
				temp.add(strs[i]);
				res.set(wordMap.get(sortArray(strs[i])),temp);
			}
		}
     
		return res;
        
    }
