
 <h1 style='color:red;text-align:center'>  Jsp implicit objs information</h1>

  out object class name <%=out.getClass() %>  <br>
  request object class name <%=request.getClass() %>  <br>
  response object class name <%= response.getClass() %>  <br>
  application object class name <%=application.getClass() %>  <br>
  config object class name <%=config.getClass() %>  <br>
  session  obj class name <%=session.getClass() %>  <br>
  page object class name <%=page.getClass() %>  <br>
  pageContext object class name <%=pageContext.getClass() %>  <br>
  
  <%!
         public void jspInit(){
	 //   System.out.println("application obj class name::"+application.getClass());
	   // System.out.println("config obj class name::"+config.getClass());
	      ServletConfig cg=getServletConfig();
	      ServletContext sc=getServletContext();
		 System.out.println("application obj class name::"+sc.getClass()+"   "+sc.hashCode());
	    System.out.println("config obj class name::"+cg.getClass()+"   "+cg.hashCode());
       }   
    %>
     <b> driver loaded</b>
   application object class name <%=application.getClass() %>   <%=application.hashCode() %> <br>
  config object class name <%=config.getClass() %>  <%=config.hashCode() %> <br>
  
     
     