class Solution {
    String s1,s2,s3;
    int[][] arr;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        if ( s1.length() + s2.length() != s3.length()) return false;
        arr = new int[s1.length()+1][s2.length()+1];
        arr[s1.length()][s2.length()] = 1;
       return dfs(0,0);
    }
    boolean dfs(int i, int j) {
        if ( arr[i][j] != 0 ) return arr[i][j]==1;
        
        boolean a = i<s1.length() && s1.charAt(i)==s3.charAt(i+j) && dfs(i+1,j);
        boolean b = j<s2.length() && s2.charAt(j)==s3.charAt(i+j) && dfs(i,j+1);
        arr[i][j] = a|b?1:-1;
        
        return a|b;
        
    }
}