
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>


  <c:set var="msg"  value=" hello, how are u ?" scope="request"/>
  
  <c:forTokens  var="token"  items="${msg}"  delims=" ">
        ${token} <br>
  </c:forTokens>





