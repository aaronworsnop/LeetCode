class Twitter {
    private Map<Integer, User> userMap;
    private int users;
    private int timestamp;

    public Twitter() {
        this.userMap = new HashMap<>();
        this.users = 1;
        this.timestamp = Integer.MIN_VALUE;
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.tweet(new Tweet(user, tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        Set<User> possibleTweetUserOrigins = user.getFollowing();
        possibleTweetUserOrigins.add(user);

        PriorityQueue<Tweet> tweets = new PriorityQueue<>( (a, b) -> b.getTimestamp() - a.getTimestamp() );

        for (User tweeter : possibleTweetUserOrigins ) {
            for (Tweet tweet : tweeter.getTweets()) {
                tweets.offer(tweet);
            }
        }

        List<Integer> newsFeed = new ArrayList<>();
        while (!tweets.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(tweets.poll().getId());
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        User user = getUser(followerId);
        User followee = getUser(followeeId);
        user.follow(followee);
        followee.receiveFollow(user);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User user = getUser(followerId);
        User followee = getUser(followeeId);
        user.unfollow(followee);
        followee.receiveUnfollow(user);
    }

    private User getUser(int userId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        } 

        return userMap.get(userId);
    }

    private class User {
        private int id;

        private Set<User> followers;
        private Set<User> following;

        private Set<Tweet> tweets;

        public User(int id) {
            this.id = id;
            
            followers = new HashSet<>();
            following = new HashSet<>();

            tweets = new HashSet<>();
        }

        public int getId() {
            return id;
        }

        public void tweet(Tweet tweet) {
            tweets.add(tweet);
        }
        
        public Set<Tweet> getTweets() {
            return tweets;
        }

        public void follow(User user) {
            following.add(user);
        }

        public void unfollow(User user) {
            following.remove(user);
        }

        public void receiveFollow(User user) {
            followers.add(user);
        }

        public void receiveUnfollow(User user) {
            followers.remove(user);
        }

        public Set<User> getFollowing() {
            return following;
        }

        public Set<User> getFollowers() {
            return followers;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || !obj.getClass().equals(this.getClass())) {
                return false;
            }

            User otherUser = (User) obj;
            return this.id == otherUser.id;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }
    }

    private class Tweet {
        private User tweeter;
        private int id;
        private int timestamp;

        public Tweet(User tweeter, int id, int timestamp) {
            this.tweeter = tweeter;
            this.id = id;
            this.timestamp = timestamp;
        }

        public User getUser() {
            return tweeter;
        }

        public int getId() {
            return id;
        }

        public int getTimestamp() {
            return timestamp;
        }
    }
}
