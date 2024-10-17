class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder ( String.valueOf(num));
        int n = sb.length();
        List<int[]> list = new ArrayList();
        int max = 0;
        int coord = 0;
        for ( int i=n-1;i>=0;i--) {
            char c = sb.charAt(i);
            if ( list.size() == 0 || c - '0' > list.get(list.size()-1)[0] ) {
                list.add(new int[]{ c - '0', i});
            }
        }
        
        for ( int i=0;i<n;i++) {
            char c = sb.charAt(i);
            if (  list.size() > 0 && list.get( list.size()-1)[1] <= i )
                list.remove( list.size() - 1 );
            if ( list.size() > 0 && list.get( list.size()-1)[0] > c - '0' )
            {
                sb.setCharAt(i, (char) (list.get(list.size()-1)[0]+'0'));
                sb.setCharAt( list.get(list.size()-1)[1], c);
                break;
            }
        }
        
        return Integer.parseInt( sb.toString() ) ;
    }
}