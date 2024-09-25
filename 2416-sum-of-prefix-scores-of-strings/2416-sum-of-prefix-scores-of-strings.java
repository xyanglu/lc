class Trie {
    Trie[] next = new Trie[26];
    int count = 0;
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie t = new Trie();
        for (String w : words) {
            Trie temp = t;
            for ( char c : w.toCharArray() )
            {
                if ( temp.next[c-'a'] == null )
                    temp.next[c-'a'] = new Trie();
                temp = temp.next[c-'a'];
                temp.count++;
            }
        }
        
        int[] rc = new int[words.length];
        
        for (int i=0;i<rc.length;i++) {
            String w = words[i];
                        Trie temp = t;
            int total = 0;
            for ( char c : w.toCharArray() )
            {
                temp = temp.next[c-'a'];
                total += temp.count;
            }
            rc[i] = total;
        }
        
        
        return rc;
        
    }
}