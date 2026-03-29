class Twitter {
    private int tweetCount;
    private Map<Integer, List<int[]>> userTweets;
    private Map<Integer, Set<Integer>> userFollowees;

    public Twitter() {
        tweetCount = 0;
        userTweets = new HashMap<>();
        userFollowees = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, id -> new ArrayList<int[]>())
            .add(new int[]{tweetCount++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        var result = new ArrayList<Integer>();
        var maxHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0], a[0]));
        // Add self as followee
        userFollowees.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        // Get the most recent tweets from all followees and add them to the heap.
        for(int followeeId: userFollowees.get(userId)) {
            if(userTweets.containsKey(followeeId)) {
                var tweets = userTweets.get(followeeId);
                var mostRecentTweet = tweets.get(tweets.size()-1);
                var mostRecentTweetCount = mostRecentTweet[0];
                var mostRecentTweetId = mostRecentTweet[1];
                // Followee Id and index are used to fetch the next most recent tweet, of current followee.
                maxHeap.add(new int[]{mostRecentTweetCount, mostRecentTweetId, followeeId, tweets.size()-1});
            }
        }
        
        while(!maxHeap.isEmpty() && result.size()<10) {
            var tweet = maxHeap.poll();
            var tweetId = tweet[1];
            result.add(tweetId);
            var tweetIndexInListOfTweets = tweet[3];
            if(tweetIndexInListOfTweets > 0) {
                var tweetFollowee = tweet[2];
                var nextTweetSameFollowee = userTweets.get(tweetFollowee).get(tweetIndexInListOfTweets-1);
                maxHeap.add(new int[]{nextTweetSameFollowee[0], nextTweetSameFollowee[1], tweet[2], tweetIndexInListOfTweets-1});
            }
        }
        return result;

    }
    
    public void follow(int followerId, int followeeId) {
        userFollowees.computeIfAbsent(followerId, id -> new HashSet<Integer>())
            .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        var followees = userFollowees.get(followerId);
        if(followees.contains(followeeId))
            followees.remove(followeeId);
    }
}
