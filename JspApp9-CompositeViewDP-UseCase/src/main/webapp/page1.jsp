<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    
<table border="0" cols="3" rows="3" width="100%" height="100%">
   <tr height="30%">
      <td colspan="3"><jsp:include page="headerurl"/> </td>
   </tr>
   <tr height="60%">
      <td width="20%"><%@include file="menu.html" %>  </td>
      <td width="50%">
        <pre><b>The Hindu is an English-language daily newspaper owned by The Hindu Group,
           headquartered in Chennai, Tamil Nadu, India. It was started as a
            weekly in 1878 and
            became a daily in 1889. It is one of the Indian newspapers of 
            record and the second most 
            circulated English-language newspaper in India, 
            after The Times of India. As of March 2018,
             The Hindu is published from 21 locations across 11 states. </b> </pre>
      </td>
      <td width="30%">
           <jsp:include page="weather.jsp"/>
      </td>
   </tr>
   <tr height="10%">
      <td colspan="3"><%@include file="footer.html" %> </td>
   </tr>
</table>    
