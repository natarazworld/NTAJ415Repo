<%@ page  isELIgnored="false" %>

<%
  pageContext.setAttribute("attr1","val1");
  pageContext.setAttribute("attr2","val2",PageContext.REQUEST_SCOPE);
  pageContext.setAttribute("attr3","val3",PageContext.SESSION_SCOPE);
  pageContext.setAttribute("attr4","val4",PageContext.APPLICATION_SCOPE);
%>

<jsp:forward page="read_data.jsp"/>

