<%@ page  isELIgnored="false"  contentType="text/html; charset=UTF-8"   %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

  <fmt:setLocale value="fr_CA"/>

 <fmt:formatNumber var="salary" value="4500000"   type="currency"/>
  <b>Salary :: ${salary}</b>  <br>
  
  <fmt:formatNumber var="range" value="4500000.999"   type="number" 
                  maxFractionDigits="3"  maxIntegerDigits="10" minIntegerDigits="4"/>
 <b>ranage :: ${range}</b> <br>
 
  <fmt:formatNumber var="avg" value="4.5"   type="percent"/>
 <b>avg :: ${avg}</b>
 <br>
 <jsp:useBean id="dt" class="java.util.Date"/>
 <fmt:formatDate value="${dt}"  var="fdate"  type="both"  dateStyle="full" />
 <b> date and time :: ${fdate}</b>
 
 <fmt:setBundle basename="com/nt/commons/App"/>
 <fmt:message  var="message" key="welcome.msg"  />
 <br> <b>message is :: <b>${message}</b>
 
 
 