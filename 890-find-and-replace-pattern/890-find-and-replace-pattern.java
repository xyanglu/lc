class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<Integer> patternList = convertToPattern(pattern);
        List<String> rc = new ArrayList<String>();
        
        for (String word : words)
        {
            List<Integer> wordPattern = convertToPattern(word);
            
            if (patternList.size()==wordPattern.size())
            {
                boolean match = true;
                
                for (int i=0;i<patternList.size();i++)
                {
                    match &= patternList.get(i) == wordPattern.get(i);
                }
            
                if (match)
                {
                                    rc.add(word);
                }
            }
            
        }
        
        return rc;
    }
    public List<Integer> convertToPattern (String word) {
        List<Character> temp = new ArrayList<Character>();
        List<Integer> rc = new ArrayList<Integer>();
        int count = 0;
        
        for (char c : word.toCharArray())
        {
            if (temp.indexOf(c)<0)
            {
                temp.add(c);
                count++;
                rc.add(count);
            }
            else
            {
                rc.add(temp.indexOf(c));
            }
        }
        
        return rc;
        
    }
}