class WordDistance {

    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0; i<wordsDict.length; i++) {
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList())
                .add(i);
        }    
    }
    
    public int shortest(String word1, String word2) {
        var word1Idxs = map.get(word1);
        var word2Idxs = map.get(word2);
        var shortestDist = Integer.MAX_VALUE;
        var idx1 = 0;
        var idx2 = 0;

        while(idx1 < word1Idxs.size() && idx2 < word2Idxs.size()) {
            var dist = Math.abs(word1Idxs.get(idx1) - word2Idxs.get(idx2));
            shortestDist = Math.min(shortestDist, dist);
            if(word1Idxs.get(idx1) > word2Idxs.get(idx2)) {
                idx2++;
            } else {
                idx1++;
            }
        }
        return shortestDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */