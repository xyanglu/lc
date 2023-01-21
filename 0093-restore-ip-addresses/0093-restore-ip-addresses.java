class Solution {
    List<String> list = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        dfs(s,3,"");
        return list;
    }
    void dfs(String s, int z, String sb) {
        //System.out.println(s+" "+sb);
        if ( z < 0 ) return;
        if ( z == 0 && s.length() > 3 || s.length() == 0 )  return;
        if ( z == 0 ) {
                     int parse = Integer.parseInt(s);
            if ( String.valueOf(parse).length() != s.length() ) return;
            if ( parse > 255 ) return;
                list.add(sb + s);
            
                return;
        }
        for (int i=1;i<=3;i++) {
            String sub = s.substring(0,Math.min(s.length(),i));
            if ( sub.length() == 0 ) continue;
            int parse = Integer.parseInt(sub);
            if ( String.valueOf(parse).length() != sub.length() ) continue;
            if ( parse > 255 ) continue;
            dfs( s.substring(sub.length(),s.length()),z-1,sb+sub+'.');
        
        }
    }
}