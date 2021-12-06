

 <!-- read and display pageContext attribute value  -->
 <b> from b.jsp </b>
 <b> attr1 (page scope) value :: <%=pageContext.findAttribute("attr1") %> </b> <br>
 <b> attr2 (req scope) value :: <%=pageContext.findAttribute("attr2") %> </b> <br>
 <b> attr3 (session scope) value :: <%=pageContext.findAttribute("attr3") %> </b> <br>
 <b> attr4 (application scope) value :: <%=pageContext.findAttribute("attr4") %> </b> <br>
   

   <jsp:forDward page="c.jsp"/>