class Solution {
    public String[] expand(String s) {
        Set<String> list = new TreeSet();
        list.add("");
        
        while ( s.length() != 0 ) {
                    Set<String> newList = new TreeSet();
            char c = s.charAt(0);
            if ( Character.isLetter(c) ) {
                for ( String sb : list ) 
                    newList.add(sb+c);
                s = s.substring(1,s.length());
            }
            else
            {
                int index = s.indexOf('}');
                String arr = s.substring(1,index);
                s = s.substring(index+1,s.length());
                String[] opt = arr.split(",");
                for ( String sb : list) 
                    for ( String o : opt)
                        newList.add(sb + o);
            }
            list = newList;
        }
        
        
        String[] rc = new String[list.size()]; 
        int i = 0;
        for ( String sb : list)
            rc[i++] = sb;
        return rc;
    }
}