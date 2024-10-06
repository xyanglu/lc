class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) { 
         String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        int n = arr1.length;
        int m = arr2.length;
        
        if ( n > m ) {
            String[] temp = arr2;
            arr2 = arr1;
            arr1 = temp;
            n = arr1.length;
            m = arr2.length;
        }
        
        boolean succ = true;
        for (int i=0;i<n;i++) {
            if ( !arr1[i].equals(arr2[i]) )
                succ = false;
        }
        if ( succ )
            return true;
        
        succ = true;
        for (int i=0;i<n;i++) {
            if ( !arr2[m-1-(n-1-i)].equals(arr1[i]) )
                succ = false;
        }
        if ( succ )
            return true;
        
        
        for (int i=0;i<arr1.length;i++) {
            succ = true;
            for (int j = 0;j<=i&&succ;j++) {
                if ( !arr2[j].equals(arr1[j]) )
                    succ = false;
            }
            for (int j=i+1;succ&&j<n;j++) {
                // System.out.println( arr2[m-1-(n-1-j)] + " "+arr1[j]);
                if ( !arr2[m-1-(n-1-j)].equals(arr1[j]) )
                    succ = false;
            }
            if ( succ )
                return true;
                
        }
        
        
        
        return false;
    }
}