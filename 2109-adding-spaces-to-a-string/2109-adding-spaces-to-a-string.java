class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        for (int ss: spaces)
            sb.insert(i++ + ss," ");
        return sb.toString();
    }
}