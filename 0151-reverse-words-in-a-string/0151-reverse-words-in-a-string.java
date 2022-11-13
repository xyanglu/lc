class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (int i=arr.length-1;i>=0;i--) 
        {
            if ( arr[i] == "" ) continue;
            sb.append(arr[i]);
            if ( i != 0 )
                sb.append(" ");
        }
        return sb.toString().trim();
    }
}