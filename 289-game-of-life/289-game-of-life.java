class Solution {
    public void gameOfLife(int[][] board) {
        int[][] b = new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++)
                b[i][j] = hasLife(board,i,j) ? 1 : 0;
        
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++)
                board[i][j] = b[i][j];
    }
    boolean hasLife(int[][] board, int i, int j) {
        int neigh = 0;
        
        if ( i > 0 && j > 0 )
            neigh+= board[i-1][j-1];
        if ( i > 0 )
            neigh+= board[i-1][j];
        if ( i > 0 && j + 1 < board[0].length )
            neigh+= board[i-1][j+1];
        
        if ( j > 0 )
            neigh+= board[i][j-1];
        if ( j + 1 < board[0].length )
            neigh+= board[i][j+1];
        
        if ( i + 1 < board.length && j > 0 )
            neigh+= board[i+1][j-1];
        if ( i + 1 < board.length )
            neigh+= board[i+1][j];
        if ( i + 1 < board.length && j + 1 < board[0].length )
            neigh+= board[i+1][j+1];
        
        if ( board[i][j] == 0 ) return neigh == 3;
        return neigh == 2 || neigh == 3;
    }
}