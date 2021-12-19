<%@taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Setup date datasource  -->
<sql:setDataSource  var="ds" driver="oracle.jdbc.driver.OracleDriver"
                                  url="jdbc:oracle:thin:@localhost:1521:xe"
                                  user="system"
                                  password="manager"/>
<!-- Send and execute the SELECT SQL query -->
<sql:query var="rs"  dataSource="${ds}" sql="SELECT EMPNO,ENAME,JOB,SAL FROM EMP"/>

 <h1>  The records  are </h1>
<!-- Prcess the ResultSet obj -->
<table border="1" bgcolor="cyan" align="center" >
      <tr> <th> empno </th> <th> ename </th> <th>  job  </th> <th> salary </th> </tr>

  <c:forEach var="e"  items="${rs.rows}">
    <tr>
       <td> ${e.empno} </td>
       <td> ${e.ename} </td>
       <td> ${e.job} </td>
       <td> ${e.sal} </td>
    </tr>  
  </c:forEach>  
</table>         
                         
                                  