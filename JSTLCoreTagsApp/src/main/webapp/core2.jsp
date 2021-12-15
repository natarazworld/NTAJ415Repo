
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<c:set var="msg"  value="welcome"/>

<c:if test="${param.uname ne null}" >
 <h1 style="color:red;text-align:center">   
      <c:out value="${msg}"/>  <c:out value="${param.uname}"/>
   </h1>
</c:if>

<h1 style="color:blue;text-align: center"> Hi to Every One </h1>


