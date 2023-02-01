class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if ( str1.length() < str2.length() )
        {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        String max = "";
        
        for (int i=1;i<=str2.length();i++) {
            String sub = str2.substring(0,i);
            if ( str2.length() % sub.length() != 0 ) continue;
            
            String temp = str2;

            while ( temp.length() >= sub.length() ) {
                if ( temp.startsWith(sub) )
                    temp = temp.substring(sub.length(),temp.length());
                else
                    break;
            }
            if ( temp.length() != 0 )
                continue;
            
            
             temp = str1;

            while ( temp.length() >= sub.length() ) {
                if ( temp.startsWith(sub) )
                    temp = temp.substring(sub.length(),temp.length());
                else
                    break;
            }
            if ( temp.length() == 0 )
                max = sub;
            
        }
        
        
        
        return max;
    }
}