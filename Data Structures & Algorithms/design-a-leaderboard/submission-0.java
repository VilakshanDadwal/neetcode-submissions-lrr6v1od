class Leaderboard {
    private Map<Integer, Integer> scores; 
    public Leaderboard() {
        scores = new HashMap<Integer, Integer>();
    }
    
    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        var sum =0;
        var minHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(a, b));
        for(Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            var score = entry.getValue();
            minHeap.add(score);
            sum += score;
            if(minHeap.size()>K) {
                sum -= minHeap.poll();
            }
        }
        return sum;
    }
    
    public void reset(int playerId) {
        scores.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
