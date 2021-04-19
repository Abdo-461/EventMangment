

public class Job extends Post {
	//Instance variables	
	private double ProposedPrice;
	private double LowestOffer;
	
	        	
	//Instance variables to get unique post id
	private static int numberofposts = 00;
	private  String JpType;
	private  int postnumber;
	
	//Instance variables for reply
	private String replyid;
	private int replyvalue;
	private String responderid;

	//constructor
	public Job(String id, String title, String description, String creatorID, Status Status,double ProposedPrice ,double LowestOffer){
		// TODO Auto-generated constructor stub
		super(id,title,description,creatorID,Status);
		this.ProposedPrice = ProposedPrice;
		this.LowestOffer = LowestOffer;
		
		
	}
	
	//constructor for unique post id
	public Job(String JpType) {
		super();
		this.JpType = JpType;
		numberofposts += 1;
		postnumber = numberofposts;
	}
	
	//methods to get unique post id
	public  String getJPType() {
		return JpType;
	}
	public  int getJPostnumber() {
		return postnumber;
	}
	public String getJPostID() {
		
		String JPostID = getJPType() + getJPostnumber();
		return JPostID;	
	}
	
	
	//methods to get post details
	public double getProposedPrice() {
		return ProposedPrice;
	}
	
	public double getLowestoffer() {
		return LowestOffer;
	}
	
	//get unique post details
	public String getPostDetails() {
		
		String temp =
        "Porposed Price:"+"$"+ getProposedPrice() +"\n"+
        "Lowest Offer:" +"$"+ getLowestoffer()+ "\n";
        
        	return temp;
	}
	
	//methods to capture reply details
	public String getreplyid() {
		
		String replyid = getJPostID();
	
		return replyid;
	}

	public double getreplyvalue() {
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
				"Lowest Offer:" +" "+getreplyvalue()+ "\n"+
				"Responder:"+" "+getresponderid() + "\n"+
		
				"**Offer History**"+"\n"+getreplyvalue()+"\n"+
		
				"------------------------------------";
			return reply;
	}
	

	

	
	

}
