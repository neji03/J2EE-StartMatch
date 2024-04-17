package mvcModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Post;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class PostService
 */
@Stateless
@LocalBean
public class PostService {
	
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;

	
	public void addPost(Post post) { 
		
		em.persist(post);
	}

    /**
     * 
     */
    public PostService() {
        // TODO Auto-generated constructor stub
    }
    
 
    

	public List<Post> getAllPost() {
		List<Post> posts = new ArrayList<Post>();
		TypedQuery<Post> query = em.createNamedQuery("Post.findAll", Post.class);
		posts = query.getResultList();
		return posts;
	}

	public  Post getPostById(int idPost ) {
		Post post = new Post();
		TypedQuery <Post>  query = em.createNamedQuery("Post.findAllById",Post.class);
    	query.setParameter(1, idPost);
    	post=query.getSingleResult();
		return post;}
	
	public List<Post> getAllPostByTags(String tags) {
		List<Post> posts = new ArrayList<Post>();
		TypedQuery<Post> query = em.createNamedQuery("Post.findAllByTags", Post.class);
		query.setParameter(1, tags);
		posts = query.getResultList(); 
		return posts;}
	
	public List<Post> getAllPostByIdUser(int user_idUser) {
		List<Post> posts = new ArrayList<Post>();
		TypedQuery<Post> query = em.createNamedQuery("Post.findAllByIdUser", Post.class);
		query.setParameter(1, user_idUser);
		posts = query.getResultList(); 
		return posts;}
	
	

    
    

	/*public void setPost(String field, String mediaContent, int reactNb, int reportNb ,int savesNb, String tags, String textContent ,int user_idUser , Date dateOfCreation) {
		Query query = em.createNamedQuery("Post.addPost");
		query.setParameter(1, field);
		query.setParameter(2, mediaContent);
		query.setParameter(3, reactNb);
		query.setParameter(4, reportNb);
		query.setParameter(5, savesNb);
		query.setParameter(6, tags);
		query.setParameter(7, textContent);
		query.setParameter(8, user_idUser);
		query.setParameter(9, dateOfCreation);} */
	
	
	public String deletePostById(int idPost){
		List<Post> posts=new ArrayList<Post>();
    	TypedQuery <Post> query = em.createNamedQuery("Post.findAllById",Post.class);
    	query.setParameter(1, idPost);
    	posts=query.getResultList();
    	for (Post i : posts) {
    		em.remove(i);
    		return "post has been deleted successfully !";}
		return null;}
    	
   
    
    
    public String updatePost(Post updatedPost) {
        Post oldPost = em.find(Post.class, updatedPost.getIdPost());

        if (oldPost != null) {
        	if (updatedPost.getField()!=null)oldPost.setField(updatedPost.getField());
        	if (updatedPost.getMediaContent()!=null)oldPost.setMediaContent(updatedPost.getMediaContent());
        	if (updatedPost.getTags()!=null)oldPost.setTags(updatedPost.getTags());
        	if (updatedPost.getTextContent()!=null)oldPost.setTextContent(updatedPost.getTextContent());

            em.merge(oldPost);
            return "update done successfully ";
        } else {
        return "erreur";}
    }

	public void createPost(Post p) {
		em.persist(p);
		
	}
	

}
