<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
                        <a href='/about-us'><button type="button" class="btn btn2" id="button2">About Us</button></a>
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
                <button type=submit name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"value="Consultmyprofil"><h6><c:out  value="${sessionScope.PFirst_name} ${sessionScope.PLast_name}" /></h6></button>
            </c:if>
            <c:if test="${sessionScope.IsPerson==0}">
                <button type=submit name=myBtn  class="btn" style="margin-left: -10px;  margin-top: -45px;"value="Consultmyprofil" ><h6><c:out value="${sessionScope.SName}" /></h6></button>
            </c:if>
            </form>
        </div>
        <div class="col-md-1 text-center">
            <a href='./profile'>
                <img src="data:image/jpeg;base64,<c:out value='${sessionScope.Ppic}'/>" height="75" width="81" id="pdp" class="rounded-circle">
              </a>
        </div>
    </div>
</div>
</div>
<!-- FIN DE NAVBAR DYNAMIQUE -->

 <div class="row " id="d2">

            <div class="col-md-12 cover-photo">
                <img src="data:image/jpeg;base64,<c:out value='${sessionScope.Cpic}'/>" style="box-shadow:rgb(71, 90, 106) 3px 3px 6px 0px;" height="200px" width="100%" >
  
            </div>
            <div class="offset-md-5 col-md-2 text-center"id="pdp2">
                <img src="data:image/jpeg;base64,<c:out value='${sessionScope.Ppic}'/>" style="box-shadow:rgb(71, 90, 106) 3px 3px 6px 0px;" height="75" width="81"  class="rounded-circle" >
            
            </div>
        </div>
        <div class="row " id="name">
            <div class="offset-md-4 col-md-4 text-center">
            <!-- NOM DU USER -->
            
            <c:if test="${sessionScope.IsPerson==1}">
                <h4><c:out value="${sessionScope.PFirst_name} ${sessionScope.PLast_name}"/></h4>
            </c:if>
            <c:if test="${sessionScope.IsPerson==0}">
                <h4><c:out value="${sessionScope.SName}"/></h4>
            </c:if>
            </div>
        </div>
         <!-- FIN DU NOM  USER -->
        <div class="row " id="bio">
            <div class="offset-md-4 col-md-4 text-center">
                <p style="text-align: center;">
                    ${sessionScope.Field}<br/>
                    ${sessionScope.Bio}
                </p>
                <button type="button" class="btn btn-danger" name="myBtn" value="delete user">Delete</button>
                <button type="button" class="btn btn-success" name="myBtn" value="update startup">Update</button>


        </div></div>
        <div class="row " id="posts">
          <div class="col-6" style="margin-left: 25%; margin-top:50px">
	            <c:forEach var="post" items="${posts}">
				    <c:if test="${post.utilisateur.idUser==sessionScope.user}">
				        
				                <div class="card mb-3">
				                    <div class="card-body">
				                        <div class="flexy">
				                            <img href='/OtherPorfile' class="img-fluid eclipse" src="${post.picture}" alt="person/startup_img">
				                            <div class="flexy-1">
				                                <span href='/OtherPorfile' class="name">${post.utilisateur.PFirst_name} ${post.utilisateur.PLast_name}</span>
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
				                            <a href='/consultpost'><img class="card-img-bottom"    src="data:image/jpeg;base64,${post.media_content}" /></a>
				                        </div>
				                        <div class="flexy-2">
				                            <form method="post" action="<c:url value='Controller_update'/>">
               										<a><input type="submit" class="btn btn-success" name="updateBtn1"  data-post-id="${post.idPost}" value="update" onclick="updatePost(this,true)"></a>
               										 
                										<input type="hidden"  name="sel_post"   value="${post.idPost}"/>
           									</form>
           									<form method="post" action="<c:url value='Controllerdelete'/>">
                    							<input type="hidden"  name="del_post"   value="${post.idPost}"/>
                    							<input type="submit" class="btn btn-danger" name="deleteBtn" value="delete" >
               							    </form>
				                            
				                        </div>
				                    </div>
				                </div>
				                </c:if>
				                </c:forEach>
				            </div>
				     
				    
				
               
                 
               
               
            </div>
       

</body>
</html>
