class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        for (int i=0;i<numRows;i++)
        {
            List<Integer> temp = new ArrayList();
            temp.add(1);
            temp.add(1);
            list.add(new ArrayList(temp));
        }
        list.get(0).remove(0);
        
        for (int i=2;i<numRows;i++)
            for (int j=0;j<=i-2;j++)
                list.get(i).add(j+1, list.get(i-1).get(j)+list.get(i-1).get(j+1) );
        
        return list;
    }
}