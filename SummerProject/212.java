class Solution {
    class TrieNode{
        TrieNode [] children;
        boolean isWord;
        public TrieNode(){
            isWord=false;
            children= new TrieNode[26];
        }
    }
    public void DFS(TrieNode parent, List<String> res, StringBuilder cur, char[][]board, int row, int col, Set<String> found){
        if(row<0||col<0||col>=board[0].length||row>=board.length||parent==null||board[row][col]=='?')
            return;
        char c = board[row][col];
        cur.append(c);
        if( parent.children[c-'a']!=null && parent.children[c-'a'].isWord && !found.contains(cur.toString())){
            res.add(cur.toString());
            found.add(cur.toString());
        }
       
        
        board[row][col]='?';
        DFS(parent.children[c-'a'],res,cur,board,row,col+1,found);
        DFS(parent.children[c-'a'],res,cur,board,row+1,col,found);
        DFS(parent.children[c-'a'],res,cur,board,row,col-1,found);
        DFS(parent.children[c-'a'],res,cur,board,row-1,col,found);
        cur.setLength(cur.length()-1);
        board[row][col]=c;
        
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode search = new TrieNode();
        Set<String> found = new HashSet<>();
        for(int i=0; i<words.length;++i){
            TrieNode cur = search;
            for(int j=0; j<words[i].length();++j){
                char c = words[i].charAt(j);
                if(cur.children[c-'a']==null){
                    cur.children[c-'a']= new TrieNode(); 
                }
                if(j==words[i].length()-1){
                    cur.children[c-'a'].isWord=true;
                }
                cur=cur.children[c-'a'];
            }
        }
        List<String> res = new ArrayList<>();
        if(board[0].length==0)return res;
        for(int i=0; i<board.length;++i){
            for(int j=0; j<board[0].length;++j){
                StringBuilder cur = new StringBuilder();
                DFS(search,res,cur,board,i,j,found);
            }
        }
        return res;
    }
}
