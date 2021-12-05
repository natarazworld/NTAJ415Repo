

<b>  start of a.jsp </b> <br>
 <br>
   <% float price= 500 + 500*0.1f; %>
   <jsp:forward page="b.jsp">
      <jsp:param  name="bookName"  value="CRJ"/>
      <jsp:param  name="cost"  value="<%=price%>"/>
   </jsp:forward>
   <br>
 <b> end of a.jsp</b>    <br>