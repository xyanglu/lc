class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList();
        if ( digits.length() == 0 ) return list;
        list.add("");
        Map<Character,String> map = new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        for ( char c : digits.toCharArray() ) {
            List<String> newList = new ArrayList();
            for ( char d : map.get(c).toCharArray() )
                for ( String s : list)
                    newList.add(s + d);
            list = newList;
        }
        return list;
    }
}