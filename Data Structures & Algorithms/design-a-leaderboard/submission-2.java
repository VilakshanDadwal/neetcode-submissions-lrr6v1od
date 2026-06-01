class Leaderboard {
    private Map<Integer, Integer> playerScore;
    private Map<Integer, Integer> scoreCount;

    public Leaderboard() {
        playerScore = new HashMap<Integer, Integer>();
        scoreCount = new TreeMap<Integer, Integer>((a,b) -> Integer.compare(b,a));    
    }
    
    public void addScore(int playerId, int score) {
        var oldScore = playerScore.getOrDefault(playerId, 0);
        var newScore = oldScore + score;
        playerScore.put(playerId, newScore);
        
        if(oldScore!=0) {
            scoreCount.put(oldScore, scoreCount.get(oldScore) - 1);
            if(scoreCount.get(oldScore) == 0) scoreCount.remove(oldScore);
        }
        scoreCount.put(newScore, scoreCount.getOrDefault(newScore, 0) + 1);
    }
    
    public int top(int K) {
        var sum =0;
        var playersRemaining = K;

        for(Map.Entry<Integer, Integer> scoreEntry : scoreCount.entrySet()) {
            var score = scoreEntry.getKey();
            var playerCount = scoreEntry.getValue();
            while(playerCount > 0 && playersRemaining > 0) {
                sum = sum + score;
                playerCount--;
                playersRemaining--;
            }
            if(playersRemaining ==0) break;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        var oldScore = playerScore.get(playerId);
        playerScore.remove(playerId);

        scoreCount.put(oldScore, scoreCount.get(oldScore) - 1);
        // Remove if no players with this score.
        if(scoreCount.get(oldScore) == 0) scoreCount.remove(oldScore);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
