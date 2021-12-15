
<%@page  import="com.nt.beans.*" %>


<!-- Locate /create Java bean class obj -->
<jsp:useBean id="st" class="com.nt.beans.StudentInfo"  scope="session"/>

 <!-- Read and display values -->
 <b> sno =  </b> <jsp:getProperty name="st" property="sno"/> <br>
 <b> sname =  </b> <jsp:getProperty name="st" property="sname"/> <br>
 <b> sadd =  </b> <jsp:getProperty name="st" property="sadd"/> <br>
 <b> avg =  </b> <jsp:getProperty name="st" property="avg"/> <br>
 
 <b> Value are read from Java bean class obj and displayed</b>
  
