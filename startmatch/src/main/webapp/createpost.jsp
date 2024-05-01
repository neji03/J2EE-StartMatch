<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./createpost.css">
</head>
<body>
<div class="container">
    <form action="Controller" method="get" >
    <div class="create-post-container">
        <div class="user">
        <div class="user-profile">
            <a link="/profile" ><img src="data:image/jpeg;base64,${user.ppic}" alt="user-pdp"></a>
        </div>
        <div class="post-input-container">
            <textarea class="form-control" name="textcontent" id="inputText" rows="3"  cols="43" placeholder="What's on your mind" required></textarea>

        </div></div>
        <div class="buttons">
        <div class="file-upload col-md-3">
            <input type="file"  id="fileInput" accept="image/*, video/*" name="mediacontent" style="display: none;">
            <label for="fileInput">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-upload" viewBox="0 0 16 16">
  <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5"/>
  <path d="M7.646 1.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 2.707V11.5a.5.5 0 0 1-1 0V2.707L5.354 4.854a.5.5 0 1 1-.708-.708z"/>
</svg> Photo/Video
            </label>
        </div>
        <div class="btn-group">
            <button class="btn btn-sm dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-briefcase" viewBox="0 0 16 16">
  <path d="M6.5 1A1.5 1.5 0 0 0 5 2.5V3H1.5A1.5 1.5 0 0 0 0 4.5v8A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-8A1.5 1.5 0 0 0 14.5 3H11v-.5A1.5 1.5 0 0 0 9.5 1zm0 1h3a.5.5 0 0 1 .5.5V3H6v-.5a.5.5 0 0 1 .5-.5m1.886 6.914L15 7.151V12.5a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5V7.15l6.614 1.764a1.5 1.5 0 0 0 .772 0M1.5 4h13a.5.5 0 0 1 .5.5v1.616L8.129 7.948a.5.5 0 0 1-.258 0L1 6.116V4.5a.5.5 0 0 1 .5-.5"/>
</svg> Type
            </button>
            <ul class="dropdown-menu">
                <li><input class="form-check-input" type="checkbox" id="founder" >Founder</li>
                <li><input class="form-check-input" type="checkbox" id="co-founder">Co-Founder</li>
                <li><input class="form-check-input" type="checkbox" id="investor">Investor</li>
            </ul>
               
        </div>
        <div class="btn-group">
            <button class="btn btn-sm dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-clipboard-check-fill" viewBox="0 0 16 16">
  <path d="M6.5 0A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0zm3 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5z"/>
  <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1A2.5 2.5 0 0 1 9.5 5h-3A2.5 2.5 0 0 1 4 2.5zm6.854 7.354-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708.708"/>
</svg> Fields
            </button>
            <ul class="dropdown-menu" id="a">
               <li><input class="form-check-input" type="checkbox" id="ai" >Artificial Intelligence </li>
                <li><input class="form-check-input" type="checkbox" id="energy">Renewable Energy</li>
                <li><input class="form-check-input" type="checkbox" id="cs">Cybersecurity</li> 
                <li><input class="form-check-input" type="checkbox" id="investor">Cybersecurity</li> 
                <li><input class="form-check-input" type="checkbox" id="health">Health and Wellness</li> 
                <li><input class="form-check-input" type="checkbox" id="FinTech">FinTech</li> 
                <li><input class="form-check-input" type="checkbox" id="education">Online Education</li> 
                <li><input class="form-check-input" type="checkbox" id="web">Web Development</li> 
                <li><input class="form-check-input" type="checkbox" id="AgriTech">AgriTech</li> 
                <li><input class="form-check-input" type="checkbox" id="commerce">E-commerce</li> 
            </ul>
               
        </div>
        <button type="submit" id="btnPost" name="myBtn" value="insert post" class="btn btn-primary butt">Post</button>
    </div>
</div> 

</form></div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>