class Solution {
    public int findComplement(int num) {
        int rc = 0;
        String str = Integer.toBinaryString(num);
        str = str.replaceAll("0","#");
        str = str.replaceAll("1","0");
        str = str.replaceAll("#","1");
        
        for (int i=str.length()-1;i>=0;i--)
            rc += Math.pow(2, str.length() -  1 - i) * (str.charAt(i)-'0');
        return rc;
    }
}