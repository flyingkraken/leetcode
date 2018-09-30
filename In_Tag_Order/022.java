class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String temp = "";
        generater(res, temp, 2*n, 0, 0);
        return res;
    }
    
    //in this function, count means the number of unmatched "(" we already seen
    private void generater(List<String> res, String temp, int n, int count, int i){//Attention!! In this method, "n" is actually "2*n"
        if(i==n){
            res.add(temp);
            return;
        }
        
        if(count==0){
            generater(res, temp+"(", n, count+1, i+1);
        }else{
            generater(res, temp+")", n, count-1, i+1);
            if(n-i>count){
                generater(res, temp+"(", n, count+1, i+1);
            }
        }    
    }
}