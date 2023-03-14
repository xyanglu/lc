class Solution {
    public int shortestWay(String source, String target) {
        Set<Character> set = new HashSet();
        for ( char c : target.toCharArray() )
            set.add(c);
        
        Set<Character> set1 = new HashSet();
        for ( char c : source.toCharArray() )
            set1.add(c);
        
        for ( char c : set )
            if ( !set1.contains(c) )
                return -1;
        
        
        int count = 0;
        StringBuilder sb = new StringBuilder(target);
        while ( sb.length() > 0 ) {
            count++;
            StringBuilder temp = new StringBuilder(source);
            while ( sb.length() > 0 && temp.length() > 0 ) {
                char c = temp.charAt(0);
                if ( sb.charAt(0) == c )
                    sb.deleteCharAt(0);
                temp.deleteCharAt(0);
            }
            
            
        }
        
        
        
        
        return count;
    }
}