<%--
  Created by IntelliJ IDEA.
  User: zhongpu
  Date: 3/3/21
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.swufe.javaee.beerV1.model.Beer" %>
<html>
<head>
    <title>Beer Recommended JSP</title>
</head>
<body>
<%
    List<Beer> styles = (List<Beer>) request.getAttribute("styles");
    System. out.println("<br/>Here are the recommendations：<br/>");
    Iterator it=styles.iterator();
    for (Beer brand: styles){
        System.out.print("<br/>try: "+brand.showbrand());
        System. out.print("<br/>Year of birth: "+brand.showyear());
        System.out.print("<br/>Country: "+brand.showcountry());
        System.out.print("<br/><br/>");
    }
%>

</body>
</html>