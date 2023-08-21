class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        for (int i=1;i<=s.length()/2;i++)
        {
            if ( s.length() % i != 0 ) continue;
            int j = i;
            for (j=j;j<s.length();j+=i)
                if ( !s.substring(j,j+i).equals(s.substring(0,i)) ) break;
            if ( j == s.length() ) return true;   
            // System.out.println(i+" "+j);
            // System.out.println(s.substring(0,i) +" "+s.substring(j,j+i));

        }
        
        
        return false;
    }
}