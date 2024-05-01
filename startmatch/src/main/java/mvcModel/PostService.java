package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entites.Post;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class PostService
 */
@Stateless
@LocalBean
public class PostService {
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;
    /**
     * Default constructor. 
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
	public String updatePostByText(String textContent,Post updatedPost) {
    	Post oldPost = em.find(Post.class, updatedPost.getIdPost());
    	if (oldPost!=null) {
    	oldPost.setTextContent(textContent);
    	em.merge(oldPost);
        return "update done successfully ";}
    	return "erreur";
    }public Post updateNbReports(int postId) {
        Post post = new Post();
        TypedQuery<Post> query = em.createNamedQuery("Post.findAllById", Post.class);
        query.setParameter(1, postId);
        post = query.getSingleResult();

        if (post != null) {
            int newNbReports = post.getReportNb() + 1;
            post.setReportNb(newNbReports);
            em.merge(post);
        }
        
        return post;
    }
    public void updatelike(Post post) {
        em.merge(post);
    }
	public List<Post> getReportedPost() {
		List<Post> posts = new ArrayList<Post>();
		TypedQuery<Post> query = em.createNamedQuery("Post.findReportedPost", Post.class);
		posts = query.getResultList();
		return posts;
	}
}
