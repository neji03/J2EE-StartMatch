<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ControllerD" method="get">

<label for="login" style="color: rgb(255, 255, 255);">Enter your email address:</label>
                            <input required  type="text" class="form-control" name=login id="login" style="background:#ffffff;">
                       <label for="pswd" style="color: rgb(255, 255, 255);">Enter your Password:</label>
                            <input required  type="text" class="form-control" name=password id="pswd" style="background:#ffffff;" pattern=".{5,}" >
                      <input type="submit" class="btn " style="margin-top: 30px; width:100%; background: #f17928 ;color:white" name="myBtn" value="Login">
                       
                
                        
                        </form>

</body>
</html>