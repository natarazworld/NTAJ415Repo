
<%!  public   String  generateWishMessage(String user){
	     //int a=10;
	//get System date and time
	  java.time.LocalDateTime ldt=java.time.LocalDateTime.now();
	// get current hour of the day
	    int hour=ldt.getHour();
	 //generate wish Message
	  if(hour<12)
		   return "Good Morning::"+user;
	  else if(hour<16)
		  return "Good AfterNoon ::"+user;
	  else if(hour<20)
		  return "Good Evening ::"+user;
	  else 
		  return "Good Night ::"+user;
}
%>

  <!-- <h1 style="color:red;text-align:center">  Welcome to  Java server Pages  </h1>  
<br>
<h1 style="color:green"> Date and  time is :: <!--    <%=new  java.util.Date() %>   --> </h1> 
<%   String  name="raja";  %>
<%-- <br>  <b> The wish message is :: <%=generateWishMessage(name) %> </b> --%>





