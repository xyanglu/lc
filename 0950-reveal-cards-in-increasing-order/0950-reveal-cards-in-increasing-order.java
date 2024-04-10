class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        Arrays.sort(deck);
        
        int[] rc = new int[n];
        List<Integer> list = new ArrayList();
        for (int i=0;i<n;i++) 
            list.add(i);

            for (int i=0;i<n;i++) 
            {
                int index = list.remove(0);
                rc[index] = deck[i];
                if ( list.size() > 0 ) 
                    list.add(list.remove(0));
            }
        
        return rc;
        
        
    }
}