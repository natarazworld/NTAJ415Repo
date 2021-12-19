<%@ page  isELIgnored="false"  contentType="text/html; charset=UTF-8"   %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>

<c:set var="msg"  value="welcome to  JSTL" scope="request"/>

 content ::  ${msg } <br>
 uppercase ::  ${fn:toUpperCase(msg)}<br>
 lowercase ::  ${fn:toLowerCase(msg)}<br>
 subString ::  ${fn:substring(msg,0,7) } <br>
 subString After ::  ${fn:substringAfter(msg, "to") } <br>
 



