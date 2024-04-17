package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.Newsfeed;
import entities.Newsfeed;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class NewsfeedService
 */
@Stateless
@LocalBean
public class NewsfeedService {
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public NewsfeedService() {
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
