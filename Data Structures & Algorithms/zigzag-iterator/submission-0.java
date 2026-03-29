// Solution for two lists
class ZigzagIterator {

    private List<Integer> v1;
    private List<Integer> v2;

    private int i = 0; // pointer for v1
    private int j = 0; // pointer for v2

    private boolean turnV1 = true; // whose turn

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        // If it's v1's turn AND v1 still has elements
        if ((turnV1 && i < v1.size()) || j >= v2.size()) {
            turnV1 = false; // switch turn
            return v1.get(i++);
        }

        // Otherwise use v2
        else {
            turnV1 = true; // switch turn
            return v2.get(j++);
        }
    }

    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
