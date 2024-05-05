<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
       <link href="./headernews.css" rel="stylesheet">
        <link rel="stylesheet" href="./navbarnews.css">
        <link rel="stylesheet" href="./managepost.css">
        <style>
        body{
            background-image: url("https://i.ibb.co/yB0zp7s/ba.png");
    background-repeat: no-repeat; 
    background-position: center;
    background-attachment: fixed;
    background-size: cover;
        }
    </style>
</head>
<body>
<!-- DEBUT DE NAVBAR DYNAMIQUE -->
	<!--  <link href="./headernews.component.css" rel="stylesheet">-->
<div class="container-fluid py-3" id="d1">

<div class="container-fluid py-3" id="d1" >
    <div class="row d-flex align-items-center ">
        <div class="col-sm-3 col-md-4 text-center">
            <a href="./"><h1>Start-Match</h1></a>
           <a href='./'> <h6>Start your enterneurship journey</h6></a>
        </div>
        <div class="col-md-5 text-center">
           <!-- <app-navbarnews></app-navbarnews>-->
               
                <nav>
                <div class="container" id="navbarNavAltMarkup">
                    <div class="row">
                    <div class="col d-flex align-items-center">
                                <button type="button" class="btn btn1" id="button1" >
                                    <a href='./newsfeed.jsp'>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentcolor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                            <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
                            </svg>
                            home</a>
                        </button>
                        <a href='./aboutus.jsp'><button type="button" class="btn btn2" id="button2">About Us</button></a>
                        <button type="button" class="btn btn2" id="button3" href='/contactus2'>Contact Us</button>
                        <form class="ms-3" >
                        <div class="input-group">
                            <span class="input-group-text">
                            <a href="/search" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                            </svg></a>
                        </span>
                            <input type="search" class="form-control inp1" id="input1" placeholder="Search anything">
                        </div>
                        </form>
                        </div>
                        
                    </div>
                    </div>
                </nav>
        </div>
        <div class="col-md-2 text-center" id="profile-name">
            <form action="Controller">
           
            <c:if test="${sessionScope.IsPerson==1}">
                <button type=submit name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"value="Consultmyprofil"><h6><c:out value="${sessionScope.PFirst_name} ${sessionScope.PLast_name}"/></h6></button>
            </c:if>
            <c:if test="${sessionScope.IsPerson==0}">
                <button type=submit name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"value="Consultmyprofil" ><h6><c:out value="${sessionScope.SName}"/></h6></button>
            </c:if>
            </form>
        </div>
        <div class="col-md-1 text-center">
            <a href='./profile'>
                <img onerror="this.src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvqpd02ludas5XSdN3U-lPz8RRX1MtI8Fc4I_Ib-A8tQ&s%27;%22%3E'" src="data:image/jpeg;base64,<c:out value='${sessionScope.Ppic}'/>" height="75" width="81" id="pdp" class="rounded-circle">
              </a>
        </div>
    </div>
</div>
</div>
<!-- FIN DE NAVBAR DYNAMIQUE -->
 <div class="row mt-3">
                      
<link rel="stylesheet" href="./suggested.css">
<div class="col-3 offset-1" style="margin-bottom: 20px;">
    <div class="col">
        <div class="card cus-bg" style="width: 18rem;">
            <!-- <img src="../../assets/back.png" class="card-img" alt="...">
            <div class="card-img-overlay"> -->
                <div class="card-header cus-bg">
                  <br>
                  <h4> suggested for you </h4>
                  </div>
                <ul class="list-group list-group-flush cus-bg">
				  <c:forEach var="utilisateur" items="${sessionScope.users}">
				    
				      <li  class="list-group-item cus-bg">
				        <div class="row">
				          <div class="col-2 align-items">
				            <a href="/OtherPorfile"><img onerror="this.src='https://design.ncsu.edu/doctor-of-design/wp-content/uploads/sites/7/2021/07/late-career-persona-philip.jpg'" src="data:image/jpeg;base64,<c:out value='${utilisateur.ppic}'/>"  height="45" width="51" id="pdp" class="rounded-circle" ></a>
				          </div>
				          <div class="col align-items">
				            <form action="Controller" method="get">
                        <input type="number" value="${utilisateur.idUser}" name="iduser" style="display: none;"><br/>
                        <c:if test="${utilisateur.isPerson==1}">
                    <button type="submit" value="consult other" name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"> ${utilisateur.PFirst_name} ${utilisateur.PLast_name} </button>
                    </c:if>
                    <c:if test="${utilisateur.isPerson==0}">
                    <button type="submit" value="consult other" name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"> ${utilisateur.SName}</button>
                    </c:if>
                        
                  </form > 
				          </div>
				        </div>
				      </li>
				    
				  </c:forEach>
				</ul>
                

           </div>
    </div>
  </div>
  <!-- FIN DE SUGGESTED FOR YOU -->
