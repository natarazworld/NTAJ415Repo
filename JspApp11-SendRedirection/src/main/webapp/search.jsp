


<%
//reaad req param vlaues
 String ss=request.getParameter("ss");

//perform sendRedirection
response.sendRedirect("https://www.google.com/search?q="+ss);


%>