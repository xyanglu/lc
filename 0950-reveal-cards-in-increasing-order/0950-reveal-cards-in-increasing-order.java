class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        Arrays.sort(deck);
        
        List<Integer> list = new ArrayList();
        for (int i=n-1;i>=0;i--) {
            if ( list.size() > 0 )
                list.add(0,list.remove(list.size()-1));
            list.add(0,i);
        }
        
        int[] rc = new int[n];
        for (int i=0;i<n;i++)
            rc[i] = deck[list.get(i)];
        return rc;
        
        
    }
}