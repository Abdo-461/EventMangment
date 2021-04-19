import java.util.ArrayList;

public abstract class Post{

	//Instance variables	
	private String id;
	private String title;
	private String description;
	private String creatorID;
	private Status status;
	protected ArrayList<Reply> replies = new ArrayList<Reply>();

	//Constructor	
	public Post(String id, String title, String description , String creatorID , Status status ) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.creatorID = creatorID;
		this.status = Status.OPEN;
			
	}

	//Empty Constructor to call the super() constructor in sub classes
	public Post() {
		// TODO Auto-generated constructor stub
	}

	//method to get event details
	public String getPostID() {
		
		return id;
	}	
	public String getCreatorID() {
		return creatorID;
	}
	
	public Status getpostStatus() {
		return status;
	}
	
	public String getPostTitle() {
		return title;
	}
	
	public String getPostDescription() {
		return description;
		
	}
	
	public ArrayList<Reply> getReplies(){
		
		return replies;
	}
	
	public String getPostDetails() {
		
		String temp="";
		return temp;
		
	}
	//Abstract methods to handle reply on posts
	//Implemented differently in each subclass	
	public abstract boolean handleReply(Reply reply);
	
	public abstract String getReplyDetails();
	
	
}
