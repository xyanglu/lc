import java.util.Arrays;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<arr2.length;i++)
            map.put(arr2[i],i);
        
        
        // Comparator for PriorityQueue
        Comparator<Integer> comparator = (a, b) -> {
            boolean containsA = map.containsKey(a);
            boolean containsB = map.containsKey(b);
            
            // Case 1: Both a and b exist
            if (containsA && containsB) {
                return map.get(a) - map.get(b);
            }
            // Case 2: Only one exists
            else if (containsA || containsB) {
                return containsA ? -1 : 1; // Prioritize the one that exists
            }
            // Case 3: Neither exists
            else {
                return a - b; // Ascending order
            }
        };

        // Creating PriorityQueue with custom comparator
        Queue<Integer> queue = new PriorityQueue<>(comparator);
        for (int a : arr1)
            queue.add(a);
        
        int i = 0;
        while ( !queue.isEmpty() )
            arr1[i++] = queue.poll();
        
        return arr1;
    }
}