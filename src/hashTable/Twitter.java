package hashTable;
import java.util.*;
public class Twitter {
	class User{
		int id;
		Set<Integer> follow;//用户关注对象的id
		Tweet tweetHead;//用户最新的一条tweet
		
		User(int id){
			this.id=id;
			follow=new HashSet<>();
			follow.add(id);//自己关注自己
		}
		
		public void follow(int id){
			follow.add(id);
		}
		public void unfollow(int id){
			follow.remove(id);
		}
		public void post(int id){
			Tweet tweet=new Tweet(id);
			tweet.next=tweetHead;
			tweetHead=tweet;
		}
	}
	
	class Tweet{
		int id;
		int time;
		Tweet next;
		
		Tweet(int id){
			this.id=id;
			time=totalTime++;
		}
	}
	
	private static int totalTime=0;
	private HashMap<Integer, User> userMap;//通过id查找User
	
    /** Initialize your data structure here. */
    public Twitter() {
    	userMap=new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	if(!userMap.containsKey(userId)){
    		userMap.put(userId, new User(userId));
    	}
    	userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        
        PriorityQueue<Tweet> queue=new PriorityQueue<Tweet>(userMap.size(), new Comparator<Tweet>() {
        	public int compare(Tweet a,Tweet b){
        		return b.time-a.time;
        	}
		});
        for(int followid:userMap.get(userId).follow){
        	Tweet head=userMap.get(followid).tweetHead;
        	if(head!=null) queue.add(head);
        }
        int n=0;
        while(!queue.isEmpty()&&n<10){
        	Tweet tweet=queue.poll();
        	res.add(tweet.id);
        	n++;
        	if(tweet.next!=null) queue.add(tweet.next);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if(!userMap.containsKey(followerId)){
    		userMap.put(followerId, new User(followerId));
    	}
    	if(!userMap.containsKey(followeeId)){
    		userMap.put(followeeId, new User(followeeId));
    	}
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(!userMap.containsKey(followerId)||followerId==followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }

}
