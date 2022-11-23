class Solution {
    public boolean isValidSudoku(char[][] board) {
        //rows
        //System.out.println("row");
        for (int i=0;i<board.length;i++)
        {
            Set<Character> set = new HashSet();
            for (int j=0;j<board[0].length;j++)
            {
                   // System.out.print(board[i][j]+" ");
                if ( set.contains(board[i][j] ) && board[i][j]!='.' )
                    return false;
                set.add(board[i][j]);
            }
            //System.out.println();
        }
  
        //cols
                //System.out.println("cols");

                for (int i=0;i<board.length;i++)
        {
                Set<Character> set = new HashSet();
            for (int j=0;j<board[0].length;j++)
            {
                if ( set.contains(board[j][i]) && board[j][i]!='.'  )
                    return false;
                set.add(board[j][i]);
            }
        }
                //System.out.println("box");

        for (int i=0;i<board.length;i+=3)
            for (int j=0;j<board[0].length;j+=3)
            {
                Set<Character> set = new HashSet();
                for (int k=0;k<3;k++)
                    for (int l=0;l<3;l++)
                    {
                        if ( set.contains( board[i+k][j+l] ) && board[i+k][j+l] != '.'  )
                            return false;
                        set.add(board[i+k][j+l]);
                    }
            }
        return true;
    }
}