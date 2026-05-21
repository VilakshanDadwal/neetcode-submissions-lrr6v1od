class HitCounter {
    private Queue<Integer> hits;

    public HitCounter() {
        this.hits = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!hits.isEmpty()) {
            var allowedHitTimestamp = timestamp - 300;
            if(hits.peek() <= allowedHitTimestamp)
                hits.poll();
            else 
                break;
        }
        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
