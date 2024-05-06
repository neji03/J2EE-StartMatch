package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entites.Post;
import entites.Profil;
import entites.Utilisateur;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class UtilisateurService
 */
@Stateless
@LocalBean
public class UserService {
	@EJB
	private PostService postService;

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;
    public UserService() {
        // TODO Auto-generated constructor stub
    }
    public List<Utilisateur> getAllUtilisateurs()
    {
    List<Utilisateur> Utilisateurs = new ArrayList<Utilisateur>();
    TypedQuery<Utilisateur> query = em.createNamedQuery("Utilisateur.findAll",Utilisateur.class);
    Utilisateurs = query.getResultList();
    return Utilisateurs;
    }
    public List<Utilisateur> getUtilisateurByID(int idUtilisateur)
    {
	List<Utilisateur> Utilisateurs = new ArrayList<Utilisateur>();
	TypedQuery<Utilisateur> query = em.createNamedQuery("Utilisateur.findByID",Utilisateur.class);
	query.setParameter(1, idUtilisateur);
	Utilisateurs = query.getResultList();
	return Utilisateurs;
    }
    public List<Utilisateur> getUtilisateurByProfil(Profil p)
    {
	List<Utilisateur> Utilisateurs = new ArrayList<Utilisateur>();
	TypedQuery<Utilisateur> query = em.createNamedQuery("Utilisateur.findByProfil",Utilisateur.class);
	query.setParameter(1, p);
	Utilisateurs = query.getResultList();
	return Utilisateurs;
    }
    public void createUtilisateur(Utilisateur Utilisateur) {
		em.persist(Utilisateur);
	}
    /*public List<Utilisateur> deleteUtilisateurById(int idUtilisateur){
    	List<Utilisateur> Utilisateurs=new ArrayList<Utilisateur>();
    	Utilisateur u=em.find(Utilisateur.class, idUtilisateur);
    	if (u!=null) {
    		em.remove(u);
    	}
    	TypedQuery<Utilisateur> query=em.createNamedQuery("Utilisateur.findAll", Utilisateur.class);
    	Utilisateurs=query.getResultList();
    	return Utilisateurs;
    }*/
    public Utilisateur updateUtilisateur(Utilisateur u) {
    	Utilisateur Utilisateur= new Utilisateur();
    	TypedQuery<Utilisateur> query = em.createNamedQuery("Utilisateur.findByID",Utilisateur.class);
    	query.setParameter(1, u.getIdUser());
    	Utilisateur = query.getResultList().get(0);
    	if (u.getAddress()!="") {
    		Utilisateur.setAddress(u.getAddress());
    	}
    	if (u.getBio()!="") {
    		Utilisateur.setBio(u.getBio());
    	}
    	if (u.getCpic()!=null) {
    		Utilisateur.setCpic(u.getCpic());
    	}
    	if (u.getPpic()!=null) {
    		Utilisateur.setPpic(u.getPpic());
    	}
    	if (u.getEmail()!="") {
    		Utilisateur.setEmail(u.getEmail());
    	}
    	if(u.getPhone_Num()!=0)Utilisateur.setPhone_Num(u.getPhone_Num());
    	if(u.getField()!="") Utilisateur.setField(u.getField());
    	if(u.getIsPerson()!=1) {
    		if(u.getPDateOfBirth()!=null) Utilisateur.setPDateOfBirth(u.getPDateOfBirth());
        	if(u.getPExpertise()!="") Utilisateur.setPExpertise(u.getPExpertise());
        	if(u.getPFirst_name()!="")Utilisateur.setPFirst_name(u.getPFirst_name());
        	if(u.getPLast_name()!="")Utilisateur.setPLast_name(u.getPLast_name());
        	if(u.getPGender()!="")Utilisateur.setPGender(u.getPGender());
        	if(u.getPJobPostition()!="")Utilisateur.setPJobPostition(u.getPJobPostition());
    	}else {
    		if(u.getSDateOfCreation()!=null)Utilisateur.setSDateOfCreation(u.getSDateOfCreation());
    		if(u.getSName()!="")Utilisateur.setSName(u.getSName());
    	}
    	return Utilisateur;
    }
    public Utilisateur getUtilisateurByLoginAndPwd(String login, String pwd) {
    	Utilisateur u=null;
		TypedQuery<Utilisateur> query = em.createNamedQuery("Utilisateur.findByLoginAndPwd",Utilisateur.class);
		query.setParameter(1, login);
		query.setParameter(2, pwd);
		try {
		u = query.getSingleResult();
		}catch(Exception e) {
			u=null;
		}
		return u;
		
	}
    public String deleteUtilisateurById(int idUser) {
    	List<Utilisateur> utilisateurs=new ArrayList<Utilisateur>();
    	TypedQuery <Utilisateur> query = em.createNamedQuery("Utilisateur.findByID",Utilisateur.class);
    	
    	query.setParameter(1, idUser);
    	utilisateurs=query.getResultList();
    	//for (Utilisateur i : utilisateurs) {
    		//em.remove(i);
    		//return "utilisateur has been deleted successfully !";}
    	if( utilisateurs!=null){
    		 List<Post> posts_to_remove=postService.getAllPostByIdUser(idUser);
    		 if (!posts_to_remove.isEmpty()) {
	    		 for (Post p : posts_to_remove) {
	    			 em.remove(p);
	    		 }
    	}
    		em.remove(utilisateurs.get(0));
    	return ("utilisateur"+ idUser +"has been removed successfully");}
    	;
		return ("utilisateur"+ idUser +"can't be removed");
    	
    }
    public List<Utilisateur> getAllReportedUsers() {
  
    	List<Utilisateur> reported_people=new ArrayList<Utilisateur>();
    	TypedQuery <Utilisateur> query = em.createNamedQuery("Utilisateur.findBynbReports",Utilisateur.class);
        reported_people = query.getResultList();
        if(reported_people!=null)
    	return reported_people;
        else return null;
    }
    
    
}


