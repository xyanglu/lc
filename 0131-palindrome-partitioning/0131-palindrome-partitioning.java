class Solution {
    public List<List<String>> partition(String s) {
            List<List<String>> list = new ArrayList();

        for (int i=1;i<=s.length();i++) {
           String sub = s.substring(0,i);
            // System.out.println(sub);
            if ( isPalin(sub) ) {
                List<List<String>> rem = partition(s.substring(i,s.length()));
                for ( List<String> l : rem)
                {
                    l.add(0,sub);
                    list.add(l);
                }
                List<String> temp = new ArrayList();
                temp.add(sub);
                if ( i == s.length() )
                    list.add(temp);
            }
        }
        
        return list;
    }
    boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;
        while ( i < j ) 
            if ( s.charAt(i++) != s.charAt(j--) ) return false;
        
        
        return  true;
    }
    
}