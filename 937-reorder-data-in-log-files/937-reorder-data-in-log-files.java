class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b) -> {
            
            String[] A = a.split(" ");
            String[] B = b.split(" ");
                  
            String key1 = A[0];
            String key2 = B[0];
            
            boolean aDigit = Character.isDigit(A[1].charAt(0));
            boolean bDigit = Character.isDigit(B[1].charAt(0));
            
            if ( aDigit && bDigit ) return 0;
            if ( aDigit ) return 1;
            if ( bDigit ) return -1;
            
            StringBuilder as = new StringBuilder();
            for ( int i=1;i<A.length;i++)
                as.append(A[i] + " ");
            as.deleteCharAt(as.length()-1);
            
            StringBuilder bs = new StringBuilder();
            for ( int i=1;i<B.length;i++)
                bs.append(B[i] + " ");
            bs.deleteCharAt(bs.length()-1);
            
            int val = as.compareTo(bs);
            System.out.println( as + " "+bs+" "+val);
            if ( val == 0 )
                return key1.compareTo(key2);
            else
                return val;
        });
        return logs;
 
    }
}