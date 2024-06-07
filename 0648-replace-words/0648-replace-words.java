class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet();
        set.addAll(dictionary);
        for ( String s : sentence.split(" ")) 
        {
            boolean replace = false;
            for (int i=1;i<s.length();i++)
                if ( set.contains(s.substring(0,i)))
                {
                    replace = true;
                    sb.append(s.substring(0,i)+" ");
                    break;
                }
            if ( !replace )
                sb.append(s+" ");
        }
        return         sb.substring(0,sb.length()-1);

    }
}