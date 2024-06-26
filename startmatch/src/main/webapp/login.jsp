<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign as Startup </title>
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./formpersonstyle.css">
    <style>
        body{
            background-image: url("https://t4.ftcdn.net/jpg/02/81/89/73/360_F_281897358_3rj9ZBSZHo5s0L1ug7uuIHadSxh9Cc75.jpg");
    background-repeat: no-repeat; 
    background-position: center;
    background-attachment: fixed;
    background-size: cover;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row d-flex align-items-center" id="d1">
        <div class="col-sm-12 col-md-4 text-center">
            <h1>Start-Match</h1>
            <h6>Start your enterneurship journey</h6>
        </div>
        <div class="col-md-5 text-center col-sm-12" id="nav">
            <div class="container" id="navbarNavAltMarkup">
                <div class="row">
                  <div class="col d-flex align-items-center">
                     <a href="./"> <button type="button" class="btn btn1" id="button1"  >
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentcolor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                          <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
                        </svg>
                        home
                      </button></a>
                      <a href='./aboutus.jsp'><button type="button" class="btn btn2" id="button2">About Us</button></a>
                      <button type="button" class="btn btn3" id="button3" href='/contact-us'>Contact Us</button>
                    </div>
                    
                </div>
                </div>
        </div>
        <div class="col-md-3 text-center col-sm-12" id="d3">
                     <a href='login.jsp'> <button type="button" class="btn btn1" id="button2">Login</button></a>
                     <a href='./signin.html'> <button type="button" class="btn btn3" id="button3">Sign in</button></a>
        </div>
    </div>
    <br><br><br>
    
    <div class="card">
        <br> 
        <div class="row">
            <div class="col offset-2">
                <br> 
        <h3 style="margin-left: 3rem; color: rgb(34, 99, 221)">Login with StartMatch</h3>
            </div>
                <form class="was-validated" action="Controller" method="post">
                    <div class="row">
                        <div class="col-sm-9 col-lg-8 offset-2">
                            <label for="login" style="color: rgb(255, 255, 255);">Enter your email address:</label>
                            <input required  type="text" class="form-control" name=login id="login" style="background:#ffffff;">
                        </div></div>
                        <div class="row">
                            <div class="col-sm-9 col-lg-8 offset-2">
                            <label for="pswd" style="color: rgb(255, 255, 255);">Enter your Password:</label>
                            <input required  type="text" class="form-control" name=password id="pswd" style="background:#ffffff;" pattern=".{5,}" >
                         </div></div>
                         
                        <a href=""><p style="color: rgb(227, 109, 54); margin-left: 70%; margin-top: 10px;">Forgot password ?</p></a>
                            <div class="col-sm-9 col-lg-8 offset-2">
                                <input type="submit" class="btn " style="margin-top: 30px; width:100%; background: #f17928 ;color:white" name="myBtn" value="Login">
                        </div>
        
                        <div style="margin-left: 40%; margin-top: 50px;">
                            <p style="color: rgb(209, 209, 209); display: inline;">No account ?</p>
                            <a href='./signin.html' id="signUp"><p style="color: rgb(227, 109, 54); margin-left: 3px; margin-top: 10px; display: inline;">Sign Up</p></a>
                        </div>
        
                        
                        </form>
</div>
    </div>
    
</body>
</html>