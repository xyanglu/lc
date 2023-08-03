class Solution {
    public List<String> letterCombinations(String digits) {
        if ( digits.length() == 0 ) return new ArrayList();
        List<String> l = new ArrayList();
        List<String> list = new ArrayList();
        list.add("");
        
        char[][] arr = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};            
    
        int n = digits.length();
        while ( digits.length() > 0 ) {
            char c = digits.charAt(0);
            digits = digits.substring(1,digits.length());

                for ( String li : list)
                {
                    for ( char d : arr[c-'2'])
                    {
                            l.add(li+d);
                    }
                }
            list = new ArrayList(l);
        }
        while ( list.size() > 0 && list.get(0).length() != n ) 
            list.remove(0);

        
        return list;

        
        
        
    }
}