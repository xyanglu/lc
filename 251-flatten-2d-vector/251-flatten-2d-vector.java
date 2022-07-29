class Vector2D {

    Queue<Integer> queue = new LinkedList();
    
    public Vector2D(int[][] vec) {
        for (int[] ve : vec)
            for (int v : ve)
                queue.add(v);
    }
    
    public int next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */