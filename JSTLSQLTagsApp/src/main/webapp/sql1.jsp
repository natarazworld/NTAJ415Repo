<%@taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Setup date datasource  -->
<sql:setDataSource  var="ds" driver="oracle.jdbc.driver.OracleDriver"
                                  url="jdbc:oracle:thin:@localhost:1521:xe"
                                  user="system"
                                  password="manager"/>
                                  
<!-- Send and execute the SELECT SQL query -->
<sql:update dataSource="${ds}" var="count"  sql="UPDATE EMP SET SAL=SAL+? WHERE  JOB=?">
   <sql:param value="500"/>
   <sql:param>CLERK</sql:param>
</sql:update>

<b> ${count}  no.of records are updated</b>

 