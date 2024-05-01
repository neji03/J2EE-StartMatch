<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
	<link rel="stylesheet" href="./aboutus.css">
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
                  <c:if test="${sessionScope.IsPerson==null}">
                     <a href="./"> <button type="button" class="btn btn1" id="button1"  >
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentcolor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                          <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
                        </svg>
                        home
                      </button></a>
                      </c:if>
                      <c:if test="${sessionScope.IsPerson==1 or sessionScope.IsPerson==0}">
                     <a href="newsfeed.jsp"> <button type="button" class="btn btn1" id="button1"  >
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentcolor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                          <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
                        </svg>
                        home
                      </button></a>
                      </c:if>
                      <a href='./aboutus.jsp'><button type="button" class="btn btn2" id="button2">About Us</button></a>
                      <button type="button" class="btn btn3" id="button3" href='/contact-us'>Contact Us</button>
                    </div>
                    
                </div>
                </div>
        </div>
        <c:if test="${sessionScope.IsPerson==1 or sessionScope.IsPerson==0}">
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
                <img src="data:image/jpeg;base64,<c:out value='${sessionScope.Ppic}'/>" height="75" width="81" id="pdp" class="rounded-circle">
              </a>
        </div>
        </c:if>
        <c:if test="${sessionScope.IsPerson==null}">
        <div class="col-md-3 text-center col-sm-12" id="d3">
                     <a href='login.jsp'> <button type="button" class="btn btn1" id="button2">Login</button></a>
                     <a href='./signin.html'> <button type="button" class="btn btn3" id="button3">Sign in</button></a>
        </div>
        </c:if>
        
    </div>
    <section class="py-3 py-md-5">
    <div class="container">
      <div class="row gy-3 gy-md-4 gy-lg-0 align-items-lg-center">
        <div class="col-12 col-lg-6 col-xl-5">
          <img class="img-fluid rounded" loading="lazy" src="https://i.ibb.co/NmVzPcm/rajel.png" alt="About 1">
        </div>
        <div class="col-12 col-lg-6 col-xl-7">
          <div class="row justify-content-xl-center">
            <div class="col-12 col-xl-11">
              <h2 class="mb-3">Who Are We?</h2>
              <p class="lead fs-4 text-secondary mb-3">Our project consists of building StartMatch , a plateform dedicated to all actors in
                enterpreneurship, that can do the match-making between founder,co-founder or founderinvestor or investor-startup.</p>
              <p class="mb-5">We aim to create a dedicated and comprehensive platform
                specifically designed for the needs of entrepreneurs, founders, co-founders start-ups
                and investors.It provides a user-friendly platform where users can connect, collaborate,
                and grow together.</p>
              
            </div>
          </div>
        </div>
      </div>
      <br> <br>
      <h1 class="text-center">Meet Start-Match Team</h1>
      <br>
      <div class="row">

        <div class="card-group ">
          <div class="card custom-bg-transparent">
              <div class="card-body">
                  <div class="text-center">
                      <img class="image card-img img-fluid" src="https://i.ibb.co/tMZ4jMM/347245498-3570899629797993-7265237523852668848-n.jpg"/>
                  </div>
                  <div class=" text-center infos mt-3">
                      <div class="row person_name">
                          <span>Heithem Benmoussa</span>
                      </div>
                      <div class="row"><p class="text-center colored">Software engineer student</p></div>
                      <span></span>
                      <span class="pers_desc"> Highly interested in business foundation and expert in computer science</span>
                  </div>
              </div>
          </div>
          <div class="card custom-bg-transparent">
              <div class="card-body">
                  <div class="text-center">
                      <img class="image" src="https://i.ibb.co/xshP3Xn/1700506697307.jpg"/>
                  </div>
                  <div class=" text-center infos mt-3">
                      <div class="col person_name">
                          <span>Noor Mezni </span>
                      </div>
                      <div class="row"><p class="text-center colored">Software engineer student</p></div>
                      <span></span>
                      <span class="pers_desc"> Highly interested in business foundation and expert in computer science</span>
          
                  </div>
              </div>
          </div>
          <div class="card custom-bg-transparent">
              <div class="card-body">
                  <div class="text-center">
                      <img class="image" src="https://i.ibb.co/VwnTPGs/369736547-2617132981774773-7144331000088560904-n.jpg"/>
                  </div>
                  <div class=" text-center infos mt-3">
                      <div class="col person_name"><span>Oussema Guerriche</span></div>
                      <div class="row"><p class="text-center colored">Software engineer student</p></div>
                      <span></span>
                      <span class="pers_desc"> Highly interested in business foundation and expert in computer science</span>
                      
                  </div>
              </div>
          </div>
          <div class="card custom-bg-transparent">
              <div class="card-body">
                  <div class="text-center">
                      <img class="image" src="https://i.ibb.co/KWzNmpH/433987347-296998546624436-5529945561536646189-n.jpg"/>
                  </div>
                  <div class=" text-center infos mt-3">
                      <div class="row person_name">
                          <span>Neji Dridi</span>
                      </div>
                           <div class="row"><p class="text-center colored">Software engineer student</p></div>
                          <span></span>
                          <span class="pers_desc"> Highly interested in business foundation and expert in computer science</span>
                     
                      
                  </div>
              </div>
          </div>
        </div>
      </div>
      </div>
  </section>
  </div>
</body>