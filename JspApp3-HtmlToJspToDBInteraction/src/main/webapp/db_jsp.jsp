<%@ page import="java.sql.*"  %>


<%!
  Connection con=null;
  PreparedStatement ps1=null;
  PreparedStatement ps2=null;
  private static final String  INSERT_QUERY="INSERT INTO JSP_PERSON_INFO VALUES(PID1_SEQ.NEXTVAL,?,?,?,?)";
  private static final String  SELECT_QUERY="SELECT PID,PNAME,PAGE,PADD,EMAILID FROM  JSP_PERSON_INFO";
  
public void jspInit(){
	//get SErvletconfig  object directly
	ServletConfig cg=getServletConfig();
	//read init param values  (jdbc properties)
	String driver=cg.getInitParameter("driverClass");
	String url=cg.getInitParameter("jdbcurl");
	String user=cg.getInitParameter("dbuser");
	String pwd=cg.getInitParameter("dbpwd");
	try{
		//Load jdbc driver class
		Class.forName(driver);
		//establish the connection
		con=DriverManager.getConnection(url, user, pwd);
		//create PreparedStatement objs
		ps1=con.prepareStatement(SELECT_QUERY);
		ps2=con.prepareStatement(INSERT_QUERY);
	}///try
	catch(SQLException se){
		se.printStackTrace();
	}
	catch(Exception e){
		e.printStackTrace();
	}
   }  %>
<%
    //read addtional  req param value
    String pval=request.getParameter("p1");
   if(pval.equalsIgnoreCase("register")){  //for submit button
	      //read form data
	     String name=request.getParameter("pname");
		 int age=Integer.parseInt(request.getParameter("page"));
		   String addrs=request.getParameter("paddrs");
		   String mail=request.getParameter("mailId");
        //set values to query params (?)		  
        ps2.setString(1,name);
        ps2.setInt(2,age);
        ps2.setString(3,mail);
        ps2.setString(4,addrs);
        
        //execute the query
        int result=ps2.executeUpdate();
        //process the results
        if(result==0){ %>
<h1 style="color: red; text-align: center">Record not inserted</h1>
<% }
        else{ %>
<h1 style="color: red; text-align: center">Record inserted</h1>
<%   }//else 
   }//if
   else{
	    //execute Query
	    ResultSet rs=ps1.executeQuery();  %>
<table border="1" bgcolor="cyan"  align="center">
	<tr>
		<th>Pid</th>
		<th>Name</th>
		<th>Age</th>
		<th>Addrs</th>
		<th>email</th>
	</tr>

	<%
	    //process the Result  
	    while(rs.next()){ %>
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getInt(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
	</tr>
	<%}//while
    	  %>
</table>
<%    }//else
		 %>
 <center> <a href="person_form.html">home</a></center>		 
		 


<%!public void jspDestroy(){
	   try{
            //close jdbc obks
            if(ps1!=null)
            	ps1.close();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   
   
       try{
       if(ps2!=null){
       	ps2.close();
   }
       }//try
   catch(SQLException e){
	   e.printStackTrace();
   }
	   
	   try{
           //close jdbc obks
           if(con!=null)
           	con.close();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
   }//jspDestroy() method
   %>