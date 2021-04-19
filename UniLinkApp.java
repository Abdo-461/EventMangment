import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UniLinkApp {
	
    
	//get student user name during sign in
	String studentUsername;
	//get choice from user to login or quite menu
	int uniLinkMenu;
	//get choice from user to access student menu 
	int studentmenu;
	

     //Variables that captures user input
	
     //variables for event
	 String eId ;
	 String eTitle;
	 String eDescription ;
	 String eCreatorID ;
	 Status eStatus ;
	 ArrayList<Reply> EReplies ;
	 int eCapacity ;
	 String eVenue ;
	 String eDate ;
	 int eAttendee ;
	 
	 //variables for sale
	 String sId; 
	 String sTitle ;
	 String sDescription ;
	 String sCreatorID ;
	 Status sStatus ;
	 ArrayList<Reply> sReplies ;
	 double sAskingprice ;
	 double sMinimumraise ;
	 double sHighestoffer ;
	 
	 //variables for job
	 String jId ;
	 String jTitle ;
	 String jDescription ;
	 String jCreatorID ;
	 Status jStatus ;
	 String jReplies ;
	 double jProposedprice ;
	 double jLowestoffer ;
	 
	 //static scanner to get all inputs from user
	 static Scanner  Userinput = new Scanner(System.in).useDelimiter("\n");
	 
	 //Array List to store 3 types of posts
	 ArrayList<Post> post = new ArrayList<Post>();
		 
	//existing 3 types posts build in array
	 Post[] postt = new Post[3];{
		 postt[0] = new Event("EVE008" ,"Road Trip","Trip to Geelong","S8",eStatus,"In the Van","12/11/2020",20,0);
		 postt[1] = new Sale ("SAL008","AC/DC tickets","2 Tickets to see a concert","S8",sStatus,200,130,20);
		 postt[2] = new Job  ("JOB008","Moving house furniture","Need a hand to move my stuff","S8",jStatus,100,80);	  	 
	 } 
	 
	//constructor for unilink class
	public UniLinkApp() {
			
	}
	//Validate integer input
	public static int validateIntinput() {
		
		int integer;
		
		while(!Userinput.hasNextInt()) { 
			System.out.println("enter valid number");
			Userinput.nextLine();
		}
		 integer = Userinput.nextInt();
		
		return integer;
		
	}
	
	//validate string input
	public static String  validateStringinput() {
			Pattern pattern = Pattern.compile("[a-zA-Z0-9\\s]+\\b(?=\\s[^a-zA-Z0-9]*)");  
			String string =" ";
			
		do{	
			while(!Userinput.hasNext(pattern)) {
				System.out.println("enter valid word");
				Userinput.next();
			}	
			string += Userinput.next();
			
			if(string.isEmpty()) System.out.println("cannot be empty");
		}while(string.isEmpty());
			
			
			return string;
	 }
	
	public static String validateDate() {
		
		Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
		String date;
		
		do {
			while(!Userinput.hasNext(pattern)) {
				System.out.println("enter valid date");
				Userinput.next();
				
			}
			date = Userinput.next();
			if(date.isEmpty()) System.out.println("cannot be empty");
		}while(date.isEmpty());
		
		return date;
	}
		
	//create an event post function
	public void createevent() {	
		
		System.out.println("Enter details of the event below");
		
		System.out.println("Title");
		eTitle = validateStringinput(); 
		
		System.out.println("Descritpion:");
		eDescription = validateStringinput();
			
		System.out.println("Event venue:");
		eVenue = validateStringinput();
			
		System.out.println("Event Date(dd/mm/yyyy):");
		eDate = validateDate();
			
		System.out.println("Event Capacity:");
		eCapacity = validateIntinput();
	
		  Event Epost = new Event("EVE00");
		  eId = Epost.getEPostID();
		  
	 
		  
		  eCreatorID = studentUsername;
		  System.out.println("Success! Your event has been created with id:" +Epost.getEPostID());
		  
		  post.add(new Event(eId ,eTitle,eDescription,eCreatorID,eStatus,eVenue,eDate,eCapacity,eAttendee));
		}
	
	//create sale post function
	public void createsale() {
		
		System.out.println("Enter details of the sale below");
		
		System.out.println("Title");
		sTitle = validateStringinput(); 
		
		System.out.println("Descritpion:");
		sDescription = validateStringinput();
			
		System.out.println("Asking price:");
		sAskingprice = validateIntinput();
		
		System.out.println("Minimum Raise:");
		sMinimumraise = validateIntinput();
				  		 				 	  
		 Sale Spost = new Sale("SAL00");
		 sId = Spost.getSPostID();
		 
		 sCreatorID = studentUsername;
	     System.out.println("Success! Your sale has been created with id:" +Spost.getSPostID());
	     
	     post.add(new Sale(sId,sTitle,sDescription,sCreatorID,sStatus,sAskingprice,sHighestoffer,sMinimumraise));
	}
	
	//create job post function
	public void createjob() {
		
		System.out.println("Enter details of the job below");
		
		System.out.println("Title");
		jTitle = validateStringinput(); 
		
		System.out.println("Descritpion:");
		jDescription = validateStringinput();
		  
		  
		System.out.println("Proposed Price:");
		jProposedprice = validateIntinput();	
		
		System.out.println("Lowest Offer:");
		jLowestoffer = validateIntinput();
		
				
		 Job Jpost = new Job("JOB00");
		 jId = Jpost.getJPostID();
		 
		 jCreatorID = studentUsername;
		 System.out.println("Success! Your job has been created with id:" +Jpost.getJPostID());
		 
		 post.add(new Job(jId,jTitle,jDescription,jCreatorID,jStatus,jProposedprice,jLowestoffer));
	}
	

	//instance variables for reply
	int ereplyvalue = 0;
	String ereplyID;
	String eresponderID;
	
	int sreplyvalue = 0;
	String sreplyID;
	String sresponderID;
	
	int jreplyvalue = 0;
	String jreplyID;
	String jresponderID;
	
	//reply to post function, can reply to posts hard coded in the system
	public void replypost() {
			
		String post;
		System.out.println("Enter the post you want to reply to");
		post = Userinput.next();
	
		for(int i=0; i < postt.length ; i++) {
			
			if(post.equals(postt[i].getPostID())){
				
				if(postt[i] instanceof Event) {	
					ereplyID = post;
					eresponderID = studentUsername;
					
					System.out.println("Are you attending?(1.y/2.n):");
					ereplyvalue = validateIntinput();
						if(ereplyvalue == 1) {
						System.out.println("Waiting for you!");	
							
							for(Post replies: postt) {
								Reply ereply = new Reply(ereplyID,ereplyvalue,eresponderID);
								replies.handleReply(ereply);
							}							
						}
						else {
							for(Post replies: postt) {
								Reply ereply = new Reply(ereplyID,ereplyvalue,eresponderID);
								replies.handleReply(ereply);
								}	
							System.out.println("So sad");
						}
					}
		
				else if(postt[i] instanceof Sale) {	
			    	sreplyID = post;
					sresponderID = studentUsername;
			    	
					System.out.println("Whats your Highest Offer?");
					sreplyvalue = validateIntinput();
						if(sreplyvalue > ((Sale)postt[i]).getHighestoffer()) {
							System.out.println("Offer Accepted.Item Sold to you!");	
							
								for(Post replies: postt) {
								Reply sreply = new Reply(sreplyID,sreplyvalue,sresponderID);
								replies.handleReply(sreply);
							}
							
							
						}
							else {
								for(Post replies: postt) {	
									Reply sreply = new Reply(sreplyID,sreplyvalue,sresponderID);
									replies.handleReply(sreply);
									}
								System.out.println("Offer Rejected");
								}
							}
	
				else if(postt[i] instanceof Job) {	
			    	jreplyID = post;
					jresponderID = studentUsername;
			    	
					System.out.println("Whats your Lowest Offer?");
					jreplyvalue = validateIntinput();
			    		
								if(jreplyvalue < ((Job)postt[i]).getProposedPrice()) {
									System.out.println("Job is yours mate!");	
									
									for(Post replies: postt) {
										
										Reply jreply = new Reply(jreplyID,jreplyvalue,jresponderID);
										replies.handleReply(jreply);
									}
								}
								
								else {
										for(Post replies: postt) {	
										Reply jreply = new Reply(jreplyID,jreplyvalue,jresponderID);
										replies.handleReply(jreply);
										}
									System.out.println("Offer too low,reply recorded");
								}
							}	
						}
			else{
				System.out.println("Post not found");
			}
			
			
			}
		
	}
		
	//deletes a post hard coded in the system
	public void deletepost() {
		System.out.println("Enter ID of post you would like to delete:");
		String post = Userinput.next();
	
		for(int i=0; i<postt.length; i++) {
			if(post.equals(postt[i].getPostID())) {
				if(postt[i] instanceof Event) {
				
					 if (studentUsername.equals(postt[i].getCreatorID())){
						 
						 for(i = 0; i < postt.length; i++){
				            if(post.equals(postt[i].getPostID())){
				                
				                for(int j = i; j < postt.length - 1; j++){
				                	postt[j] = postt[j+1];
				                	System.out.println("Post Deleted!");
				                }
				                break;
				            }
				        }	
					}
					 else {
						 System.out.println("Sorry, You don't own the post!");
						}
					}
					
				if(postt[i] instanceof Sale) {
						
						if(studentUsername.equals(postt[i].getCreatorID())) {	
					
							for(i = 0; i < postt.length; i++){
								if(post.equals(postt[i].getPostID())){
			                
									for(int j = i; j < postt.length - 1; j++){
										postt[j] = postt[j+1];
										System.out.println("Post Deleted!");
									}
									break;
									}
								} 	
							}
						else {
							System.out.println("Sorry, You don't own the post!");
				 		}	
					}
				
				if (postt[i] instanceof Job) {
					
					if(studentUsername.equals(postt[i].getCreatorID())) {	
				
						for(i = 0; i < postt.length; i++){
							if(post.equals(postt[i].getPostID())){
		                
								for(int j = i; j < postt.length - 1; j++){
									postt[j] = postt[j+1];
									System.out.println("Post Deleted!");
								}
								break;
								}
							} 	
						}
					
					else {
						System.out.println("Sorry, You don't own the post!");
			 		}	
				}
					
		}
			else {
				System.out.println("Post not found");
			}
		}
	}
	
	//close post function
	public void closepost() {
		
			@SuppressWarnings("unused")
			String closepost;
			
			System.out.println("Enter ID of post you would like to close:");
			closepost = Userinput.next();
			
			for(Post mypost: post ) 
			 if(studentUsername.equals(mypost.getCreatorID())) {
			
				 @SuppressWarnings("unused")
				Status poststatus = Status.CLOSE;
				 System.out.println("Post Close!"); 
			 }
			 else {
				 System.out.println("You cannot close this post! You are not the owner!");
			 }
	}		
	
	//display my post function
	public void displaymypost() {	
	
	//display specific data to users who has posts ALREADY in the system, for reply function
	for(int i=0; i < postt.length ; i++) {
			
	 if(studentUsername.equals(postt[i].getCreatorID())) {
		 
			if(postt[i] instanceof Event) {	
				System.out.println("ID:"+" "+postt[i].getPostID());
				System.out.println("Title:"+" "+postt[i].getPostTitle());
				System.out.println("Description:" +" "+postt[i].getPostDescription());
				System.out.println("Creator ID:"+" "+postt[i].getCreatorID());
				System.out.println("Status:"+" "+postt[i].getpostStatus());
				System.out.println(postt[i].getPostDetails());
				
				System.out.println(postt[i].getReplyDetails());
			}	 
			if(postt[i] instanceof Sale) {	
				System.out.println("ID:"+" "+postt[i].getPostID());
				System.out.println("Title:"+" "+postt[i].getPostTitle());
				System.out.println("Description:" +" "+postt[i].getPostDescription());
				System.out.println("Creator ID:"+" "+postt[i].getCreatorID());
				System.out.println("Status:"+" "+postt[i].getpostStatus());
				System.out.println(postt[i].getPostDetails());
				
				System.out.println(postt[i].getReplyDetails());
			} 		
			if(postt[i] instanceof Job) {
				System.out.println("ID:"+" "+postt[i].getPostID());
				System.out.println("Title:"+" "+postt[i].getPostTitle());
				System.out.println("Description:" +" "+postt[i].getPostDescription());
				System.out.println("Creator ID:"+" "+postt[i].getCreatorID());
				System.out.println("Status:"+" "+postt[i].getpostStatus());
				System.out.println(postt[i].getPostDetails());
				
				System.out.println(postt[i].getReplyDetails());
				}	
			}
	 else {
		 System.out.println("You dont have a post!");
	 	}
	}
		
	System.out.println("-----------------------------------");
		//display specific posts of users who entered their data through the console
		for(Post displaypost: post) {
			if(studentUsername.equals(displaypost.getCreatorID())) { 
				
					  System.out.println("ID:"+" "+displaypost.getPostID());
					  System.out.println("Title:"+" " +displaypost.getPostTitle());
					  System.out.println("Description:"+" "+displaypost.getPostDescription());
					  System.out.println("CreatorID:"+" " +displaypost.getCreatorID());
					  System.out.println("Status:"+" " +displaypost.getpostStatus());
					  System.out.println(displaypost.getPostDetails());
				}	 	
			
			}
		}
	
	//display all post function
	public void displayallpost() {
	
		//default posts hard coded into system
		for(int i=0; i<postt.length; i++) {
			 
			if(postt[i] instanceof Event) {	
				
				System.out.println("ID:"+" "+postt[i].getPostID());
				System.out.println("Title:"+" "+postt[i].getPostTitle());
				System.out.println("Description:" +" "+postt[i].getPostDescription());
				System.out.println("Creator ID:"+" "+postt[i].getCreatorID());
				System.out.println("Status:"+" "+postt[i].getpostStatus());
				System.out.println(postt[i].getPostDetails());
				
			}
			if(postt[i] instanceof Sale) {	
		
				System.out.println("ID:"+" "+postt[i].getPostID());
				System.out.println("Title:"+" "+postt[i].getPostTitle());
				System.out.println("Description:" +" "+postt[i].getPostDescription());
				System.out.println("Creator ID:"+" "+postt[i].getCreatorID());
				System.out.println("Status:"+" "+postt[i].getpostStatus());
				System.out.println(postt[i].getPostDetails());
				
			}
			if(postt[i] instanceof Job) {	
	   
				System.out.println("ID:"+" "+postt[i].getPostID());
				System.out.println("Title:"+" "+postt[i].getPostTitle());
				System.out.println("Description:" +" "+postt[i].getPostDescription());
				System.out.println("Creator ID:"+" "+postt[i].getCreatorID());
				System.out.println("Status:"+" "+postt[i].getpostStatus());
				System.out.println(postt[i].getPostDetails());
							
				}	
			
		}
		
	System.out.println("-----------------------------------");	

		//create  new posts according to user's choice
		 for(Post displaypost: post) {
			 
			  System.out.println("ID:"+" "+displaypost.getPostID());
			  System.out.println("Title:"+" " +displaypost.getPostTitle());
			  System.out.println("Description:"+" "+displaypost.getPostDescription());
			  System.out.println("CreatorID:"+" " +displaypost.getCreatorID());
			  System.out.println("Status:"+" " +displaypost.getpostStatus());
			  System.out.println(displaypost.getPostDetails());	  
		}	
	}
	
	//student menu to prompt user for action
	public void startmenu() {
		    System.out.println("Welcome:"  +studentUsername+ "!" );
		    System.out.println("***Student Menu***");
		    System.out.println("1.New Event Post"); 
		    System.out.println("2.New Sale Post");  
		    System.out.println("3.New Job Post");   
		    System.out.println("4.Reply to Post");  
		    System.out.println("5.Display My Post"); 
		    System.out.println("6.Display All Post"); 
		    System.out.println("7.Close Post"); //In progress
		    System.out.println("8.Delete Post"); 
		    System.out.println("9.Log Out"); 
		    System.out.println("Enter your choice:");
		    studentmenu = validateIntinput();
	}
	
	//welcome page for the user
	public void welcomepage() {	
		System.out.println("***UniLink System***");
		System.out.println("1.Log in");
		System.out.println("2.Quit");
		
		System.out.println("Enter your choice:");
		uniLinkMenu = validateIntinput();
			 
	}
	//sign in page should the user choose to sign in
	boolean flag;
	public void signinpage() {
		
		do{
			String standardusername = "S\\d{1}";
			System.out.println("Enter Username:");
			studentUsername = Userinput.next();
			Userinput.nextLine();
			flag = studentUsername.matches(standardusername);
		
			if (!flag) System.out.println("please enter an 'S' followed by 1 numbers");
		}	while(!flag);
		
	}
		
		
	//main function of the program
	public void start() {
		
		do {	
		  welcomepage();
	       //to help do statement perform different actions according to user input
			if(uniLinkMenu == 1) {
				signinpage();
			}
			do {  
				switch(uniLinkMenu) {
				 case 1:
					startmenu();
						switch(studentmenu){
							 case 1 : 
								 createevent();
						   break;
							 case 2 :
								 createsale();
						   break;
							 case 3 :	 
								 createjob();
						   break;
							 case 4 :
								 replypost(); 
						   break;	 
							 case 5 :
							     displaymypost();	 
						   break;
							 case 6 :
								 displayallpost(); 
						   break;
							 case 7:
								 closepost(); //unimplemented
						   break;	 
							 case 8:
								 deletepost(); 
						   break;	 
							 case 9:
								 System.out.println("You have successfully logged out");
							}	
						   break;
				  case 2: System.out.print("Thank you for using UniLink!");
				  	break;
	         default : System.out.print("Please enter a valid choice!");		
				}
	 		
	 		}while (studentmenu !=9);
	 
		}while (uniLinkMenu !=2);
	}	
}

