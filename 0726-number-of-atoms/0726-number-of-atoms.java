class Solution {
    public String countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder();
        
        Map<String,Integer> map = dfs(formula);
        // System.out.println(map);
        for ( String name : map.keySet() ) 
            {
            sb.append(name);
            if ( map.get(name) > 1 ) 
                sb.append(map.get(name));
            }
        
        return sb.toString();
    }
    Map<String,Integer> dfs(String formula) {
        int i = formula.length() - 1;
        Map<String,Integer> map = new TreeMap();
        int mult = 0;
        String name = "";
        
        while ( i >= 0 ) {
            char c = formula.charAt(i);

            //number
            if ( c >= '0' && c <= '9' ) {
                mult = (int) (c-'0');
                int base = 10;
                while ( formula.charAt(i-1) >= '0' &&  formula.charAt(i-1) <= '9' ) {
                    char d = formula.charAt(i-1);
                    int val = d-'0';
                    mult += val * base;
                    base *= 10;
                    i--;
                }
                i--;
            }
            //bracket
            else if ( c == ')' ) {
                int cur = 1;
                int j = i - 1;
                while ( j >= 0 && cur != 0 ) {
                    char d = formula.charAt(j);
                    if ( d == ')' )
                        cur++;
                    else if ( d == '(')
                        cur--;
                    j--;
                }
                
                Map<String,Integer> temp = dfs(formula.substring(j+2,i));
                
                if ( mult == 0 ) mult = 1;
                for ( String n : temp.keySet() )
                    map.put(n, map.getOrDefault(n,0)+ temp.get(n)*mult );
                
                mult = 0;
                i = j;
            }
            //letter
            else {
                name = c+"";
                if ( c>='a' && c<='z' )
                while ( i>0 && ( (formula.charAt(i-1) >= 'a' &&  formula.charAt(i-1) <= 'z') || (formula.charAt(i-1) >= 'A' &&  formula.charAt(i-1) <= 'Z'  ))) {
                    char d= formula.charAt(i-1);
                    name = d + name;
                    i--;
                    if ( d>='A' && d<='Z' ) break;
                }
                if ( mult == 0 ) mult = 1;
                map.put(name,map.getOrDefault(name,0) + mult);
                i--;
                name = "";
                mult = 0;
            }
        }
        return map;
    }
}