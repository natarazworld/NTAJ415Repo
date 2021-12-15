<%@ page  import="com.nt.beans.*, com.nt.service.*"%>

<!-- create/Locate Java bean class object -->
<jsp:useBean id="emp"  class="com.nt.beans.Employee"  scope="request"/>

<!-- Write form data to Java bean class object -->
<jsp:setProperty name="emp" property="*" />

<!-- Create/Locate  Service class object -->
<jsp:useBean id="service" class="com.nt.service.PaySlipGeneratorService" scope="application"/>

<!--  invoke b.method -->
<%
     service.generatePaySlip(emp);
%>

<!-- Read the inputs and results from Java bean class obj and display on the browser -->
   <h1 style="color:red;text-align:center"> Employee paySlip Report</h1>
 <table align="center"  bgcolor="cyan"  border="1">
   <tr>
       <td> emp name: </td>
       <td> <jsp:getProperty property="ename" name="emp"/>  </td>
   </tr>
   <tr>
       <td> emp address: </td>
       <td> <jsp:getProperty property="eadd" name="emp"/>  </td>
   </tr>
   <tr>
       <td> emp basicSalary: </td>
       <td> <jsp:getProperty property="basicSalary" name="emp"/>  </td>
   </tr>
   <tr>
       <td> emp grossSalary: </td>
       <td> <jsp:getProperty property="grossSalary" name="emp"/>  </td>
   </tr>
   <tr>
       <td> emp netSalary: </td>
       <td> <jsp:getProperty property="netSalary" name="emp"/>  </td>
   </tr>
 </table>

<br><br> <a href="emp_details.html">home</a>


