class Trie {
    Trie[] next = new Trie[26];
    boolean isWord = false;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for ( String word : words ) {
            Trie curr = trie;
            for ( char c : word.toCharArray() ) {
                if ( curr.next[c-'a']==null)
                    curr.next[c-'a'] = new Trie();
                curr = curr.next[c-'a'];
            }
            curr.isWord = true;
        }
        
        List<String> list = new ArrayList();
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[i].length;j++)
                dfs(list,board,i,j,"", trie);
        
        return list;
        
    }
    void dfs(List<String> list, char[][] board, int i, int j, String temp, Trie trie) {
        if ( i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '#' ) return;
        char c = board[i][j];
        board[i][j] = '#';
        temp += c;
        
        trie = trie.next[c-'a'];
        if ( trie == null ) {
            board[i][j] = c;
            return;
        }
        
        if ( trie.isWord )
            if ( !list.contains(temp) )
                list.add(temp);
        
        dfs(list,board,i-1,j,temp,trie);
        dfs(list,board,i+1,j,temp,trie);
        dfs(list,board,i,j-1,temp,trie);
        dfs(list,board,i,j+1,temp,trie);
        
        board[i][j] = c;
    }
    
}