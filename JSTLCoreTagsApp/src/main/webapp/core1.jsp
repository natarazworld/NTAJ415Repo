
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!-- To create data in scope -->
<c:set var="msg"  value="hello"  scope="session"/>
<!--  To display data collecting from scope -->
<b>msg value::</b><c:out value="${msg}" /> <br>
<!-- To remove data from scope -->
<c:remove var="msg"/>
<!--  To display data collecting from scope -->
<b>msg value::</b> <c:out value="${msg}" />