<!-- DEBUT DE CREATE POST+POST AFF -->
  <div class="col-lg-6 ">
        <div class="container">
    <form action="ControllerUpload" enctype="multipart/form-data" method="post" >
    <div class="create-post-container" style="background-color:white;">
        <div class="user">
        <div class="user-profile">
            <a link="/profile" ><img onerror="this.src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvqpd02ludas5XSdN3U-lPz8RRX1MtI8Fc4I_Ib-A8tQ&s%27;%22%3E'" src="data:image/jpeg;base64,${sessionScope.Ppic}" width="70"   class="rounded-circle" alt="user-pdp"></a>
        </div>
        <input type=text value="${sessionScope.user}" name="iduser" style="display:none;">
        <div class="post-input-container">
            
            <textarea class="form-control" name="textcontent" id="inputText" rows="3"  cols="43" placeholder="What's on your mind" required></textarea>
			
        </div></div>
        <div class="buttons">
        <div class="file-upload btn-group col-md-3">
            <input type="file"  id="fileInput" accept="image/*, video/*" name="file" style="display: none;">
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
                <li><input class="form-check-input" type="checkbox" name="tag" id="founder" >Founder</li>
                <li><input class="form-check-input" type="checkbox" name="tag" id="co-founder">co-founder</li>
                <li><input class="form-check-input" type="checkbox" name="tag" id="investor">Investor</li>
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
               <li><input class="form-check-input" type="checkbox" name="field" id="ai" >Artificial Intelligence </li>
                <li><input class="form-check-input" type="checkbox" name="field" id="energy">Renewable Energy</li>
                <li><input class="form-check-input" type="checkbox" name="field" id="cs">Cybersecurity</li> 
                <li><input class="form-check-input" type="checkbox" name="field"id="health">Health and Wellness</li> 
                <li><input class="form-check-input" type="checkbox" name="field" id="FinTech">FinTech</li> 
                <li><input class="form-check-input" type="checkbox" name="field" id="education">Online Education</li> 
                <li><input class="form-check-input" type="checkbox" name="field" id="web">Web Development</li> 
                <li><input class="form-check-input" type="checkbox" name="field" id="AgriTech">AgriTech</li> 
                <li><input class="form-check-input" type="checkbox" name="field" id="commerce">E-commerce</li> 
            </ul>
               
        </div>
        <button type="submit" id="btnPost" name="myBtn" value="insert post" class="btn btn-primary butt">Post</button>
    </div>
</div> 

</form></div>
        <div></div>
        
        <c:forEach var="post" items="${posts}">
            <c:if test="${post.utilisateur.idUser==sessionScope.user}">
                
                 <div class="card-body">
            			<div class="container">
    <div class="card mb-3">
        <div class="card-body">
            <div class="flexy">
                <img  href='/OtherPorfile' onerror="this.src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvqpd02ludas5XSdN3U-lPz8RRX1MtI8Fc4I_Ib-A8tQ&s%27;%22%3E'" class="img-fluid eclipse"  src="data:image/jpeg;base64,${ sessionScope.ppic}" alt="person/startup_img">
                <div class="flexy-1">
                <form action="Controller" method="get">
                        <input type="number" value="${post.utilisateur.idUser}" name="iduser" style="display: none;"><br/>
                        <c:if test="${post.utilisateur.isPerson==1}">
                    <button type="submit" value="Consultmyprofil" name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"> ${post.utilisateur.PFirst_name} ${post.utilisateur.PLast_name} </button>
                    </c:if>
                    <c:if test="${post.utilisateur.isPerson==0}">
                    <button type="submit" value="Consultmyprofil" name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"> ${post.utilisateur.SName}</button>
                    </c:if>
                        
                  </form > 
                    <span class="person-description">${post.utilisateur.field}</span>
                    <span class="person-description">${post.dateOfCreation}</span>
                </div> 
            </div>
        </div>
        <c:if test="${post.tags=='founder'}">
        	<span class="status badge badge-pill badge-warning">founder</span>
        </c:if>
        <c:if test="${post.tags=='co-founder'}">
        	<span class="status1 badge badge-pill badge-warning">co-founder</span>
        </c:if>
       
        <div class="card-body pos">
            <div class="text_of_post col-12 mt-2">
                <a href='/consultpost' class="text-dark" style="text-decoration:none;"><p class="font">${post.textContent}</p></a>
            </div>
        <div class="mb-3 ">
           <a href='/consultpost'> <img  class="card-img-bottom " onerror="this.src='https://cloudinary.hbs.edu/hbsit/image/upload/s--5YPcmM0m--/f_auto,c_fill,h_375,w_750,/v20200101/681DA2E060F4CEE9AA1C606DE6117A9E.jpg'" src= "data:image/jpeg;base64,${post.mediaContent}"/></a>
        </div>

        <div class="flexy-2">
               <form method="post" action="<c:url value='Controller_update'/>">
               <a><input type="submit" class="btn btn-success" name="updateBtn1"   data-post-id="${post.idPost}" value="update" ></a>
                <input type="hidden"  name="sel_post"   value="${post.idPost}"/>
           </form>
           <form method="post" action="<c:url value='Controllerdelete'/>">
                    <input type="hidden"  name="del_post"   value="${post.idPost}"/>
                    <input type="submit" class="btn btn-danger" name="deleteBtn" value="delete" >
                </form>
        </div>
         
       
       
    </div>
