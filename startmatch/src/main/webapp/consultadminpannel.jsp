<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma", "no-cache");
  response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="refresh" content="40">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
       <link href="./headernews.css" rel="stylesheet">
        <link rel="stylesheet" href="./navbarnews.css">
     <style>
     li{
    background-color: rgba(235, 190, 190, 0.79);
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
            
           
            
                <h6><c:out  value="${sessionScope.admin.name}" /></h6>
            
        </div>
        <div class="col-md-1 text-center">
            
                <img src="https://i.ibb.co/vskgtL4/admin.png" height="75" width="81" id="pdp" class="rounded-circle">
              
        </div>
    </div>
</div>
</div>
<!-- FIN DE NAVBAR DYNAMIQUE -->
 <div class="row mt-3">
                      
<link rel="stylesheet" href="./suggested.css">
<div class="col-3 offset-1" style="margin-bottom: 20px;">
    <div class="col-5">
        <div class="card cus-bg" style="width: 18rem;">
            <!-- <img src="../../assets/back.png" class="card-img" alt="...">
            <div class="card-img-overlay"> -->
                <div class="card-header cus-bg">
                  <br>
                  <h4> Reported List </h4>
                  </div>
                <ul class="list-group list-group-flush cus-bg">
				  <c:forEach var="utilisateur" items="${sessionScope.users}">
				    <c:if test="${sessionScope.PFirst_name != utilisateur.PFirst_name && utilisateur.account.reportsNb!=0 }">
				      <li  class="list-group-item cus-bg">
				       <!-- <div class="row">
				            <div class="col-3 align-items">
				            <a href="/OtherPorfile"><img id="hh" src="data:image/jpeg;base64,<c:out value='${utilisateur.ppic}'/>" data-p-gender="${utilisateur.PGender}" onerror="this.src='https://design.ncsu.edu/doctor-of-design/wp-content/uploads/sites/7/2021/07/late-career-persona-philip.jpg';" height="45" width="51" id="pdp" class="rounded-circle" ></a>
				          </div>
				          <div class="col align-items">
				            <a href="/OtherPorfile.jsp" style="text-decoration: none; color: black;"><p  style="margin-top: 11px;" id="profile-name">${utilisateur.PFirst_name} ${utilisateur.PLast_name}</p></a>
				          </div>
				        </div>-->
				        <div class="row">                        
				        <div class="col-3 align-items">
                         <a href="/OtherPorfile"><img id="hh" src="data:image/jpeg;base64,<c:out value='${utilisateur.ppic}'/>" data-p-gender="${utilisateur.PGender}" onerror="this.src='https://design.ncsu.edu/doctor-of-design/wp-content/uploads/sites/7/2021/07/late-career-persona-philip.jpg';" height="45" width="51" id="pdp" class="rounded-circle" ></a>
                      </div>
                        <div class="col-6 align-items">
                             <a href="/OtherPorfile.jsp" style="text-decoration: none; color: black;"><p  style="margin-top: 11px;" id="profile-name">${utilisateur.PFirst_name} ${utilisateur.PLast_name}</p></a>
                        </div>
                        <div class="col-3 align-items">
                           <input type="submit"  class="btn btn-danger" style="background-color: height:40px;" value="delete">
                          </div> 
                      </div>
				      </li>
				    </c:if>
				  </c:forEach>
				</ul>
                

           </div>
    </div>
  </div>
  <!-- FIN DE SUGGESTED FOR YOU -->
<!-- DEBUT DE CREATE POST+POST AFF -->
  <div class="col-lg-6 ">
  
       <!--   <app-create-post></app-create-post><br>-->
        <div></div>
        <link rel="stylesheet" href="./managepost.css">
        <c:forEach var="post" items="${reportedposts}">
           
                <!--  <app-postmanage [post]="post"></app-postmanage>-->
                 <div class="card-body">
            			<div class="container">
    <div class="card mb-3">
        <div class="card-body">
            <div class="flexy">
                <img  href='/OtherPorfile' class="img-fluid eclipse"  src="post.picture" alt="person/startup_img" onerror="this.src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvqpd02ludas5XSdN3U-lPz8RRX1MtI8Fc4I_Ib-A8tQ&s';">
                <div class="flexy-1">
                    <span href='./ConsultMyprofile.jsp' class="name">${post.utilisateur.PFirst_name} ${post.utilisateur.PLast_name}</span>
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
           <a href='/consultpost'> <img onerror="this.src='https://cloudinary.hbs.edu/hbsit/image/upload/s--5YPcmM0m--/f_auto,c_fill,h_375,w_750,/v20200101/681DA2E060F4CEE9AA1C606DE6117A9E.jpg'"  class="card-img-bottom " src= "${post.mediaContent}" /></a>
        </div>

        <div class="flexy-2">
               <form method="post" action="<c:url value='Controllerdeleteadmin'/>">
				    <input type="hidden"  name="del_postadmin"   value="${post.idPost}"/>
				    <input type="submit" class="btn btn-danger" name="deleteBtnad" value="delete" >
				</form>     
        </div>
        
         
       
       
    </div>
</div></div>
        </div>
      
                
          </c:forEach>
          
      
    </div>
    
 </div>

<script>
 function updatePost(idpost){
	 
	 
	// alert(idpost);
 }
 	let imageErrors={}
	 function fallbackImage(img, isError) {
		    if (isError) {
		      imageErrors[img.src] = true;
		    }

		    if (!imageErrors[img.src]) {
		      const gender = img.dataset.pGender;

		      if (gender === 'H') {
		        img.src = "https://design.ncsu.edu/doctor-of-design/wp-content/uploads/sites/7/2021/07/late-career-persona-philip.jpg";
		      } else {
		        img.src = "https://img.freepik.com/premium-vector/woman-avatar-profile-round-icon_24640-14047.jpg?w=360";
		      }
		    }
		  }
 
</script>
     
</body>
</html>