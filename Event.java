

public class Event extends Post{
	
	//Instance variables	
	private String venue;
	private String date;
	private int capacity;
	private int attendees;
	private double attendeeCount;
	
	//Instance variables for reply
	private String replyid;
	private int replyvalue;
	private String responderid;
		
	//Instance variables to create unique post ID	
	private static int numberofposts = 00;
	private  String EpType;
	private  int postnumber;
	
	//constructor
	public Event(String id,String title,String description,String creatorID,Status status,String venue,String date ,int capacity ,int attendees){
		super(id, title,description,creatorID,status);
		// TODO Auto-generated constructor stub
		this.venue = venue;
		this.date = date;
		this.capacity = capacity;
		this.attendees = attendees;
		
	}
	
	//special constructor to create unique post ID
	public Event(String EpType) {
		super();
		this.EpType = EpType;
		numberofposts += 1;
		postnumber = numberofposts;	
	}
	
	//methods for creating and getting unique ID
	public  String getEPType() {
		return EpType;
	}
	public  int getEPostnumber() {
		return postnumber;
	}
	public String getEPostID() {
		
		String EPostID = getEPType() + getEPostnumber();
		
		return EPostID;	
	}
	
	
	//methods get event details
	public String getEventVenue() {
		return venue;
	}
	public String getEventDate() {
		return date;	
	}
	
	public int getAttendees() {
		return attendees;
	}
	
	public int getEventCapacity() {
		return capacity;
	}

	public double getAttendeeCount() {
		
		int counter = 0;
		attendeeCount = counter ++;
		
		return attendeeCount;
		
	}
	//get event post details
    public String getPostDetails() {
		
    	String temp =
		    "Venue:"+ " "+getEventVenue() + "\n"+
			"Date:"+ " "+getEventDate()+"\n" +
			"Capacity:"+ " "+getEventCapacity()+"\n" +
			"Attendees:"+ " "+getAttendees() +"\n";
		return temp;
		}
	
	
    //methods to get reply information
	public String getreplyid() {
		
		String replyid = getEPostID();
		
		return replyid;
	}
	
	public int getreplyvalue() {
		return replyvalue;
	}
	public String getresponderid() {
		return responderid;
	}
	
		
	//Overridden methods to handle and get reply
	@Override
	public boolean handleReply(Reply reply) {
		// TODO Auto-generated method stub	
		
		replies.add(new Reply(replyid,replyvalue,responderid));
		
		return true;
		
	}
	
	@Override
	public String getReplyDetails() {
		// TODO Auto-generated method stub
	String reply = 
			"**Replies**" +"\n"+
			"Post:"+" "+getreplyid() + "\n"+
			"Value:" +" "+getreplyvalue()+ "\n"+
			"Responder:"+" "+getresponderid() + "\n"+
			"------------------------------------";
			
		return reply;
	}
		

		
		
}
