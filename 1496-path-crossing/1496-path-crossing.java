class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        
        Set<String> set = new HashSet();
        set.add(0+" "+0);
        for ( char c : path.toCharArray() ) {
            if ( c == 'N' )
            {
                x--;
            }
            else if ( c == 'S' )
            {
                x++;
            }
            else if ( c == 'W' )
            {
                y--;
            }
            else if ( c == 'E' )
            {
                y++;
            }
            if ( set.contains(x+" "+y) )
                return true;
            set.add(x+" "+y);
            
        }
        
        return false;
    }
}