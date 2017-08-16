package Design;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by Lin on 2017/8/16.
 */
public class DesignTwitter {

    /** @see <a href="https://leetcode.com/problems/design-twitter/">LeetCode</a> */

    Map<Integer, User> users;
    static int stamp = 0;
    final int MAX_SIZE = 10;
    Comparator<Tweet> comparator;

    public class User {

        private int userId;
        private Set<User> friends;
        private Queue<Tweet> tweets;

        public User(int userId) {
            this.userId = userId;
            friends = new HashSet<>();
            tweets = new PriorityQueue<>(MAX_SIZE ,comparator);
        }

        public int getUserId() { return userId; }
        public Set<User> getFriends() { return friends; }
        public Queue<Tweet> getTweets() { return tweets; }

        public void follow(User followee) {
            friends.add(followee);
        }

        public void unfollow(User followee) {
            friends.remove(followee);
        }

        public void postTweet(Tweet tweet) {
            tweets.offer(tweet);
            if(tweets.size() > MAX_SIZE) tweets.poll();
        }

        public List<Integer> getNewsFeed() {

            List<Integer> res = new ArrayList<>();
            Queue<Tweet> pq = new PriorityQueue<>(MAX_SIZE, comparator);

            // 遍历朋友的 tweet
            for(User friend: friends) {
                Queue<Tweet> friendTweets = new PriorityQueue<>(friend.getTweets());
                while(!friendTweets.isEmpty()) {
                    pq.offer(friendTweets.poll());
                    if(pq.size() > MAX_SIZE) pq.poll();
                }
            }

            // 遍历自己的 tweet
            Queue<Tweet> myTweets = new PriorityQueue<>(tweets);
            while(!myTweets.isEmpty()) {
                pq.offer(myTweets.poll());
                if(pq.size() > MAX_SIZE) pq.poll();
            }

            while(!pq.isEmpty()) res.add(pq.poll().getTweetId());
            Collections.reverse(res);

            return res;
        }
    }

    public class Tweet {

        private int tweetId;
        private User user;
        private int time;

        public Tweet(int tweetId, User user) {
            this.tweetId = tweetId;
            this.user = user;
            time = stamp++;
        }

        public int getTweetId() { return tweetId; }
        public User getUser() { return user; }
        public int getTime() { return time; }
    }

    /** Initialize your data structure here. */
    public DesignTwitter() {

        users = new HashMap<>();

        // 时间久远的 tweet 优先
        comparator = new Comparator<Tweet>(){
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.getTime() - o2.getTime();
            }
        };
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {

        User user = users.containsKey(userId) ? users.get(userId) : new User(userId);
        Tweet tweet = new Tweet(tweetId, user);

        users.put(userId, user);
        user.postTweet(tweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        if(!users.containsKey(userId)) return new ArrayList<>();

        User user = users.get(userId);
        return user.getNewsFeed();
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        if(followerId == followeeId) return;

        User follower = users.containsKey(followerId) ? users.get(followerId) : new User(followerId);
        User followee = users.containsKey(followeeId) ? users.get(followeeId) : new User(followeeId);

        users.put(followerId, follower);
        users.put(followeeId, followee);

        follower.follow(followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        if(followerId == followeeId) return;

        User follower = users.containsKey(followerId) ? users.get(followerId) : new User(followerId);
        User followee = users.containsKey(followeeId) ? users.get(followeeId) : new User(followeeId);

        users.put(followerId, follower);
        users.put(followeeId, followee);

        follower.unfollow(followee);
    }
}
