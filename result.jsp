<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Page Title(s)</title>
</head>
<body>

<h1>Web Page Title(s): </h1>

<%
	// create another array list and set it equal to one made in servlet
	// have to use type casting because it will only recognize as an object
	List<String> List = (ArrayList<String>)request.getAttribute("myList");

	// loop through array list and print out value(title of web page)
	int i;
	for(i=0;i<List.size();i++){
		out.println(List.get(i));
		out.println("<br><br>");
	}

%>



</body>
</html>