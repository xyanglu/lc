class Solution {
      Set<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
       this.set =new HashSet<>(Arrays.asList(words));
        List<String> list = new ArrayList<>();
        for(String word:words){
            if(dfs(word)){
                list.add(word);
            }
        }
        return list;
    }
    public boolean dfs(String word){
         for(int i=1;i<word.length();i++){
             String pre = word.substring(0,i);
             String suf = word.substring(i,word.length());
             if((set.contains(pre)&&set.contains(suf)) || (set.contains(pre)&&dfs(suf))){
                 return true;
             }
         }
         return false;
    }
}