<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@page isELIgnored="false" %>

<c:choose>
   <c:when test="${!empty empDetails}">
        <h1> Employees Details Belonging to ${param.job}</h1>
        <table border="1" align="center" bgcolor="cyan">
        <tr><th> empno </th> <th> emp name </th> <th> desg </th> <th> salary </th><th> grossSalary </th> <th> netSalary </th> </tr>
         <c:forEach  var="emp" items="${empDetails}">
           <tr>
             <td>${emp.eno}  </td>
             <td>${emp.ename}  </td>
             <td>${emp.desg}  </td>
             <td>${emp.salary}  </td>
             <td>${emp.grossSalary}  </td>
             <td>${emp.netSalary}  </td>
           </tr>
         </c:forEach>
        </table>   
   </c:when>
    <c:otherwise>
            <h1 style="color:red;text-align:center"> Employees  Not found </h1>
    </c:otherwise>
</c:choose>


<br><br>
 <center> <a href="JavaScript:showPrint()">print</a></center>
  
  <script  language="JavaScript">
     function showPrint(){
      frames.focus();
      frames.print();
    }
</script>     
  

