class Solution {
    public List<String> buildArray(int[] target, int n) {
        int j = 0;
        List<String> list = new ArrayList();
        
        for (int i=1;i<=n&&j<target.length;i++) {
//            System.out.println(i+" "+target[j]);
            if ( target[j] != i ) {
                list.add("Push");
                list.add("Pop");
            }
            else {
                list.add("Push");
                j++;
            }
            
        }
        
        return list;
        
    }
}