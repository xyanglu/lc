class Solution {
    public String sortVowels(String s) {
        Queue<Character> queue = new PriorityQueue<>( (a,b) -> a - b );
        
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' ||     c=='u' || c=='U')
                queue.add(c);
        }
        StringBuilder sb = new StringBuilder(s);
        
        for (int i=0;i<s.length();i++) {
             char c = s.charAt(i);
            if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' ||     c=='u' || c=='U')
                sb.setCharAt(i, queue.poll());
        }
        
        return sb.toString();
    }
}