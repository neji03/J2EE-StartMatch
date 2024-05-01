package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entites.Newsfeed;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class NewsFeedService
 */
@Stateless
@LocalBean
public class NewsFeedService {
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public NewsFeedService() {
        // TODO Auto-generated constructor stub
    }
    public void createNewsfeed(Newsfeed n) {
		em.persist(n);
		
	}
	public List<Newsfeed> getAllNews() {
		{
		    List<Newsfeed> newsfeeds = new ArrayList<Newsfeed>();
		    TypedQuery<Newsfeed> query = em.createNamedQuery("Newsfeed.findAll",Newsfeed.class);
		    newsfeeds = query.getResultList();
		    return newsfeeds;
		    }
	}
}
