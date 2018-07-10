class Solution {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int count = 0;
        boolean isHorizonShip=false; 
        for(int i=0;i<row;i++){
            isHorizonShip = false;
            for(int j=0;j<col;j++){
                if(board[i][j]=='X'){
                    if(isHorizonShip==false && (i==0 || board[i-1][j]!='X')){
                        isHorizonShip = true;
                        count++;
                    }
                }
                else{
                    isHorizonShip = false;
                }
            }
        }
        return count;
    }
}
