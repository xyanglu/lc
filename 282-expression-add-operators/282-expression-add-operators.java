class Solution {
    int target = 0;
    List<String> list;
    String num = null;
    public List<String> addOperators(String num, int target) {
        this.target = target;
        list = new ArrayList();
        this.num = num;
        dfs(0,0,0,"");
        return list;
    }
    void dfs(int i, long sum, long prev, String temp) {
        if ( i == num.length() ) {
            if ( sum == target ) {
                temp = temp.substring(1,temp.length());
                if ( !list.contains(temp) )
                    list.add(temp);
            }
            return;
        }
        for (int j=i+1;j<=Math.min(10,num.length());j++) {
            String sub = num.substring(i,j);
            if ( sub.length() != 1 && sub.startsWith("0") ) continue;
            long val = Long.parseLong( sub );
            
            String str = temp+"+"+val;
            if ( val < 0 )
                str = temp+"-"+val;
            
            //add
            dfs(j,sum+val,val,str);
            
            if ( i == 0 ) continue;
            str = temp+"-"+val;
            if ( val < 0 )
                str = temp+"+"+val;
            
            //remove
            dfs(j,sum-val,-1*val,str);
            
            //multiply
            if ( i == 0 ) continue;
            sum-=prev;
            long v = prev * val;
            str = temp +"*"+val;
            dfs(j,sum+v,v,str);
            sum+=prev;
        }
    }
}