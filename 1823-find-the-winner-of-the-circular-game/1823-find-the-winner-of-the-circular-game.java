class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList();
        for (int i=1;i<=n;i++) 
            list.add(i);
        int i = 0;
        k--;
        
        while ( list.size() > 1 ) { 
            int v = k % list.size();
            i += v;
            i %= list.size();
            list.remove(i);
            
        }
        
        
        return list.get(0);
    }
}