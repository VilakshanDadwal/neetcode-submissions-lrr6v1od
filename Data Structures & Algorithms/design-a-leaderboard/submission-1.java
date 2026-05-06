// TreeSet Optimal Solution.
class Leaderboard {
    private Map<Integer, Integer> scores; 
    // Scores sorted in desc order.
    // More than 1 players can be at the same score.
    // As we need to get sum of top k scores, need to store number of players at that score.
    private Map<Integer, Integer> sortedScores;

    public Leaderboard() {
        scores = new HashMap<Integer, Integer>();
        sortedScores = new TreeMap<Integer, Integer>((a,b) -> Integer.compare(b, a));
    }
    
    public void addScore(int playerId, int score) {
        // Update score for player.
        var prevScore = scores.getOrDefault(playerId, 0);
        var newScore = prevScore + score;
        scores.put(playerId, newScore);

        // Update number of players with prevScore;
        if(prevScore > 0 && sortedScores.containsKey(prevScore)) {
            sortedScores.put(prevScore, sortedScores.get(prevScore) - 1);
            // If no player at prevScore, remove that entry.
            if(sortedScores.get(prevScore) == 0) sortedScores.remove(prevScore);
        }
        
        sortedScores.put(newScore, sortedScores.getOrDefault(newScore, 0) + 1);
    }
    
    public int top(int K) {
        var sum =0;
        var noOfPlayersConsidered =0;
        for(Map.Entry<Integer, Integer> entry: sortedScores.entrySet()) {
            var score = entry.getKey();
            var playerCountCurrentScore = entry.getValue();
            
            while(noOfPlayersConsidered < K && playerCountCurrentScore > 0) {
                noOfPlayersConsidered++;
                sum+=score;
                playerCountCurrentScore--;
            }
            if (noOfPlayersConsidered == K) break;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        var prevScore = scores.get(playerId);
        scores.remove(playerId);

        sortedScores.put(prevScore, sortedScores.get(prevScore) - 1);
        // If no player at prevScore, remove that entry.
        if(sortedScores.get(prevScore) == 0) sortedScores.remove(prevScore);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
