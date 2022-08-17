class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String,Integer> count = new HashMap();
        Map<Character,String> map = new HashMap();
        for (int i=0;i<26;i++)
            map.put( (char) (i+'a') , arr[i]);
        Set<String> set = new HashSet();
        
        for (String word : words) {
            StringBuilder temp = new StringBuilder();
            for ( char c : word.toCharArray() )
                temp.append( map.get(c) );
            System.out.println(word+"\t"+temp.toString());
            set.add(temp.toString());
        }
        
        return set.size();
    }
}