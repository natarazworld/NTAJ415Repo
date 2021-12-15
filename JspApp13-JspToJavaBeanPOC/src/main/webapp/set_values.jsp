<%@ page import="com.nt.beans.*" %>


<!-- create or Locate java bean class obj -->
  <jsp:useBean id="st" class="com.nt.beans.StudentInfo"  scope="session"/>
  
  <!-- set values to bean properties   -->
 <%--  <jsp:setProperty name="st"  property="sno"  value="1001"/>
  <jsp:setProperty name="st"  property="sname"  value="rakesh"/>
  <jsp:setProperty name="st"  property="sadd"  value="vizag"/>
  <jsp:setProperty name="st"  property="avg"  value="90.77f"/>
   --%>
   <!-- setting form data as the java bean property values -->
  <%--    <jsp:setProperty name="st"  property="sno"  param="stno"/>
     <jsp:setProperty name="st"  property="sname"  param="stname"/>
     <jsp:setProperty name="st"  property="sadd"  param="stadd"/>
     <jsp:setProperty name="st"  property="avg"  param="stavg"/> --%>
  <b> values/req param values are set Java bean properties</b>
  
  <!-- setting form data as Java bean property values use property="*" symbol
       if req param names are matching with java bean class obj property name
    -->
      <jsp:setProperty name="st"  property="*"/>
  
  