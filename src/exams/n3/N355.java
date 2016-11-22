package exams.n3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class N355 {

	public static void main(String[] args) {
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		System.out.println(twitter.getNewsFeed(1));

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println(twitter.getNewsFeed(1));

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		System.out.println(twitter.getNewsFeed(1));
	}

}

class Twitter {
	class Item {
		List<Msg> posted = new ArrayList<Msg>();
		Set<Integer> follower = new HashSet<Integer>();
	};
	static class Msg {
		int id;
		int msg;

		public static Msg create(int msg) {
			Msg m = new Msg();
			m.msg = msg;
			m.id = idx++;

			return m;
		}
	};

	private static int idx = 0;
	private Map<Integer, Item> data = new HashMap<Integer, Item>();

	/** Initialize your data structure here. */
	public Twitter() {

	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if(!data.containsKey(userId)) {
			Item item = new Item();
			data.put(userId, item);
		}

		data.get(userId).posted.add(Msg.create(tweetId));
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
		List<Msg> results = new ArrayList<Msg>();
		Item item = data.get(userId);
		if(item != null) {
			results.addAll(item.posted);
			for(int id: item.follower) {
				if(data.containsKey(id)) {
					results.addAll(data.get(id).posted);
				}
			}
		}
		Collections.sort(results, new Comparator<Msg>(){

			@Override
			public int compare(Msg arg0, Msg arg1) {
				return (arg0.id > arg1.id)?-1:((arg0.id == arg1.id)?0:1);
			}});
		List<Integer> ret = new ArrayList<Integer>();
		int count = 0;
		for(Msg m: results)  {
			if(count >= 10) break;
			count++;
			ret.add(m.msg);
		}

		return ret;
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		if(followerId == followeeId) return;
		if(data.containsKey(followerId) /*&& data.containsKey(followeeId)*/) {
			data.get(followerId).follower.add(followeeId);
		} else {
			Item item = new Item();
			item.follower.add(followeeId);
			data.put(followerId, item);
		}
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		if(data.containsKey(followerId) /*&& data.containsKey(followeeId)*/) {
			data.get(followerId).follower.remove(followeeId);
		}
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */