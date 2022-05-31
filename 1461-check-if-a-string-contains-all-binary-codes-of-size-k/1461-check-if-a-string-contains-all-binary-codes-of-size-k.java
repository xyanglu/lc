class Solution {
    public boolean hasAllCodes(String s, int k) {
        if ( k == 0 ) return true;
        int size = (int) Math.pow(2,k);
        Set<String> set = new HashSet();
        
        for (int i=0;i+k<=s.length();i++)
            set.add( s.substring(i,i+k));
        
        return set.size() == size;
    }
}