class Solution {
    Set<String> list = new HashSet();
    int k = 0;
    int n = 0;
    public int[] numsSameConsecDiff(int n, int k) {
        this.k = k;
        this.n = n;
        for (int i=1;i<10;i++)
        {
            String temp = String.valueOf(  (char) (i+'0') );
            dfs(temp);
        }
        int[] rc = new int[list.size()];
        int i = 0;
        for (String s : list )
            rc[i++] = Integer.parseInt(s);
        return rc;
    }
    void dfs(String temp) {
        if ( temp.length() == n ) {
            //System.out.println(temp+" "+n);
            list.add(temp);
            return;
        }
        char c = temp.charAt(temp.length()-1);
        if ( c + k <= '9' )
            dfs(temp + (char) (c + k) );
        if ( c - k >= '0' )
            dfs(temp + (char) (c - k) );

    }
}