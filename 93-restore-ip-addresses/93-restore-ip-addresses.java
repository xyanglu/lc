class Solution {
    public List<String> restoreIpAddresses(String s) {
        Set<String> list = new HashSet();
        dfs(list,0,new ArrayList(),s);
        return new ArrayList(list);
    }
    void dfs(Set<String> list, int i, List<String> temp, String S) {
        if ( temp.size() == 4 && i < S.length() ) return;
        if ( i >= S.length() ) {
            if ( temp.size() != 4 ) return;
            for (String s : temp)
                if ( s.startsWith("0") && s.length() != 1 || Integer.parseInt(s)>255)
                    return;
            
            StringBuilder sb = new StringBuilder();
            for ( int j=0;j<4;j++) {
                sb.append( temp.get(j) );
                if ( j != 3 )
                    sb.append(".");
            }
            list.add(sb.toString());
            return;
        }
        for ( int j=i+1;j<=i+3;j++)
        {
            temp.add( S.substring(i,Math.min(j,S.length())) );
            dfs(list,j,temp,S);
            temp.remove(temp.size()-1);
        }
    }
}