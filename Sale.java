

public class Sale extends Post {
	
	//Instance variables	
	private double askingPrice;
	private double highestOffer;
	private double minimumRaise;

	//instance variables to get unique post id
	private static int numberofposts = 00;
	private  String SpType;
	private  int postnumber;

		//Instance variables for reply
		private String replyid;
		private double replyvalue;
		private String responderid;

	//SalePost constructor	
	public Sale(String id, String title, String description, String creatorID, Status status,double askingPrice ,double highestOffer ,double minimumRaise){
		super(id,title,description,creatorID,status);
		// TODO Auto-generated constructor stub
		this.askingPrice = askingPrice;
		this.highestOffer = highestOffer;
		this.minimumRaise = minimumRaise;
	}

	
	//special constructor to create unique post ID
	public Sale(String SpType) {
		super();
		this.SpType = SpType;
		numberofposts += 1;
		postnumber = numberofposts;
	}
	
	public Sale(){
		
	}
	
	//create post id
	public  String getSPType() {
	return SpType;
	}
	public  int getSPostnumber() {
		return postnumber;
	}
	public String getSPostID() {
		
		String SPostID = getSPType() + getSPostnumber();
		return SPostID;
		
	}
	
	//methods to get sale details
	public double getAskingPrice() {
		return askingPrice;
	}
	
	public double getMinimum() {
		return minimumRaise;
	}
	
	public double getHighestoffer() {
		return highestOffer;
	}
	//get unique post details
	public String getPostDetails() {
		
		String temp =
				"Minimum Raise:" +"$"+ getMinimum() +"\n"+
				"Highest Offer:" +"$"+getHighestoffer()+"\n";
		return temp;
		
	}
	//methods to capture reply details
	public String getreplyid() {
		
		String replyid = getSPostID();
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
				"Highest Offer:" +" "+getreplyvalue()+ "\n"+
				"Responder:"+" "+getresponderid() + "\n"+
				
				"**Offer History**"+"\n"+getreplyvalue()+"\n"+
			
				"------------------------------------";	
			return reply;
		
		
	}

	



		
	
	
}
