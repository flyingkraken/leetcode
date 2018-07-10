class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || word.length()==0) return false;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                boolean exists = dfs(board, word, i,j, 0);
                if(exists) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] == '#') return false;
        if(board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean down = dfs(board, word, i+1, j, index+1);
        if(down) {
            board[i][j] = temp;
            return true;
        }
        boolean up = dfs(board, word, i-1, j, index+1);
        if(up) {
            board[i][j] = temp;
            return true;
        }
        boolean left = dfs(board, word, i, j-1, index+1);
        if(left) {
            board[i][j] = temp;
            return true;
        }
        boolean right = dfs(board, word, i, j+1, index+1);
        if(right) {
            board[i][j] = temp;
            return true;
        }
        board[i][j] = temp;
        return false;
}
}
