class Solution {
    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;

        if ( start.replaceAll("_","").length() != target.replaceAll("_","").length() ) return false;
        
        while ( i < start.length() && j < target.length() ) {
            while ( i < start.length() && start.charAt(i) == '_' ) i++;
            while ( j < target.length() && target.charAt(j) == '_' ) j++;
            if ( i == start.length() && j == target.length() ) return true;
            if ( i == start.length() || j == target.length() ) return false;
            if ( start.charAt(i) != target.charAt(j) ) return false;
            if ( start.charAt(i) == 'L' ) {
                // System.out.println("L"+" "+i+" "+j);
                if ( j <= i ) {
                    i++;
                    j++;
                }
                else
                    return false;
            }
            else if ( i < start.length() && j < target.length() && start.charAt(i) == 'R' ) {
                // System.out.println("R"+" "+i+" "+j);
                if ( i <= j ) {
                    i++;
                    j++;
                }
                else
                    return false;
            }
            
        }
        
        
        return true;
    }
}

