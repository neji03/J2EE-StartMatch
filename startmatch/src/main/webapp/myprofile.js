document.addEventListener('DOMContentLoaded', function() {
    var postHtml = `
        <div class="col-6" style="margin-left: 25%; margin-top:50px">
            <div class="card mb-3">
                <div class="card-body">
                    <div class="flexy">
                        <a href=""><img class="img-fluid eclipse" src="../../../assets/347245498_3570899629797993_7265237523852668848_n.jpg" alt="person/startup_img"></a>
                        <div class="flexy-1">
                            <a style="color:black ; text-decoration:none; " href='./myprofile.html'><span class="name">Heithem Benmoussa</span></a>
                            <span class="person-description">computer science engineer</span>
                            <span class="person-description">10 avril 2024</span>
                        </div> 
                    </div>
                </div>
                <span class="status badge badge-pill badge-warning" *ngIf="post.status==='founder'">Founder</span>
                <div class="card-body pos">
                    <div class="text_of_post col-12 mt-2">
                        <a href="" class="text-dark" style="text-decoration:none;"><p class="font">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nemo nobis dolores sint expedita debitis quibusdam totam, molestias adipisci maiores officia quod illo at rem consequuntur. Voluptatum maiores ea officiis accusamus.</p></a>
                    </div>
                    <div class="mb-3 ">
                        <a href="#"><img class="card-img-bottom " src="../../../assets/beautiful-african-american-woman-cafe_273609-5355.jpg"></a>
                    </div>
                    <div class="flexy-2">
                        <button type="button" class="btn btn-success" name="updatePost">update</button>
                        <button type="button" class="btn btn-danger" name="deletePost">delete</button>
                    </div>
                </div>
            </div>
        </div>
    `;
    document.getElementById('posts').innerHTML = postHtml;
});