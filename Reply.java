
public class Reply{
	
	//Instance variables of reply
	private String ReplyID;
	private double ReplyValue;
	private String ResponderID;
	
	//constructor
	public Reply(String ReplyID, double ReplyValue , String ResponderID) {
		
		this.ReplyID = ReplyID;
		this.ReplyValue = ReplyValue;
		this.ResponderID = ResponderID;
		
	}
	
	//Accessor methods of reply
	public String getReplyID() {
		return ReplyID;
	}
	
	public double getReplyValue() {
		return ReplyValue;
	}
	
	public String getResponderID() {
		return ResponderID;
	}

	
}
