class Solution {
    public String tictactoe(int[][] moves) {
        int[][] arr = new int[3][3];
        for (int i=0;i<moves.length;i++)
        {
            int x = i % 2 + 1;
            int[] m = moves[i];
            arr[m[0]][m[1]] = x;
        }
        for (int i=0;i<3;i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
        
        for (int i=0;i<3;i++)
            if ( arr[i][0] != 0 && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] )
                return arr[i][0] == 1 ? "A" : "B";
        
        for (int i=0;i<3;i++)
            if (  arr[0][i] != 0 && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] )
                return arr[0][i] == 1 ? "A" : "B";
        
        if ( arr[0][0] != 0 && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2])
                return arr[0][0] == 1 ? "A" : "B";
        if ( arr[0][2] != 0 && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] )
                            return arr[1][1] == 1 ? "A" : "B";
        
        return moves.length == 9 ? "Draw" : "Pending";
    }
}