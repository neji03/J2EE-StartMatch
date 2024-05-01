package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entites.Profil;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class ProfilService
 */
@Stateless
@LocalBean
public class ProfilService {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;
    public ProfilService() {
        // TODO Auto-generated constructor stub
    }
    public void createProfil(Profil p) {
		em.persist(p);
		
	}
	public List<Profil> getAllProfils() {
		{
		    List<Profil> profils = new ArrayList<Profil>();
		    TypedQuery<Profil> query = em.createNamedQuery("Profil.findAll",Profil.class);
		    profils = query.getResultList();
		    return profils;
		    }
	}
	public List<Profil> getProfilByLogin(String login) {
		{
			List<Profil> Profils = new ArrayList<Profil>();
			TypedQuery<Profil> query = em.createNamedQuery("Profil.findByLogin",Profil.class);
			query.setParameter(1, login);
			Profils = query.getResultList();
			return Profils;
		    }
	}
	public List<Profil> getProfilByIdProfil(int id) {
		{
			List<Profil> Profils = new ArrayList<Profil>();
			TypedQuery<Profil> query = em.createNamedQuery("Profil.findById",Profil.class);
			query.setParameter(1, id);
			Profils = query.getResultList();
			return Profils;
		    }
	}
}