</div></div>
        </div>
            </c:if>
            <c:if test="${post.utilisateur.idUser!=sessionScope.user}">
                <div class="card-body">
            			<div class="container">
    <div class="card mb-3">
        <div class="card-body">
            <div class="flexy">
            
                <img  href='/OtherPorfile' class="img-fluid eclipse" onerror="this.src='https://design.ncsu.edu/doctor-of-design/wp-content/uploads/sites/7/2021/07/late-career-persona-philip.jpg'" src="data:image/jpeg;base64,${post.utilisateur.ppic}" alt="person/startup_img">
                <div class="flexy-1">
                <form action="Controller" method="get">
                        <input type="number" value="${post.utilisateur.idUser}" name="iduser" style="display: none;"><br/>
                        <c:if test="${post.utilisateur.isPerson==1}">
                    <button type="submit" value="consult other" name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"> ${post.utilisateur.PFirst_name} ${post.utilisateur.PLast_name} </button>
                    </c:if>
                    <c:if test="${post.utilisateur.isPerson==0}">
                    <button type="submit" value="consult other" name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"> ${post.utilisateur.SName}</button>
                    </c:if>
                        
                  </form > 
                    <span class="person-description">${post.utilisateur.field}</span>
                    <span class="person-description">${post.dateOfCreation}</span>
                </div> 
            </div>
        </div>
        <c:if test="${post.tags=='founder'}">
        	<span class="status badge badge-pill badge-warning">founder</span>
        </c:if>
        <c:if test="${post.tags=='co-founder'}">
        	<span class="status1 badge badge-pill badge-warning">co-founder</span>
        </c:if>
       
        <div class="card-body pos">
            <div class="text_of_post col-12 mt-2">
                <a href='/consultpost' class="text-dark" style="text-decoration:none;"><p class="font">${post.textContent}</p></a>
            </div>
        <div class="mb-3 ">
           <a href='/consultpost'> <img onerror="this.src='https://cloudinary.hbs.edu/hbsit/image/upload/s--5YPcmM0m--/f_auto,c_fill,h_375,w_750,/v20200101/681DA2E060F4CEE9AA1C606DE6117A9E.jpg'" class="card-img-bottom " src= "data:image/jpeg;base64,${post.mediaContent}"/></a>
        </div>

        <div class="flexy-2">
               <form method="post" action="<c:url value='Controller'/>">
				    <input type="hidden"  name="likePost"   value="${post.idPost}"/>
				    <input type="submit" class="btn btn-success" name="myBtn" value="Like" > 
				</form> 
                <form method="post" action="<c:url value='Controller'/>">
                    
                    <button type="submit" class="btn btn-danger" name="myBtn" value="report post">Report</button>
                    <input type="number" name="idpost" value="${post.idPost}" style="display: none;"><br/>
                    </form >
                    
        </div>
         
       
       
    </div>
</div></div>
        </div>
            </c:if>
            
          </c:forEach>
          
        
    </div>
    
 </div>


     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>