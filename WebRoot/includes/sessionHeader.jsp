<%@page import="java.util.*"%>
<%@page import="com.peniel.beans.SessionBean"%>
<%@page import="org.apache.commons.lang.*"%>

<%
try{
  String sessionId = "";
  
  int id = -1;
  
  if(!StringUtils.isBlank((String)request.getSession().getAttribute("sessionid")))
  {
  	sessionId = (String)request.getSession().getAttribute("sessionid");
  	System.out.println("sessionId from session-->"+sessionId);
  	id = SessionBean.checkSession(sessionId);
  }
  else if(!StringUtils.isBlank((String)request.getParameter("sessionid")))
  {
  	sessionId = (String)request.getParameter("sessionid");
  	System.out.println("sessionId from parameter-->"+sessionId);
  	id = SessionBean.checkSession(sessionId);
  }
  else if(!StringUtils.isBlank((String)request.getAttribute("sessionid")))
  {
  	sessionId = (String)request.getAttribute("sessionid");
  	System.out.println("sessionId from getAttribute-->"+sessionId);
  	id = SessionBean.checkSession(sessionId);
  }


  if ( id <= -1) 
  {
	RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	rd.forward(request, response); 
  }
}catch(Exception ex){
	response.sendRedirect("index.jsp");
}
%>


