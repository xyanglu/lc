class Solution {
    List<String> list = new ArrayList();
    class Trie {
        Trie[] t = new Trie[26];
        boolean isWord;
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        
        for (String w : words)
        {
            Trie t = trie;
            for ( char c : w.toCharArray() )
            {
                if ( t.t[c-'a'] == null )
                    t.t[c-'a'] = new Trie();
                t = t.t[c-'a'];
            }
            t.isWord = true;
            t.word = w;
        }
        
        
        
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++)
                dfs(board,i,j,trie);
        
        return list;
    }
    void dfs(char[][] board, int i, int j, Trie trie) {
        if ( trie == null ) return;
        if ( i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] == '#' || trie.t[board[i][j] - 'a'] == null) return;
       // System.out.println( board[i][j] );
        trie = trie.t[board[i][j]-'a'];
        char temp = board[i][j];
        board[i][j] = '#';
        
        if ( trie.isWord && !list.contains( trie.word )) 
            list.add(trie.word);
            
        dfs(board,i-1,j,trie);
        dfs(board,i+1,j,trie);
        dfs(board,i,j-1,trie);
        dfs(board,i,j+1,trie);
        board[i][j] = temp;
        
        
    }
}