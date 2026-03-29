// Queue of pointer solution
class ZigzagIterator {
    private List<List<Integer>> vectors;
    private Queue<Pair<Integer, Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        vectors = new ArrayList<List<Integer>>();
        queue = new LinkedList<>();
        this.vectors.add(v1);
        this.vectors.add(v2);
        var vectorId = 0; // This is id of the vector.
        for(List<Integer> vector : vectors) {
            if(vector.size() > 0) 
            // Starting position of every vector is zero.
                this.queue.add(new Pair<Integer, Integer>(vectorId, 0));
            vectorId++;
        }
    }

    public int next() {
        var element = this.queue.poll();
        var vectorId = element.getKey();
        var index = element.getValue();
        // If polled vector element, has elements left, add next index and same vector to last.
        if(index+1 < this.vectors.get(vectorId).size())
            this.queue.add(new Pair<Integer, Integer>(vectorId, index+1));
            
        return this.vectors.get(vectorId).get(index);
    }

    public boolean hasNext() {
        return this.queue.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
