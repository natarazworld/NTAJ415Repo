
<b>  from a.jsp </b>
<%
//create all the 4 scopes of attributes
 //page scope
 pageContext.setAttribute("attr1","val1");
//request scope
pageContext.setAttribute("attr2","val2",pageContext.REQUEST_SCOPE);
//session scope
pageContext.setAttribute("attr3","val3",pageContext.SESSION_SCOPE);
//application scope
pageContext.setAttribute("attr4","val4",pageContext.APPLICATION_SCOPE);

%> 

<jsp:forward page="b.jsp"/>