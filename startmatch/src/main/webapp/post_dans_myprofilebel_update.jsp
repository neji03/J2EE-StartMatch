<div class="card-body">
            			<div class="container">
    <div class="card mb-3">
        <div class="card-body">
            <div class="flexy">
                <img  href='/OtherPorfile' class="img-fluid eclipse"  [src]="post.picture" alt="person/startup_img">
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
           <a href='/consultpost'> <img  class="card-img-bottom " [src]= "post.media_content"/></a>
        </div>

        <div class="flexy-2">
               <a [href]="['/updatepost',post.id_post]"><button type="button" class="btn btn-success" (click)="recuperer_id()">update</button></a>
                <button type="button"  class="btn btn-danger">delete</button>
        </div>
         
       
       
    </div>
</div></div>
        </div>